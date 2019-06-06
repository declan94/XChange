package org.knowm.xchange.hbdm.service;

import org.knowm.xchange.hbdm.HbdmExchange;
import org.knowm.xchange.hbdm.dto.HbdmResult;
import org.knowm.xchange.hbdm.dto.trade.HbdmCancelOrderResponse;
import org.knowm.xchange.hbdm.dto.trade.HbdmCreateOrderRequest;
import org.knowm.xchange.hbdm.dto.trade.HbdmOrderResponse;
import org.knowm.xchange.huobi.HuobiUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

  public HbdmCancelOrderResponse cancelHbdmOrder(String symbol, String orderId) throws IOException {
    Map<String, String> params = new HashMap<>();
    params.put("symbol", symbol);
    params.put("order_id", orderId);
    HbdmResult<HbdmCancelOrderResponse> result = hbdm.cancelOrder(params,
        exchange.getExchangeSpecification().getApiKey(),
        HbdmDigest.HMAC_SHA_256,
        2,
        HuobiUtils.createUTCDate(exchange.getNonceFactory()),
        signatureCreator);
    return checkResult(result);
  }

}
