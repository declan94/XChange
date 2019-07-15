package org.knowm.xchange.okex.v3;

import com.fasterxml.jackson.annotation.JsonProperty;
import si.mazi.rescu.HttpStatusExceptionSupport;

@SuppressWarnings("serial")
public class OkexException extends HttpStatusExceptionSupport {

  // {"code":30015,"message":"Invalid OK_ACCESS_PASSPHRASE"}

  @JsonProperty("code")
  private String code;

  @JsonProperty("message")
  private String message;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String getMessage() {
    return String.format("[%s] %s", code, message);
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
