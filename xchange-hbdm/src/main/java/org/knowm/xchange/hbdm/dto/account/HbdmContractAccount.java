package org.knowm.xchange.hbdm.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HbdmContractAccount {

  @JsonProperty("symbol")
  private String symbol;

  @JsonProperty("margin_balance")
  private double marginBalance;

  @JsonProperty("margin_position")
  private double marginPosition;

  @JsonProperty("margin_frozen")
  private double marginFrozen;

  @JsonProperty("margin_available")
  private double marginAvailable;

  @JsonProperty("profit_real")
  private double profitReal;

  @JsonProperty("profit_unreal")
  private double profitUnreal;

  @JsonProperty("withdraw_available")
  private double withdrawAvailable;

  @JsonProperty("risk_rate")
  private int riskRate;

  @JsonProperty("liquidation_price")
  private double liquidationPrice;

  public String getSymbol() {
    return symbol;
  }

  public double getMarginBalance() {
    return marginBalance;
  }

  public double getMarginPosition() {
    return marginPosition;
  }

  public double getMarginFrozen() {
    return marginFrozen;
  }

  public double getMarginAvailable() {
    return marginAvailable;
  }

  public double getProfitReal() {
    return profitReal;
  }

  public double getProfitUnreal() {
    return profitUnreal;
  }

  public double getWithdrawAvailable() {
    return withdrawAvailable;
  }

  public int getRiskRate() {
    return riskRate;
  }

  public double getLiquidationPrice() {
    return liquidationPrice;
  }
}
