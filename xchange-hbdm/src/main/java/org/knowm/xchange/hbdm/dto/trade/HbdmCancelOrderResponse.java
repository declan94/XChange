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

  @JsonProperty("success")
  private List<Long> success = null;

  public List<Error> getErrors() {
    return errors;
  }

  public List<Long> getSuccess() {
    return success;
  }
}
