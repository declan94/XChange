package org.knowm.xchange.okex.v3;

import java.io.IOException;
import org.knowm.xchange.BaseExchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.okex.v3.dto.marketdata.FuturesInstrument;
import org.knowm.xchange.okex.v3.service.OkexFuturesMarketDataService;
import org.knowm.xchange.okex.v3.service.OkexFuturesTradeService;
import si.mazi.rescu.SynchronizedValueFactory;

public class OkexExchange extends BaseExchange {

  private FuturesInstrument[] activeFuturesInstruments;

  @Override
  protected void initServices() {
    if (exchangeSpecification.getExchangeSpecificParameters() != null
        && exchangeSpecification.getExchangeSpecificParametersItem("Use_Futures").equals(true)) {
      this.marketDataService = new OkexFuturesMarketDataService(this);
      if (exchangeSpecification.getApiKey() != null) {
        this.tradeService =
            new OkexFuturesTradeService(this, futuresContractOfConfig(), futuresLeverageOfConfig());
      }
    } else {

    }
  }

  @Override
  public void remoteInit() throws IOException, ExchangeException {
    if (this.marketDataService instanceof OkexFuturesMarketDataService) {
      activeFuturesInstruments =
          ((OkexFuturesMarketDataService) marketDataService).getInstruments();
    }
  }

  @Override
  public SynchronizedValueFactory<Long> getNonceFactory() {
    return null;
  }

  @Override
  public ExchangeSpecification getDefaultExchangeSpecification() {

    ExchangeSpecification exchangeSpecification =
        new ExchangeSpecification(this.getClass().getCanonicalName());
    exchangeSpecification.setSslUri("https://www.okex.com");
    exchangeSpecification.setHost("www.okex.com");
    exchangeSpecification.setExchangeName("OKex");
    exchangeSpecification.setExchangeDescription(
        "OKex is a globally oriented crypto-currency trading platform.");

    exchangeSpecification.setExchangeSpecificParametersItem("Use_Futures", false);

    return exchangeSpecification;
  }

  /** Extract futures leverage used by spec */
  private int futuresLeverageOfConfig() {

    if (exchangeSpecification.getExchangeSpecificParameters().containsKey("Futures_Leverage")) {
      Object leverage =
          exchangeSpecification.getExchangeSpecificParameters().get("Futures_Leverage");
      if (leverage instanceof String) {
        return Integer.valueOf((String) leverage);
      }
      return (int) leverage;
    } else {
      // default choice of 10x leverage is "safe" choice and default by OkCoin.
      return 0;
    }
  }

  /** Extract contract used by spec */
  private OkexFuturesPrompt futuresContractOfConfig() {

    OkexFuturesPrompt contract;

    if (exchangeSpecification.getExchangeSpecificParameters().containsKey("Futures_Contract")) {
      contract =
          (OkexFuturesPrompt)
              exchangeSpecification.getExchangeSpecificParameters().get("Futures_Contract");
    } else if (exchangeSpecification
        .getExchangeSpecificParameters()
        .containsKey("Futures_Contract_String")) {
      contract =
          OkexFuturesPrompt.valueOfIgnoreCase(
              OkexFuturesPrompt.class,
              (String)
                  exchangeSpecification
                      .getExchangeSpecificParameters()
                      .get("Futures_Contract_String"));
    } else {
      throw new RuntimeException(
          "`Futures_Contract` or `Futures_Contract_String` not defined in exchange specific parameters.");
    }
    return contract;
  }

  public String determineFuturesInstrumentId(CurrencyPair currencyPair, OkexFuturesPrompt prompt) {
    if (activeFuturesInstruments == null) {
      throw new ExchangeException("Active instruments list not initialized");
    }
    for (FuturesInstrument instrument : activeFuturesInstruments) {
      if (instrument
              .getUnderlyingIndex()
              .toUpperCase()
              .equals(currencyPair.base.toString().toUpperCase())
          && instrument
              .getQuoteCurrency()
              .toUpperCase()
              .equals(currencyPair.counter.toString().toUpperCase())
          && instrument.getAlias().equals(prompt.getName())) {
        return instrument.getInstrumentId();
      }
    }
    throw new ExchangeException(
        "Instrument for " + currencyPair + " " + prompt + " is not active or does not exist");
  }
}
