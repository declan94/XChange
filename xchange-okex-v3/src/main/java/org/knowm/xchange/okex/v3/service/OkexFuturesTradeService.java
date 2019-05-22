package org.knowm.xchange.okex.v3.service;

import java.io.IOException;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.exceptions.NotAvailableFromExchangeException;
import org.knowm.xchange.exceptions.NotYetImplementedForExchangeException;
import org.knowm.xchange.okex.v3.OkexAdapters;
import org.knowm.xchange.okex.v3.OkexExchange;
import org.knowm.xchange.okex.v3.OkexFuturesPrompt;
import org.knowm.xchange.okex.v3.dto.trade.OkexFuturesOrder;
import org.knowm.xchange.okex.v3.dto.trade.OkexFuturesOrderResult;
import org.knowm.xchange.service.trade.TradeService;

public class OkexFuturesTradeService extends OkexFuturesTradeServiceRaw implements TradeService {

  private final OkexFuturesPrompt futuresPrompt;

  private final int futuresLeverage;

  private String instrumentId;

  /**
   * Constructor
   *
   * @param exchange
   * @param futuresPrompt
   * @param futuresLeverage
   */
  public OkexFuturesTradeService(
      OkexExchange exchange, OkexFuturesPrompt futuresPrompt, int futuresLeverage) {
    super(exchange);
    this.futuresPrompt = futuresPrompt;
    this.futuresLeverage = futuresLeverage;
  }

  /**
   * Place a limit order
   *
   * @param limitOrder
   * @return the order ID
   * @throws ExchangeException - Indication that the exchange reported some kind of error with the
   *     request or response
   * @throws NotAvailableFromExchangeException - Indication that the exchange does not support the
   *     requested function or data
   * @throws NotYetImplementedForExchangeException - Indication that the exchange supports the
   *     requested function or data, but it has not yet been implemented
   * @throws IOException - Indication that a networking error occurred while fetching JSON data
   */
  public String placeLimitOrder(LimitOrder limitOrder) throws IOException {
    if (instrumentId == null) {
      instrumentId =
          exchange.determineFuturesInstrumentId(limitOrder.getCurrencyPair(), futuresPrompt);
    }
    OkexFuturesOrder futuresOrder = new OkexFuturesOrder();
    futuresOrder.setInstrumentId(instrumentId);
    futuresOrder.setLeverage(String.valueOf(futuresLeverage));
    futuresOrder.setPrice(limitOrder.getLimitPrice().toPlainString());
    futuresOrder.setSize(limitOrder.getOriginalAmount().toPlainString());
    futuresOrder.setType(OkexAdapters.adaptFuturesOrderType(limitOrder.getType()));
    OkexFuturesOrderResult result = placeFuturesOrder(futuresOrder);
    return result.getOrderId();
  }
}
