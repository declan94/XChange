package org.knowm.xchange.hbdm;

import org.knowm.xchange.BaseExchange;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.hbdm.service.HbdmAccountService;
import org.knowm.xchange.hbdm.service.HbdmMarketDataService;
import org.knowm.xchange.hbdm.service.HbdmTradeService;
import org.knowm.xchange.utils.nonce.CurrentTimeNonceFactory;
import si.mazi.rescu.SynchronizedValueFactory;

import java.io.IOException;

public class HbdmExchange extends BaseExchange implements Exchange {

  private final SynchronizedValueFactory<Long> nonceFactory = new CurrentTimeNonceFactory();

  @Override
  protected void initServices() {
    this.marketDataService = new HbdmMarketDataService(this);
    this.tradeService = new HbdmTradeService(this, getContractType(), getLeverRate());
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
    exchangeSpecification.setExchangeSpecificParametersItem("contract_type", HbdmPrompt.THIS_WEEK);
    exchangeSpecification.setExchangeSpecificParametersItem("lever_rate", 20);
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

  private HbdmPrompt getContractType() {
    Object contractType = exchangeSpecification.getExchangeSpecificParametersItem("contract_type");
    if (contractType == null) {
      throw new ExchangeException("contract_type not specified!");
    }
    if (contractType instanceof String) {
      return HbdmPrompt.valueOf(((String) contractType).toUpperCase());
    } else {
      return (HbdmPrompt) contractType;
    }
  }

  private int getLeverRate() {
    Object leverRate = exchangeSpecification.getExchangeSpecificParametersItem("lever_rate");
    if (leverRate == null) {
      throw new ExchangeException("lever_rate not specified!");
    }
    if (leverRate instanceof String) {
      return Integer.parseInt((String) leverRate);
    } else {
      return (int) leverRate;
    }
  }



}
