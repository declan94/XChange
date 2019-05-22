package org.knowm.xchange.okex.v3.service;

import org.knowm.xchange.okex.v3.OkexExchange;
import org.knowm.xchange.service.marketdata.MarketDataService;

public class OkexFuturesMarketDataService extends OkexFuturesMarketDataServiceRaw
    implements MarketDataService {

  public OkexFuturesMarketDataService(OkexExchange exchange) {
    super(exchange);
  }
}
