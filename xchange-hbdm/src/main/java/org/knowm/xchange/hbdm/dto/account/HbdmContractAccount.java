package org.knowm.xchange.hbdm.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HbdmContractAccount {

  @JsonProperty("symbol")
  private String symbol;

  @JsonProperty("margin_balance")
  private int marginBalance;

  @JsonProperty("margin_position")
  private int marginPosition;

  @JsonProperty("margin_frozen")
  private float marginFrozen;

  @JsonProperty("margin_available")
  private float marginAvailable;

  @JsonProperty("profit_real")
  private float profitReal;

  @JsonProperty("profit_unreal")
  private float profitUnreal;

  @JsonProperty("withdraw_available")
  private float withdrawAvailable;

  @JsonProperty("risk_rate")
  private int riskRate;

  @JsonProperty("liquidation_price")
  private int liquidationPrice;

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
