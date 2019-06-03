package org.knowm.xchange.hbdm;

import org.knowm.xchange.hbdm.dto.HbdmResult;
import org.knowm.xchange.hbdm.dto.account.HbdmContractAccount;
import si.mazi.rescu.ParamsDigest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Map;


public interface Hbdm {

  @POST
  @Path("api/v1/contract_account_info")
  @Consumes(MediaType.APPLICATION_JSON)
  HbdmResult<HbdmContractAccount[]> getContractAccounts(
      Map<String, String> params,
      @QueryParam("AccessKeyId") String apiKey,
      @QueryParam("SignatureMethod") String signatureMethod,
      @QueryParam("SignatureVersion") int signatureVersion,
      @QueryParam("Timestamp") String nonce,
      @QueryParam("Signature") ParamsDigest signature)
      throws IOException;

}
