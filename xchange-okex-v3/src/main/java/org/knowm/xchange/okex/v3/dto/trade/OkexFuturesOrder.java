package org.knowm.xchange.okex.v3.dto.trade;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "client_oid",
  "order_type",
  "instrument_id",
  "type",
  "price",
  "size",
  "match_price",
  "leverage"
})
public class OkexFuturesOrder {

  @JsonProperty("client_oid")
  private String clientOid;

  @JsonProperty("order_type")
  private String orderType;

  @JsonProperty("instrument_id")
  private String instrumentId;

  @JsonProperty("type")
  private String type;

  @JsonProperty("price")
  private String price;

  @JsonProperty("size")
  private String size;

  @JsonProperty("match_price")
  private String matchPrice;

  @JsonProperty("leverage")
  private String leverage;

  @JsonProperty("client_oid")
  public String getClientOid() {
    return clientOid;
  }

  @JsonProperty("client_oid")
  public void setClientOid(String clientOid) {
    this.clientOid = clientOid;
  }

  @JsonProperty("order_type")
  public String getOrderType() {
    return orderType;
  }

  @JsonProperty("order_type")
  public void setOrderType(String orderType) {
    this.orderType = orderType;
  }

  @JsonProperty("instrument_id")
  public String getInstrumentId() {
    return instrumentId;
  }

  @JsonProperty("instrument_id")
  public void setInstrumentId(String instrumentId) {
    this.instrumentId = instrumentId;
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("price")
  public String getPrice() {
    return price;
  }

  @JsonProperty("price")
  public void setPrice(String price) {
    this.price = price;
  }

  @JsonProperty("size")
  public String getSize() {
    return size;
  }

  @JsonProperty("size")
  public void setSize(String size) {
    this.size = size;
  }

  @JsonProperty("match_price")
  public String getMatchPrice() {
    return matchPrice;
  }

  @JsonProperty("match_price")
  public void setMatchPrice(String matchPrice) {
    this.matchPrice = matchPrice;
  }

  @JsonProperty("leverage")
  public String getLeverage() {
    return leverage;
  }

  @JsonProperty("leverage")
  public void setLeverage(String leverage) {
    this.leverage = leverage;
  }
}
