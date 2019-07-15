package org.knowm.xchange.bitmex.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.knowm.xchange.bitmex.BitmexAuthenticated;
import org.knowm.xchange.bitmex.BitmexException;
import org.knowm.xchange.bitmex.BitmexExchange;
import org.knowm.xchange.bitmex.RateLimitUpdateListener;
import org.knowm.xchange.exceptions.*;
import org.knowm.xchange.service.BaseExchangeService;
import org.knowm.xchange.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.mazi.rescu.HttpResponseAware;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.RestProxyFactory;

@SuppressWarnings({"WeakerAccess", "unused"})
public class BitmexBaseService extends BaseExchangeService<BitmexExchange> implements BaseService {

  private static final Logger LOG = LoggerFactory.getLogger(BitmexBaseService.class);

  protected final BitmexAuthenticated bitmex;
  protected final ParamsDigest signatureCreator;

  /**
   * Constructor
   *
   * @param exchange
   */
  public BitmexBaseService(BitmexExchange exchange) {

    super(exchange);
    bitmex =
        RestProxyFactory.createProxy(
            BitmexAuthenticated.class,
            exchange.getExchangeSpecification().getSslUri(),
            getClientConfig());
    signatureCreator =
        BitmexDigest.createInstance(exchange.getExchangeSpecification().getSecretKey());
  }

  protected ExchangeException handleError(Exception exception) {
    if (exception != null && exception.getMessage() != null) {
      if (exception.getMessage().contains("Insufficient")) {
        return new FundsExceededException(exception);
      } else if (exception.getMessage().contains("Rate limit exceeded")) {
        return new RateLimitExceededException(exception);
      } else if (exception.getMessage().contains("Internal server error")) {
        return new InternalServerException(exception);
      } else if (exception.getMessage().contains("The system is currently overloaded")) {
        return new SystemOverloadException(exception);
      } else {
        return new ExchangeException(exception.getMessage(), exception);
      }
    }
    return new ExchangeException(exception);
  }

  /** see https://www.bitmex.com/app/restAPI#Request-Rate-Limits */
  protected <T extends HttpResponseAware> T updateRateLimit(Supplier<T> httpResponseAwareSupplier) {
    if (exchange.rateLimitReset != null) {
      long waitMillis = exchange.rateLimitReset * 1000 - System.currentTimeMillis();
      if (exchange.rateLimitRemaining <= 0 && waitMillis >= 0) {
        throw new ExchangeException(
            "The request is not executed due to rate limit, please wait for "
                + (waitMillis / 1000)
                + " seconds, limit:"
                + exchange.rateLimit
                + ", reset: "
                + new Date(exchange.rateLimitReset * 1000));
      } else {
        exchange.rateLimitRemaining--;
      }
    }
    HttpResponseAware responseAware = null;
    boolean rateLimitsUpdated = false;
    try {
      T result = httpResponseAwareSupplier.get();
      responseAware = result;
      return result;
    } catch (BitmexException e) {
      if (e.getHttpStatusCode() == 429) {
        // we are warned !
        try {
          Integer retryAfter = Integer.valueOf(e.getResponseHeaders().get("Retry-After").get(0));
          exchange.rateLimitRemaining = 0;
          exchange.rateLimitReset = System.currentTimeMillis() / 1000 + retryAfter;
          rateLimitsUpdated = true;
        } catch (Throwable ignored) {
        }
      } else if (e.getHttpStatusCode() == 403) {
        // we are banned now !
        exchange.rateLimitRemaining = 0;
        exchange.rateLimitReset = System.currentTimeMillis() / 1000 + 5; // lets be quiet for 5 sec
      }
      responseAware = e;
      throw handleError(e);
    } catch (Exception e) {
      throw handleError(e);
    } finally {
      if (responseAware != null && !rateLimitsUpdated) {
        try {
          Map<String, List<String>> responseHeaders = responseAware.getResponseHeaders();
          exchange.rateLimit = Integer.valueOf(responseHeaders.get("X-RateLimit-Limit").get(0));
          exchange.rateLimitRemaining =
              Integer.valueOf(responseHeaders.get("X-RateLimit-Remaining").get(0));
          exchange.rateLimitReset = Long.valueOf(responseHeaders.get("X-RateLimit-Reset").get(0));
          rateLimitsUpdated = true;
        } catch (Exception e) {
          LOG.error("Error get rate limit from headers: {}", responseAware.getResponseHeaders(), e);
        }
      }
      if (rateLimitsUpdated) {
        RateLimitUpdateListener rateLimitUpdateListener = exchange.getRateLimitUpdateListener();
        if (rateLimitUpdateListener != null) {
          rateLimitUpdateListener.rateLimitUpdate(
              exchange.rateLimit, exchange.rateLimitRemaining, exchange.rateLimitReset);
        }
      }
    }
  }

  public int getRateLimit() {
    return exchange.rateLimit;
  }

  public int getRateLimitRemaining() {
    return exchange.rateLimitRemaining;
  }

  public long getRateLimitReset() {
    return exchange.rateLimitReset;
  }
}
