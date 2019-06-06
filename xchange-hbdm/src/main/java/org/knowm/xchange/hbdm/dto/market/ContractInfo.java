package org.knowm.xchange.hbdm.dto.market;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContractInfo {

  @JsonProperty("symbol")
  private String symbol;

  @JsonProperty("contract_code")
  private String contractCode;

  @JsonProperty("contract_type")
  private String contractType;

  @JsonProperty("contract_size")
  private int contractSize;

  @JsonProperty("price_tick")
  private float priceTick;

  @JsonProperty("delivery_date")
  private String deliveryDate;

  @JsonProperty("create_date")
  private String createDate;

  @JsonProperty("contract_status")
  private int contractStatus;

  public String getSymbol() {
    return symbol;
  }

  public String getContractCode() {
    return contractCode;
  }

  public String getContractType() {
    return contractType;
  }

  public int getContractSize() {
    return contractSize;
  }

  public float getPriceTick() {
    return priceTick;
  }

  public String getDeliveryDate() {
    return deliveryDate;
  }

  public String getCreateDate() {
    return createDate;
  }

  public int getContractStatus() {
    return contractStatus;
  }
}
