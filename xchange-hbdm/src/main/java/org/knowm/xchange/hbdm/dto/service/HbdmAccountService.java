package org.knowm.xchange.hbdm.dto.service;

import org.knowm.xchange.hbdm.HbdmExchange;
import org.knowm.xchange.service.account.AccountService;

public class HbdmAccountService extends HbdmAccountServiceRaw implements AccountService {
  public HbdmAccountService(HbdmExchange exchange) {
    super(exchange);
  }
}
