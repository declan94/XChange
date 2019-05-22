package org.knowm.xchange.okex.v3;

import si.mazi.rescu.SynchronizedValueFactory;

public class TimestampNonceFactory implements SynchronizedValueFactory<String> {

  @Override
  public String createValue() {
    return String.format("%.3f", (double) System.currentTimeMillis() / 1000);
  }
}
