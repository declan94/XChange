package org.knowm.xchange.hbdm.dto.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HbdmContractPosition {

  @JsonProperty("symbol")
  private String symbol;

  @JsonProperty("contract_code")
  private String contractCode;

  @JsonProperty("contract_type")
  private String contractType;

  @JsonProperty("volume")
  private int volume;

  @JsonProperty("available")
  private int available;

  @JsonProperty("frozen")
  private float frozen;

  @JsonProperty("cost_open")
  private float costOpen;

  @JsonProperty("cost_hold")
  private float costHold;

  @JsonProperty("profit_unreal")
  private float profitUnreal;

  @JsonProperty("profit_rate")
  private float profitRate;

  @JsonProperty("profit")
  private float profit;

  @JsonProperty("position_margin")
  private float positionMargin;

  @JsonProperty("lever_rate")
  private int leverRate;

  @JsonProperty("direction")
  private String direction;

  @JsonProperty("last_price")
  private float lastPrice;

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public String getContractCode() {
    return contractCode;
  }

  public void setContractCode(String contractCode) {
    this.contractCode = contractCode;
  }

  public String getContractType() {
    return contractType;
  }

  public void setContractType(String contractType) {
    this.contractType = contractType;
  }

  public int getVolume() {
    return volume;
  }

  public void setVolume(int volume) {
    this.volume = volume;
  }

  public int getAvailable() {
    return available;
  }

  public void setAvailable(int available) {
    this.available = available;
  }

  public float getFrozen() {
    return frozen;
  }

  public void setFrozen(float frozen) {
    this.frozen = frozen;
  }

  public float getCostOpen() {
    return costOpen;
  }

  public void setCostOpen(float costOpen) {
    this.costOpen = costOpen;
  }

  public float getCostHold() {
    return costHold;
  }

  public void setCostHold(float costHold) {
    this.costHold = costHold;
  }

  public float getProfitUnreal() {
    return profitUnreal;
  }

  public void setProfitUnreal(float profitUnreal) {
    this.profitUnreal = profitUnreal;
  }

  public float getProfitRate() {
    return profitRate;
  }

  public void setProfitRate(float profitRate) {
    this.profitRate = profitRate;
  }

  public float getProfit() {
    return profit;
  }

  public void setProfit(float profit) {
    this.profit = profit;
  }

  public float getPositionMargin() {
    return positionMargin;
  }

  public void setPositionMargin(float positionMargin) {
    this.positionMargin = positionMargin;
  }

  public int getLeverRate() {
    return leverRate;
  }

  public void setLeverRate(int leverRate) {
    this.leverRate = leverRate;
  }

  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public float getLastPrice() {
    return lastPrice;
  }

  public void setLastPrice(float lastPrice) {
    this.lastPrice = lastPrice;
  }

}