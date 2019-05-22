package org.knowm.xchange.okex.v3;

import java.util.Base64;
import org.knowm.xchange.service.BaseParamsDigest;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.RestInvocation;

public class OkexDigest extends BaseParamsDigest implements ParamsDigest {

  public OkexDigest(String secretKeyBase64) throws IllegalArgumentException {
    super(secretKeyBase64, HMAC_SHA_256);
  }

  @Override
  public String digestParams(RestInvocation restInvocation) {
    StringBuilder messageBuilder =
        new StringBuilder(
            restInvocation.getHttpHeadersFromParams().get(OkexAuthenticated.ACCESS_TIMESTAMP_PARM));
    messageBuilder
        .append(restInvocation.getHttpMethod())
        .append("/")
        .append(restInvocation.getPath());
    if (restInvocation.getQueryString() != null && !restInvocation.getQueryString().isEmpty()) {
      messageBuilder.append("?").append(restInvocation.getQueryString());
    }
    messageBuilder.append(restInvocation.getRequestBody());
    return Base64.getEncoder()
        .encodeToString(getMac().doFinal(messageBuilder.toString().getBytes()));
  }
}
