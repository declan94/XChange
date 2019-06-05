package org.knowm.xchange.hbdm.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.hbdm.HbdmPrompt;

import java.math.BigDecimal;

public class HbdmCreateOrderRequest {

  public static final String DIRECTION_BUY = "buy";

  public static final String DIRECTION_SELL = "sell";

  public static final String OFFSET_OPEN = "open";

  public static final String OFFSET_CLOSE = "close";

  public static final String ORDER_PRICE_TYPE_LIMIT = "limit";

  public static final String ORDER_PRICE_TYPE_OPPONENT = "opponent";

  public static final String ORDER_PRICE_TYPE_POST_ONLY = "post_only";

  @JsonProperty("symbol")
  private String symbol;

  @JsonProperty("contract_type")
  private HbdmPrompt contractType;

  @JsonProperty("contract_code")
  private String contractCode;

  @JsonProperty("client_order_id")
  private Long clientOrderId;

  @JsonProperty("price")
  private BigDecimal price;

  @JsonProperty("volume")
  private long volume;

  @JsonProperty("direction")
  private String direction;

  @JsonProperty("offset")
  private String offset;

  @JsonProperty("lever_rate")
  private int leverRate;

  @JsonProperty("order_price_type")
  private String orderPriceType;


  public HbdmCreateOrderRequest(String symbol, HbdmPrompt contractType, BigDecimal price, long volume, String direction, String offset, int leverRate, String orderPriceType) {
    this.symbol = symbol;
    this.contractType = contractType;
    this.price = price;
    this.volume = volume;
    this.direction = direction;
    this.offset = offset;
    this.leverRate = leverRate;
    this.orderPriceType = orderPriceType;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public HbdmPrompt getContractType() {
    return contractType;
  }

  public void setContractType(HbdmPrompt contractType) {
    this.contractType = contractType;
  }

  public String getContractCode() {
    return contractCode;
  }

  public void setContractCode(String contractCode) {
    this.contractCode = contractCode;
  }

  public Long getClientOrderId() {
    return clientOrderId;
  }

  public void setClientOrderId(Long clientOrderId) {
    this.clientOrderId = clientOrderId;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public long getVolume() {
    return volume;
  }

  public void setVolume(long volume) {
    this.volume = volume;
  }

  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public String getOffset() {
    return offset;
  }

  public void setOffset(String offset) {
    this.offset = offset;
  }

  public int getLeverRate() {
    return leverRate;
  }

  public void setLeverRate(int leverRate) {
    this.leverRate = leverRate;
  }

  public String getOrderPriceType() {
    return orderPriceType;
  }

  public void setOrderPriceType(String orderPriceType) {
    this.orderPriceType = orderPriceType;
  }

}
