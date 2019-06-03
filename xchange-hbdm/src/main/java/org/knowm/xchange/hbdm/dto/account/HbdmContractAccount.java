package org.knowm.xchange.hbdm.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HbdmContractAccount {

  @JsonProperty("symbol")
  public String symbol;

  @JsonProperty("margin_balance")
  public int marginBalance;

  @JsonProperty("margin_position")
  public int marginPosition;

  @JsonProperty("margin_frozen")
  public float marginFrozen;

  @JsonProperty("margin_available")
  public float marginAvailable;

  @JsonProperty("profit_real")
  public float profitReal;

  @JsonProperty("profit_unreal")
  public float profitUnreal;

  @JsonProperty("withdraw_available")
  public float withdrawAvailable;

  @JsonProperty("risk_rate")
  public int riskRate;

  @JsonProperty("liquidation_price")
  public int liquidationPrice;


  public String getSymbol() {
    return symbol;
  }

  public int getMarginBalance() {
    return marginBalance;
  }

  public int getMarginPosition() {
    return marginPosition;
  }

  public float getMarginFrozen() {
    return marginFrozen;
  }

  public float getMarginAvailable() {
    return marginAvailable;
  }

  public float getProfitReal() {
    return profitReal;
  }

  public float getProfitUnreal() {
    return profitUnreal;
  }

  public float getWithdrawAvailable() {
    return withdrawAvailable;
  }

  public int getRiskRate() {
    return riskRate;
  }

  public int getLiquidationPrice() {
    return liquidationPrice;
  }

}