package org.knowm.xchange.hbdm.service;

import org.knowm.xchange.hbdm.HbdmExchange;
import org.knowm.xchange.hbdm.HbdmPrompt;
import org.knowm.xchange.hbdm.dto.HbdmResult;
import org.knowm.xchange.hbdm.dto.market.ContractInfo;

import java.io.IOException;

public class HbdmMarketDataServiceRaw extends HbdmBaseService {

  public HbdmMarketDataServiceRaw(HbdmExchange exchange) {
    super(exchange);
  }

  public ContractInfo[] getContractInfo(String symbol, HbdmPrompt contractType, String contractCode) throws IOException {
    HbdmResult<ContractInfo[]> result = hbdm.getContractInfo(symbol,
        contractType == null ? null : contractType.toString(),
        contractCode);
    return checkResult(result);
  }

}
