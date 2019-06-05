package org.knowm.xchange.hbdm.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HbdmOrderResponse {

  private String orderId;

  private String clientOrderId;

  public HbdmOrderResponse(@JsonProperty("order_id") String orderId,
                           @JsonProperty("client_order_id") String clientOrderId) {
    this.orderId = orderId;
    this.clientOrderId = clientOrderId;
  }

  public String getOrderId() {
    return orderId;
  }

  public String getClientOrderId() {
    return clientOrderId;
  }

}
