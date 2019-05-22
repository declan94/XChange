package org.knowm.xchange.okex.v3;

import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.service.trade.TradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

public class OkexPlaceLimitOrderExample {

    private static final Logger logger = LoggerFactory.getLogger(OkexPlaceLimitOrderExample.class);

    public static void main(String[] args) throws IOException {
        OkexExchange exchange = ExchangeFactory.INSTANCE.createExchange(OkexExchange.class);

        ExchangeSpecification defaultExchangeSpecification = exchange.getDefaultExchangeSpecification();

        defaultExchangeSpecification.setExchangeSpecificParametersItem("Use_Futures", true);
        defaultExchangeSpecification.setExchangeSpecificParametersItem("Futures_Contract", OkexFuturesPrompt.Quarter);
        defaultExchangeSpecification.setExchangeSpecificParametersItem("Futures_Leverage", 20);

        defaultExchangeSpecification.setApiKey("xxxx");
        defaultExchangeSpecification.setSecretKey("xxxx");
        defaultExchangeSpecification.setExchangeSpecificParametersItem("Passphrase", "xxxx");

        defaultExchangeSpecification.setProxyHost("127.0.0.1");
        defaultExchangeSpecification.setProxyPort(1087);
        exchange.applySpecification(defaultExchangeSpecification);

        TradeService tradeService = exchange.getTradeService();

        String nosOrdId = System.currentTimeMillis() + "";
        BigDecimal originalOrderSize = new BigDecimal("30");
        //    BigDecimal price = new BigDecimal("10000");
        LimitOrder limitOrder =
                new LimitOrder(
                        Order.OrderType.ASK,
                        originalOrderSize,
                        CurrencyPair.BTC_USD,
                        nosOrdId,
                        new Date(),
                        new BigDecimal(8100));
        String orderId = tradeService.placeLimitOrder(limitOrder);
        System.out.println("orderid: " + orderId);
    }

}
