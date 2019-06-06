package org.knowm.xchange.hbdm;

import org.knowm.xchange.hbdm.dto.HbdmResult;
import org.knowm.xchange.hbdm.dto.account.HbdmContractAccount;
import org.knowm.xchange.hbdm.dto.account.HbdmContractPosition;
import org.knowm.xchange.hbdm.dto.market.ContractInfo;
import org.knowm.xchange.hbdm.dto.trade.HbdmCreateOrderRequest;
import org.knowm.xchange.hbdm.dto.trade.HbdmOrderResponse;
import si.mazi.rescu.ParamsDigest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Map;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public interface Hbdm {

  @GET
  @Path("api/v1/contract_contract_info")
  HbdmResult<ContractInfo[]> getContractInfo(
      @QueryParam("symbol") String symbol,
      @QueryParam("contract_type") String contractType,
      @QueryParam("contract_code") String contract_code)
      throws IOException;

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

  @POST
  @Path("api/v1/contract_position_info")
  @Consumes(MediaType.APPLICATION_JSON)
  HbdmResult<HbdmContractPosition[]> getContractPositions(
      Map<String, String> params,
      @QueryParam("AccessKeyId") String apiKey,
      @QueryParam("SignatureMethod") String signatureMethod,
      @QueryParam("SignatureVersion") int signatureVersion,
      @QueryParam("Timestamp") String nonce,
      @QueryParam("Signature") ParamsDigest signature)
      throws IOException;

  @POST
  @Path("api/v1/contract_order")
  @Consumes(MediaType.APPLICATION_JSON)
  HbdmResult<HbdmOrderResponse> placeOrder(
      HbdmCreateOrderRequest createOrderRequest,
      @QueryParam("AccessKeyId") String apiKey,
      @QueryParam("SignatureMethod") String signatureMethod,
      @QueryParam("SignatureVersion") int signatureVersion,
      @QueryParam("Timestamp") String nonce,
      @QueryParam("Signature") ParamsDigest signature)
      throws IOException;

}
