package org.knowm.xchange.okex.v3.service;

import org.knowm.xchange.okex.v3.OkexExchange;
import org.knowm.xchange.okex.v3.dto.trade.OkexFuturesOrder;
import org.knowm.xchange.okex.v3.dto.trade.OkexFuturesOrderResult;

public class OkexFuturesTradeServiceRaw extends OkexBaseTradeService {

  /**
   * Constructor
   *
   * @param exchange
   */
  protected OkexFuturesTradeServiceRaw(OkexExchange exchange) {
    super(exchange);
  }

  public OkexFuturesOrderResult placeFuturesOrder(OkexFuturesOrder order) {
    OkexFuturesOrderResult result =
        okexFutures.placeFuturesOrder(
            order, apiKey, apiPassphrase, timestampNonceFactory, okexDigest);
    return returnOrThrow(result);
  }
}
