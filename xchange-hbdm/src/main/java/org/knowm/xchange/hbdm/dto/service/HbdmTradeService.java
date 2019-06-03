package org.knowm.xchange.hbdm.dto.service;

import org.knowm.xchange.hbdm.HbdmExchange;
import org.knowm.xchange.service.trade.TradeService;

public class HbdmTradeService extends HbdmTradeServiceRaw implements TradeService {

  public HbdmTradeService(HbdmExchange exchange) {
    super(exchange);
  }

}
