package org.knowm.xchange.hbdm;

import org.junit.Before;
import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.hbdm.dto.market.ContractInfo;
import org.knowm.xchange.hbdm.service.HbdmMarketDataService;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class HbdmPublicApiIntegration {

  private Exchange exchange;

  @Before
  public void setup() {
    exchange = ExchangeFactory.INSTANCE.createExchange(HbdmExchange.class.getName());
    HbdmTestProperties testProps = new HbdmTestProperties();
    ExchangeSpecification specification = exchange.getDefaultExchangeSpecification();
    specification.setProxyHost(testProps.getProxyHost());
    specification.setProxyPort(testProps.getProxyPort());
    exchange.applySpecification(specification);
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
