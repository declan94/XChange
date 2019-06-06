package org.knowm.xchange.hbdm.service;

import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.hbdm.HbdmExchange;
import org.knowm.xchange.hbdm.HbdmPrompt;
import org.knowm.xchange.hbdm.dto.trade.HbdmCreateOrderRequest;
import org.knowm.xchange.hbdm.dto.trade.HbdmOrderResponse;
import org.knowm.xchange.service.trade.TradeService;

import java.io.IOException;


public class HbdmTradeService extends HbdmTradeServiceRaw implements TradeService {

  private final HbdmPrompt contractType;

  private final int leverRate;

  public HbdmTradeService(HbdmExchange exchange, HbdmPrompt contractType, int leverRate) {
    super(exchange);
    this.contractType = contractType;
    this.leverRate = leverRate;
  }

  @Override
  public String placeLimitOrder(LimitOrder limitOrder) throws IOException {
    String symbol = limitOrder.getCurrencyPair().base.toString();
    String direction, offset;
    switch (limitOrder.getType()) {
      case BID:
        direction = HbdmCreateOrderRequest.DIRECTION_BUY;
        offset = HbdmCreateOrderRequest.OFFSET_OPEN;
        break;
      case ASK:
        direction = HbdmCreateOrderRequest.DIRECTION_SELL;
        offset = HbdmCreateOrderRequest.OFFSET_OPEN;
        break;
      case EXIT_BID:
        direction = HbdmCreateOrderRequest.DIRECTION_SELL;
        offset = HbdmCreateOrderRequest.OFFSET_CLOSE;
        break;
      case EXIT_ASK:
      default:
        direction = HbdmCreateOrderRequest.DIRECTION_BUY;
        offset = HbdmCreateOrderRequest.OFFSET_CLOSE;
        break;
    }
    HbdmCreateOrderRequest createOrderRequest = new HbdmCreateOrderRequest(
        symbol,
        contractType,
        limitOrder.getLimitPrice(),
        limitOrder.getOriginalAmount().longValue(),
        direction,
        offset,
        leverRate,
        HbdmCreateOrderRequest.ORDER_PRICE_TYPE_LIMIT);
    HbdmOrderResponse response = placeHbdmOrder(createOrderRequest);
    return response.getOrderId();
  }

}
