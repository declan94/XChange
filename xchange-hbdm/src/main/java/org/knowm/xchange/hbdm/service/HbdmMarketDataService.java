package org.knowm.xchange.hbdm.service;

import org.knowm.xchange.hbdm.HbdmExchange;
import org.knowm.xchange.service.marketdata.MarketDataService;

public class HbdmMarketDataService extends HbdmMarketDataServiceRaw implements MarketDataService {

  public HbdmMarketDataService(HbdmExchange exchange) {
    super(exchange);
  }
}
