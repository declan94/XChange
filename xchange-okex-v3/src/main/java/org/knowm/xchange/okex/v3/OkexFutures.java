package org.knowm.xchange.okex.v3;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.knowm.xchange.okex.v3.dto.marketdata.FuturesInstrument;
import org.knowm.xchange.okex.v3.dto.trade.OkexFuturesOrder;
import org.knowm.xchange.okex.v3.dto.trade.OkexFuturesOrderResult;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.SynchronizedValueFactory;

@SuppressWarnings("ALL")
@Path("api/futures/v3")
@Produces(MediaType.APPLICATION_JSON)
public interface OkexFutures extends OkexAuthenticated{

    @GET
    @Path("instruments")
    FuturesInstrument[] getInstruments();

    @POST
    @Path("order")
    @Consumes(MediaType.APPLICATION_JSON)
    OkexFuturesOrderResult placeFuturesOrder(
            OkexFuturesOrder order,
            @HeaderParam(ACCESS_KEY_PARAM) String accessKey,
            @HeaderParam(ACCESS_PASSPHRASE_PARAM) String passphrase,
            @HeaderParam(ACCESS_TIMESTAMP_PARM) SynchronizedValueFactory<String> timestamp,
            @HeaderParam(ACCESS_SIGN_PARAM) ParamsDigest sign
            );


}
