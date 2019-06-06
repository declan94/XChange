package org.knowm.xchange.hbdm.dto.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HbdmContractPosition {

  public static final String DIRECTION_BUY = "buy";

  public static final String DIRECTION_SELL = "sell";

  @JsonProperty("symbol")
  private String symbol;

  @JsonProperty("contract_code")
  private String contractCode;

  @JsonProperty("contract_type")
  private String contractType;

  @JsonProperty("volume")
  private long volume;

  @JsonProperty("available")
  private double available;

  @JsonProperty("frozen")
  private double frozen;

  @JsonProperty("cost_open")
  private double costOpen;

  @JsonProperty("cost_hold")
  private double costHold;

  @JsonProperty("profit_unreal")
  private double profitUnreal;

  @JsonProperty("profit_rate")
  private double profitRate;

  @JsonProperty("profit")
  private double profit;

  @JsonProperty("position_margin")
  private double positionMargin;

  @JsonProperty("lever_rate")
  private int leverRate;

  @JsonProperty("direction")
  private String direction;

  @JsonProperty("last_price")
  private double lastPrice;

  public String getSymbol() {
    return symbol;
  }

  public String getContractCode() {
    return contractCode;
  }

  public String getContractType() {
    return contractType;
  }

  public long getVolume() {
    return volume;
  }

  public double getAvailable() {
    return available;
  }

  public double getFrozen() {
    return frozen;
  }

  public double getCostOpen() {
    return costOpen;
  }

  public double getCostHold() {
    return costHold;
  }

  public double getProfitUnreal() {
    return profitUnreal;
  }

  public double getProfitRate() {
    return profitRate;
  }

  public double getProfit() {
    return profit;
  }

  public double getPositionMargin() {
    return positionMargin;
  }

  public int getLeverRate() {
    return leverRate;
  }

  public String getDirection() {
    return direction;
  }

  public double getLastPrice() {
    return lastPrice;
  }
}
