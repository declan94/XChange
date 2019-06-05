package org.knowm.xchange.hbdm.service;

import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.hbdm.Hbdm;
import org.knowm.xchange.hbdm.HbdmExchange;
import org.knowm.xchange.hbdm.dto.HbdmResult;
import org.knowm.xchange.service.BaseExchangeService;
import org.knowm.xchange.service.BaseService;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.RestProxyFactory;

public class HbdmBaseService extends BaseExchangeService<HbdmExchange> implements BaseService {

  protected Hbdm hbdm;
  protected ParamsDigest signatureCreator;

  public HbdmBaseService(HbdmExchange exchange) {
    super(exchange);
    hbdm =
        RestProxyFactory.createProxy(
            Hbdm.class, exchange.getExchangeSpecification().getSslUri(), getClientConfig());
    signatureCreator =
        HbdmDigest.createInstance(exchange.getExchangeSpecification().getSecretKey());
  }

  protected <R> R checkResult(HbdmResult<R> huobiResult) {
    if (!huobiResult.isSuccess()) {
      String huobiError = huobiResult.getError();
      if (huobiError.length() == 0) {
        throw new ExchangeException("Missing error message");
      } else {
        throw new ExchangeException(huobiError);
      }
    }
    return huobiResult.getResult();
  }

}
