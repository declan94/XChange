package org.knowm.xchange.hbdm.service;

import org.knowm.xchange.hbdm.HbdmExchange;
import org.knowm.xchange.hbdm.dto.HbdmResult;
import org.knowm.xchange.hbdm.dto.trade.HbdmCreateOrderRequest;
import org.knowm.xchange.hbdm.dto.trade.HbdmOrderResponse;
import org.knowm.xchange.huobi.HuobiUtils;

import java.io.IOException;

public class HbdmTradeServiceRaw extends HbdmBaseService {

  public HbdmTradeServiceRaw(HbdmExchange exchange) {
    super(exchange);
  }

  public HbdmOrderResponse placeHbdmOrder(HbdmCreateOrderRequest orderRequest) throws IOException {
    HbdmResult<HbdmOrderResponse> result = hbdm.placeOrder(orderRequest,
        exchange.getExchangeSpecification().getApiKey(),
        HbdmDigest.HMAC_SHA_256,
        2,
        HuobiUtils.createUTCDate(exchange.getNonceFactory()),
        signatureCreator);
    return checkResult(result);
  }

}
