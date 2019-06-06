package org.knowm.xchange.hbdm.service;

import org.knowm.xchange.hbdm.HbdmExchange;
import org.knowm.xchange.hbdm.dto.HbdmResult;
import org.knowm.xchange.hbdm.dto.account.HbdmContractAccount;
import org.knowm.xchange.hbdm.dto.account.HbdmContractPosition;
import org.knowm.xchange.huobi.HuobiUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HbdmAccountServiceRaw extends HbdmBaseService {

  public HbdmAccountServiceRaw(HbdmExchange exchange) {
    super(exchange);
  }

  public HbdmContractAccount[] getContractAccounts(String symbol) throws IOException {
    Map<String, String> params = null;
    if (symbol != null) {
      params = new HashMap<>();
      params.put("symbol", symbol);
    }
    HbdmResult<HbdmContractAccount[]> result = hbdm.getContractAccounts(
        params,
        exchange.getExchangeSpecification().getApiKey(),
        HbdmDigest.HMAC_SHA_256,
        2,
        HuobiUtils.createUTCDate(exchange.getNonceFactory()),
        signatureCreator
    );
    return checkResult(result);
  }

  public HbdmContractPosition[] getContractPositions(String symbol) throws IOException {
    Map<String, String> params = null;
    if (symbol != null) {
      params = new HashMap<>();
      params.put("symbol", symbol);
    }
    HbdmResult<HbdmContractPosition[]> result = hbdm.getContractPositions(
        params,
        exchange.getExchangeSpecification().getApiKey(),
        HbdmDigest.HMAC_SHA_256,
        2,
        HuobiUtils.createUTCDate(exchange.getNonceFactory()),
        signatureCreator
    );
    return checkResult(result);
  }


}
