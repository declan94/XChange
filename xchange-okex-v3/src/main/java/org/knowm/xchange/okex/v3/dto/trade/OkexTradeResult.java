package org.knowm.xchange.okex.v3.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OkexTradeResult {

    @JsonProperty("result")
    private boolean result;

    @JsonProperty("error_message")
    private String errorMessage;

    @JsonProperty("error_code")
    private String errorCode;

    @JsonProperty("result")
    public boolean isResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(boolean result) {
        this.result = result;
    }

    @JsonProperty("error_message")
    public String getErrorMessage() {
        return errorMessage;
    }

    @JsonProperty("error_message")
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @JsonProperty("error_code")
    public String getErrorCode() {
        return errorCode;
    }

    @JsonProperty("error_code")
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
