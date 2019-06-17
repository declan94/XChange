package org.knowm.xchange.hbdm.dto.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

public class HbdmDepth {

  private final BigDecimal[][] asks;
  private final BigDecimal[][] bids;
  private final Date timestamp;

  public HbdmDepth(
      @JsonProperty("asks") final BigDecimal[][] asks,
      @JsonProperty("bids") final BigDecimal[][] bids,
      @JsonProperty("ts") Date timestamp) {

    this.asks = asks;
    this.bids = bids;
    this.timestamp = timestamp;
  }

  public BigDecimal[][] getAsks() {

    return asks;
  }

  public BigDecimal[][] getBids() {

    return bids;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {

    return "HBDM Depth [asks=" + Arrays.toString(asks) + ", bids=" + Arrays.toString(bids) + "]";
  }
}
