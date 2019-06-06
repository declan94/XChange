package org.knowm.xchange.hbdm.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HbdmResult<V> {

  private final String status;
  private final String errCode;
  private final String errMsg;
  private final V result;
  private final Long timestamp;

  @JsonCreator
  public HbdmResult(
      @JsonProperty("status") String status,
      @JsonProperty("err-code") String errCode,
      @JsonProperty("err-msg") String errMsg,
      @JsonProperty("data") V result,
      @JsonProperty("ts") Long ts) {
    this.status = status;
    this.errCode = errCode;
    this.errMsg = errMsg;
    this.result = result;
    this.timestamp = ts;
  }

  public boolean isSuccess() {
    return getStatus().equals("ok");
  }

  public String getStatus() {
    return status;
  }

  public String getError() {
    return (errMsg.length() == 0) ? errCode : errMsg;
  }

  public V getResult() {
    return result;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {
    return String.format("HbdmResult [%s, %s]", status, isSuccess() ? getResult().toString() : getError());
  }

}
