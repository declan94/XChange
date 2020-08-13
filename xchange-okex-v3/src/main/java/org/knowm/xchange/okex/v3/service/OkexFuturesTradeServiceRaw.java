package org.knowm.xchange.okex.v3.service;

import java.io.IOException;
import org.knowm.xchange.okex.v3.OkexExchange;
import org.knowm.xchange.okex.v3.dto.trade.OkexFuturesOrder;
import org.knowm.xchange.okex.v3.dto.trade.OkexFuturesOrderResult;

public class OkexFuturesTradeServiceRaw extends OkexBaseTradeService {

  /**
   * Constructor
   *
   * @param exchange
   */
  protected OkexFuturesTradeServiceRaw(OkexExchange exchange) {
    super(exchange);
  }

  public OkexFuturesOrderResult placeFuturesOrder(OkexFuturesOrder order) throws IOException {
    OkexFuturesOrderResult result =
        okexFutures.placeFuturesOrder(
            order, apiKey, apiPassphrase, timestampNonceFactory, okexDigest);
    return returnOrThrow(result);
  }

  public OkexFuturesOrderResult cancelFuturesOrder(String instrumentId, String orderId)
      throws IOException {
    OkexFuturesOrderResult result =
        okexFutures.cancelFuturesOrder(
            instrumentId, orderId, apiKey, apiPassphrase, timestampNonceFactory, okexDigest);
    return returnOrThrow(result);
  }
}
