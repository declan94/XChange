package org.knowm.xchange.hbdm;

import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.hbdm.dto.market.HbdmDepth;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Stream;

public class HbdmAdapters {

  public static OrderBook adaptOrderBook(HbdmDepth depth, CurrencyPair currencyPair) {
    Stream<LimitOrder> asks =
        adaptLimitOrders(Order.OrderType.ASK, depth.getAsks(), depth.getTimestamp(), currencyPair)
            .sorted();
    Stream<LimitOrder> bids =
        adaptLimitOrders(Order.OrderType.BID, depth.getBids(), depth.getTimestamp(), currencyPair)
            .sorted();
    return new OrderBook(depth.getTimestamp(), asks, bids);
  }

  private static Stream<LimitOrder> adaptLimitOrders(
      Order.OrderType type, BigDecimal[][] list, Date timestamp, CurrencyPair currencyPair) {
    return Arrays.stream(list)
        .map(data -> adaptLimitOrder(type, data, currencyPair, null, timestamp));
  }

  private static LimitOrder adaptLimitOrder(
      Order.OrderType type, BigDecimal[] data, CurrencyPair currencyPair, String id, Date timestamp) {
    return new LimitOrder(type, data[1], currencyPair, id, timestamp, data[0]);
  }

}
