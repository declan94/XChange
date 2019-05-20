package org.knowm.xchange.okex.v3.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.service.marketdata.MarketDataService;

public class OkexFuturesMarketDataService extends OkexFuturesMarketDataServiceRaw implements MarketDataService {

    public OkexFuturesMarketDataService(Exchange exchange) {
        super(exchange);
    }

}
