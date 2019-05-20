package org.knowm.xchange.okex.v3.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.okex.v3.OkexFutures;
import org.knowm.xchange.okex.v3.dto.marketdata.FuturesInstrument;
import org.knowm.xchange.service.BaseExchangeService;
import si.mazi.rescu.RestProxyFactory;

public class OkexFuturesMarketDataServiceRaw extends BaseExchangeService {

    private OkexFutures okexFutures;

    public OkexFuturesMarketDataServiceRaw(Exchange exchange) {
        super(exchange);
        okexFutures = RestProxyFactory.createProxy(OkexFutures.class, exchange.getExchangeSpecification().getSslUri(), getClientConfig());
    }

    public FuturesInstrument[] getInstruments() {
        return okexFutures.getInstruments();
    }

}
