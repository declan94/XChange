package org.knowm.xchange.hbdm;

import com.fasterxml.jackson.annotation.JsonValue;

public enum HbdmPrompt {
  THIS_WEEK,
  NEXT_WEEK,
  QUARTER;

  @JsonValue
  @Override
  public String toString() {
    return super.toString().toLowerCase();
  }
}
