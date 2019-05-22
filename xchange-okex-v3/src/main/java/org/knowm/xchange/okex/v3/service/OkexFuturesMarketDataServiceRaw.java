package org.knowm.xchange.okex.v3.service;

import org.knowm.xchange.okex.v3.OkexExchange;
import org.knowm.xchange.okex.v3.OkexFutures;
import org.knowm.xchange.okex.v3.dto.marketdata.FuturesInstrument;
import si.mazi.rescu.RestProxyFactory;

public class OkexFuturesMarketDataServiceRaw extends OkexBaseService {

  private final OkexFutures okexFutures;

  public OkexFuturesMarketDataServiceRaw(OkexExchange exchange) {
    super(exchange);
    okexFutures =
        RestProxyFactory.createProxy(
            OkexFutures.class, exchange.getExchangeSpecification().getSslUri(), getClientConfig());
  }

  public FuturesInstrument[] getInstruments() {
    return okexFutures.getInstruments();
  }
}
