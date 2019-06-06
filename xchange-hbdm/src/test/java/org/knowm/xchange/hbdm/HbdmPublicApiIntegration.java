package org.knowm.xchange.hbdm;

import org.junit.Before;
import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.hbdm.dto.market.ContractInfo;
import org.knowm.xchange.hbdm.service.HbdmMarketDataService;
import org.knowm.xchange.service.marketdata.MarketDataService;

import java.io.IOException;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class HbdmPublicApiIntegration {

  private Exchange exchange;

  @Before
  public void setup() {
    exchange = ExchangeFactory.INSTANCE.createExchange(HbdmExchange.class.getName());
    ExchangeSpecification specification = exchange.getDefaultExchangeSpecification();
    specification.setProxyHost("127.0.0.1");
    specification.setProxyPort(1087);
  }

  @Test
  public void testGetContractInfo() throws IOException {
    HbdmMarketDataService marketDataService = (HbdmMarketDataService) exchange.getMarketDataService();
    ContractInfo[] contracts = marketDataService.getContractInfo(null, null, null);
    assertThat(contracts).isNotNull();
    assertThat(contracts.length).isGreaterThan(0);

    contracts = marketDataService.getContractInfo("BTC", HbdmPrompt.THIS_WEEK, null);
    assertThat(contracts).isNotNull();
    assertThat(contracts.length).isGreaterThan(0);
    assertThat(contracts[0].getContractType()).isEqualTo("this_week");

  }

}
