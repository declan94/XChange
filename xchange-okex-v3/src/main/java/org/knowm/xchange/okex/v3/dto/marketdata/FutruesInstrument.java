package org.knowm.xchange.okex.v3.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "instrument_id",
        "underlying_index",
        "quote_currency",
        "tick_size",
        "contract_val",
        "listing",
        "delivery",
        "trade_increment",
        "alias"
})
public class FutruesInstrument {

    @JsonProperty("instrument_id")
    private String instrumentId;
    @JsonProperty("underlying_index")
    private String underlyingIndex;
    @JsonProperty("quote_currency")
    private String quoteCurrency;
    @JsonProperty("tick_size")
    private String tickSize;
    @JsonProperty("contract_val")
    private String contractVal;
    @JsonProperty("listing")
    private String listing;
    @JsonProperty("delivery")
    private String delivery;
    @JsonProperty("trade_increment")
    private String tradeIncrement;
    @JsonProperty("alias")
    private String alias;

    @JsonProperty("instrument_id")
    public String getInstrumentId() {
        return instrumentId;
    }

    @JsonProperty("instrument_id")
    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    @JsonProperty("underlying_index")
    public String getUnderlyingIndex() {
        return underlyingIndex;
    }

    @JsonProperty("underlying_index")
    public void setUnderlyingIndex(String underlyingIndex) {
        this.underlyingIndex = underlyingIndex;
    }

    @JsonProperty("quote_currency")
    public String getQuoteCurrency() {
        return quoteCurrency;
    }

    @JsonProperty("quote_currency")
    public void setQuoteCurrency(String quoteCurrency) {
        this.quoteCurrency = quoteCurrency;
    }

    @JsonProperty("tick_size")
    public String getTickSize() {
        return tickSize;
    }

    @JsonProperty("tick_size")
    public void setTickSize(String tickSize) {
        this.tickSize = tickSize;
    }

    @JsonProperty("contract_val")
    public String getContractVal() {
        return contractVal;
    }

    @JsonProperty("contract_val")
    public void setContractVal(String contractVal) {
        this.contractVal = contractVal;
    }

    @JsonProperty("listing")
    public String getListing() {
        return listing;
    }

    @JsonProperty("listing")
    public void setListing(String listing) {
        this.listing = listing;
    }

    @JsonProperty("delivery")
    public String getDelivery() {
        return delivery;
    }

    @JsonProperty("delivery")
    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    @JsonProperty("trade_increment")
    public String getTradeIncrement() {
        return tradeIncrement;
    }

    @JsonProperty("trade_increment")
    public void setTradeIncrement(String tradeIncrement) {
        this.tradeIncrement = tradeIncrement;
    }

    @JsonProperty("alias")
    public String getAlias() {
        return alias;
    }

    @JsonProperty("alias")
    public void setAlias(String alias) {
        this.alias = alias;
    }

}