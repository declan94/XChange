package org.knowm.xchange.okex.v3.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OkexFuturesOrderResult extends OkexTradeResult {

    @JsonProperty("client_oid")
    private String clientOid;

    @JsonProperty("order_id")
    private String orderId;

    @JsonProperty("client_oid")
    public String getClientOid() {
        return clientOid;
    }

    @JsonProperty("client_oid")
    public void setClientOid(String clientOid) {
        this.clientOid = clientOid;
    }

    @JsonProperty("order_id")
    public String getOrderId() {
        return orderId;
    }

    @JsonProperty("order_id")
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

}