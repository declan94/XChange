package org.knowm.xchange.bitmex.service;

import java.io.IOException;
import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.bitmex.BitmexExchange;
import org.knowm.xchange.bitmex.BitmexPrompt;
import org.knowm.xchange.currency.CurrencyPair;

public class BitmexTickerIntegration {

  @Test
  public void fetchTickerTest() throws IOException {
    Exchange exchange = ExchangeFactory.INSTANCE.createExchange(BitmexExchange.class.getName());
    ExchangeSpecification defaultExchangeSpecification = exchange.getDefaultExchangeSpecification();
    defaultExchangeSpecification.setProxyHost("127.0.0.1");
    defaultExchangeSpecification.setProxyPort(1087);
    exchange.applySpecification(defaultExchangeSpecification);

    CurrencyPair symbol =
        ((BitmexExchange) exchange).determineActiveContract("BTC", "USD", BitmexPrompt.QUARTERLY);
    System.out.println(symbol);
  }
}
