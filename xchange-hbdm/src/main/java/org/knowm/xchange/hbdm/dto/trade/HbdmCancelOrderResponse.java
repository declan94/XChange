package org.knowm.xchange.hbdm.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class HbdmCancelOrderResponse {

  public static class Error {

    @JsonProperty("order_id")
    private long orderId;

    @JsonProperty("err_code")
    private int errCode;

    @JsonProperty("err_msg")
    private String errMsg;

    public long getOrderId() {
      return orderId;
    }

    public int getErrCode() {
      return errCode;
    }

    public String getErrMsg() {
      return errMsg;
    }

    @Override
    public String toString() {
      return "Error{"
          + "orderId="
          + orderId
          + ", errCode="
          + errCode
          + ", errMsg='"
          + errMsg
          + '\''
          + '}';
    }
  }

  @JsonProperty("errors")
  private List<Error> errors = null;

  @JsonProperty("successes")
  private String successes = null;

  public List<Error> getErrors() {
    return errors;
  }

  public String getSuccesses() {
    return successes;
  }

  @Override
  public String toString() {
    return "HbdmCancelOrderResponse{" +
            "errors=" + errors +
            ", successes='" + successes + '\'' +
            '}';
  }
}
