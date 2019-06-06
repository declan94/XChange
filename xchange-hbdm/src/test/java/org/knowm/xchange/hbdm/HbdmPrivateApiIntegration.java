package org.knowm.xchange.hbdm;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.Order.OrderType;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.OpenOrders;
import org.knowm.xchange.hbdm.dto.account.HbdmContractAccount;
import org.knowm.xchange.hbdm.dto.account.HbdmContractPosition;
import org.knowm.xchange.hbdm.dto.trade.HbdmCancelOrderResponse;
import org.knowm.xchange.hbdm.service.HbdmAccountService;
import org.knowm.xchange.hbdm.service.HbdmTradeServiceRaw;
import org.knowm.xchange.service.trade.TradeService;

public class HbdmPrivateApiIntegration {

  private HbdmTestProperties properties;
  private Exchange exchange;

  @Before
  public void setup() throws IOException {
    properties = new HbdmTestProperties();
    Assume.assumeTrue("Ignore tests because credentials are missing", properties.isValid());

    exchange = ExchangeFactory.INSTANCE.createExchange(HbdmExchange.class.getName());
    ExchangeSpecification specification = exchange.getDefaultExchangeSpecification();
    specification.setApiKey(properties.getApiKey());
    specification.setSecretKey(properties.getSecretKey());
    specification.setProxyHost(properties.getProxyHost());
    specification.setProxyPort(properties.getProxyPort());
    exchange.applySpecification(specification);
  }

  @Test
  @Ignore("Use it for manual")
  public void getAccountTest() throws IOException {
    HbdmAccountService accountService = (HbdmAccountService) exchange.getAccountService();
    HbdmContractAccount[] accounts = accountService.getContractAccounts(null);
    System.out.println(Arrays.toString(accounts));
  }

  @Test
  @Ignore("Use it for manual")
  public void getPositionsTest() throws IOException {
    HbdmAccountService accountService = (HbdmAccountService) exchange.getAccountService();
    HbdmContractPosition[] positions = accountService.getContractPositions(null);
    System.out.println(Arrays.toString(positions));
  }

  @Test
  @Ignore("Use it for manual")
  public void getOpenOrdersTest() throws IOException {
    TradeService tradeService = exchange.getTradeService();
    OpenOrders openOrders = tradeService.getOpenOrders();
    System.out.println(openOrders.toString());
    assertThat(openOrders).isNotNull();
  }

  @Test
  @Ignore("Use it for manual")
  public void getOrderTest() throws IOException {
    TradeService tradeService = exchange.getTradeService();
    Collection<Order> orders = tradeService.getOrder("2132866355");
    System.out.println(orders.toString());
    assertThat(orders).isNotNull();
  }

  @Test
  @Ignore("Use it for manual")
  public void placeLimitOrderTest() throws IOException {
    TradeService tradeService = exchange.getTradeService();
    LimitOrder limitOrder =
        new LimitOrder(
            OrderType.ASK,
            new BigDecimal("1"),
            new CurrencyPair("BTC", "USD"),
            null,
            null,
            new BigDecimal("8000"));
    String orderId = tradeService.placeLimitOrder(limitOrder);
    System.out.println(orderId);
  }

  @Test
  @Ignore("Use it for manual")
  public void cancelOrderTest() throws IOException {
    HbdmTradeServiceRaw tradeService = (HbdmTradeServiceRaw) exchange.getTradeService();
    HbdmCancelOrderResponse response = tradeService.cancelHbdmOrder("BTC", "2715696526");
    System.out.println(response.getSuccess());
    System.out.println(response.getErrors());
  }
}
