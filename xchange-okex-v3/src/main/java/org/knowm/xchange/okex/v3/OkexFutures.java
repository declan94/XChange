package org.knowm.xchange.okex.v3;

import org.knowm.xchange.okex.v3.dto.marketdata.FuturesInstrument;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("api/futures/v3")
@Produces(MediaType.APPLICATION_JSON)
public interface OkexFutures {

    @GET
    @Path("instruments")
    FuturesInstrument[] getInstruments();

}
