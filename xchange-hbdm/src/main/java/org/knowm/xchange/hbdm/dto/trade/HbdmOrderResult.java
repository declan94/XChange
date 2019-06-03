package org.knowm.xchange.hbdm.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.hbdm.dto.HbdmResult;

public class HbdmOrderResult extends HbdmResult<HbdmOrderResult.ResultData> {

  public HbdmOrderResult(@JsonProperty("status") String status,
                         @JsonProperty("err-code") String errCode,
                         @JsonProperty("err-msg") String errMsg,
                         @JsonProperty("data") ResultData result,
                         @JsonProperty("ts") Long ts) {
    super(status, errCode, errMsg, result, ts);
  }

  public static class ResultData {

    public ResultData(@JsonProperty("order_id") String orderId,
                      @JsonProperty("client_order_id") String clientOrderId) {
      this.orderId = orderId;
      this.clientOrderId = clientOrderId;
    }

    private String orderId;

    private String clientOrderId;

    public String getOrderId() {
      return orderId;
    }

    public String getClientOrderId() {
      return clientOrderId;
    }

  }

}
