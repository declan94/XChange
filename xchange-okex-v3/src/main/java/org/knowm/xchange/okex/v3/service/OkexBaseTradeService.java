package org.knowm.xchange.okex.v3.service;

import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.okex.v3.OkexExchange;
import org.knowm.xchange.okex.v3.OkexFutures;
import org.knowm.xchange.okex.v3.dto.trade.OkexTradeResult;
import si.mazi.rescu.RestProxyFactory;

public class OkexBaseTradeService extends OkexBaseAuthenticatedService {

    protected final OkexFutures okexFutures;

    /**
     * Constructor
     *
     * @param exchange
     */
    protected OkexBaseTradeService(OkexExchange exchange) {
        super(exchange);
        ExchangeSpecification specification = exchange.getExchangeSpecification();
        okexFutures =
                RestProxyFactory.createProxy(
                        OkexFutures.class, specification.getSslUri(), getClientConfig());
    }

    protected static <T extends OkexTradeResult> T returnOrThrow(T t) {
        if (t.isResult()) {
            return t;
        } else {
            throw new ExchangeException(t.getErrorCode() + " " + t.getErrorMessage());
        }
    }

}
