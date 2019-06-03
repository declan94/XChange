package org.knowm.xchange.hbdm;

import org.knowm.xchange.BaseExchange;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.hbdm.dto.service.HbdmAccountService;
import org.knowm.xchange.hbdm.dto.service.HbdmMarketDataService;
import org.knowm.xchange.hbdm.dto.service.HbdmTradeService;
import org.knowm.xchange.utils.nonce.CurrentTimeNonceFactory;
import si.mazi.rescu.SynchronizedValueFactory;

import java.io.IOException;

public class HbdmExchange extends BaseExchange implements Exchange {

  private final SynchronizedValueFactory<Long> nonceFactory = new CurrentTimeNonceFactory();

  @Override
  protected void initServices() {
    this.marketDataService = new HbdmMarketDataService(this);
    this.tradeService = new HbdmTradeService(this);
    this.accountService = new HbdmAccountService(this);
  }

  @Override
  public ExchangeSpecification getDefaultExchangeSpecification() {
    ExchangeSpecification exchangeSpecification =
        new ExchangeSpecification(this.getClass().getCanonicalName());
    exchangeSpecification.setSslUri("https://api.hbdm.com");
    exchangeSpecification.setHost("api.hbdm.com");
    exchangeSpecification.setPort(80);
    exchangeSpecification.setExchangeName("HBDM");
    exchangeSpecification.setExchangeDescription(
        "Huobi DM, the digital asset derivative trading platform of Huobi.");
    return exchangeSpecification;
  }

  @Override
  public SynchronizedValueFactory<Long> getNonceFactory() {
    return nonceFactory;
  }

  @Override
  public void remoteInit() throws IOException, ExchangeException {

  }

}
