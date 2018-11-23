package org.knowm.xchange.okcoin.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class OkCoinFutureIndex {

  private final BigDecimal futureIndex;

  public OkCoinFutureIndex(@JsonProperty("future_index") final BigDecimal future_index) {
    this.futureIndex = future_index;
  }

  public BigDecimal getFutureIndex() {
    return futureIndex;
  }

  @Override
  public String toString() {
    return "OkCoinFutureIndex [future_index=" + futureIndex + "]";
  }
}
