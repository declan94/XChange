package org.knowm.xchange.okex.v3;

import org.knowm.xchange.BaseExchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.okex.v3.service.OkexFuturesMarketDataService;
import si.mazi.rescu.SynchronizedValueFactory;

public class OkexExchange extends BaseExchange {

    @Override
    protected void initServices() {
        if (exchangeSpecification.getExchangeSpecificParameters() != null
                && exchangeSpecification.getExchangeSpecificParametersItem("Use_Futures").equals(true)) {
            this.marketDataService = new OkexFuturesMarketDataService(this);
        } else {

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

}
