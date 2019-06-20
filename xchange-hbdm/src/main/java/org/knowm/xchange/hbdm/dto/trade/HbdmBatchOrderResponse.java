package org.knowm.xchange.hbdm.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class HbdmBatchOrderResponse {

  public static class Error {

    @JsonProperty("index")
    private int index;

    @JsonProperty("err_code")
    private int errCode;

    @JsonProperty("err_msg")
    private String errMsg;

    public int getIndex() {
      return index;
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
          + "index="
          + index
          + ", errCode="
          + errCode
          + ", errMsg='"
          + errMsg
          + '\''
          + '}';
    }
  }

  public static class Success {

    @JsonProperty("index")
    private int index;

    @JsonProperty("order_id")
    private long orderId;

    @JsonProperty("client_order_id")
    private int clientOrderId;

    public int getIndex() {
      return index;
    }

    public long getOrderId() {
      return orderId;
    }

    public int getClientOrderId() {
      return clientOrderId;
    }

    @Override
    public String toString() {
      return "Success{"
          + "index="
          + index
          + ", orderId="
          + orderId
          + ", clientOrderId="
          + clientOrderId
          + '}';
    }
  }

  @JsonProperty("errors")
  private List<Error> errors = null;

  @JsonProperty("success")
  private List<Success> success = null;

  @JsonProperty("errors")
  public List<Error> getErrors() {
    return errors;
  }

  @JsonProperty("errors")
  public void setErrors(List<Error> errors) {
    this.errors = errors;
  }

  @JsonProperty("success")
  public List<Success> getSuccess() {
    return success;
  }

  @JsonProperty("success")
  public void setSuccess(List<Success> success) {
    this.success = success;
  }

  @Override
  public String toString() {
    return "HbdmBatchOrderResponse{" + "errors=" + errors + ", success=" + success + '}';
  }
}
