package org.knowm.xchange.okcoin.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class OkCoinFutureIndex {

    private final BigDecimal future_index;

    public OkCoinFutureIndex(@JsonProperty("future_index") final BigDecimal future_index) {
        this.future_index = future_index;
    }

}
