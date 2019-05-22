package org.knowm.xchange.okex.v3;

import org.knowm.xchange.dto.Order;

public class OkexAdapters {

  public static String adaptFuturesOrderType(Order.OrderType type) {
    switch (type) {
      case BID:
        return "1";
      case ASK:
        return "2";
      case EXIT_BID:
        return "3";
      case EXIT_ASK:
        return "4";
    }
    return null;
  }
}
