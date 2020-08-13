package org.knowm.xchange.okex.v3.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.okex.v3.OkexExchange;
import org.knowm.xchange.okex.v3.dto.marketdata.FuturesInstrument;
import org.knowm.xchange.service.marketdata.MarketDataService;

public class FuturesMarketDataIntegration {

  @Test
  public void testInstruments() throws IOException {
    ExchangeSpecification exSpec = new ExchangeSpecification(OkexExchange.class);
    exSpec.setExchangeSpecificParametersItem("Use_Futures", true);

    Exchange exchange = ExchangeFactory.INSTANCE.createExchange(exSpec);
    MarketDataService marketDataService = exchange.getMarketDataService();
    FuturesInstrument[] instruments =
        ((OkexFuturesMarketDataServiceRaw) marketDataService).getInstruments();
    assertThat(instruments).isNotNull();
    System.out.println(instruments[0].toString());
  }
}