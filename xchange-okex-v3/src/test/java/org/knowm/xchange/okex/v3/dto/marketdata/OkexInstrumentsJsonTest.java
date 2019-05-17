package org.knowm.xchange.okex.v3.dto.marketdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class OkexInstrumentsJsonTest {

    @Test
    public void testUnmarshal() throws IOException {

        // Read in the JSON from the example resources
        InputStream is =
                OkexInstrumentsJsonTest.class.getResourceAsStream(
                        "/org/knowm/xchange/okex/v3/example-futures-instruments.json");

        ObjectMapper mapper = new ObjectMapper();
        FutruesInstrument[] okexInstruments = mapper.readValue(is, FutruesInstrument[].class);

        // Verify that the example data was unmarshalled correctly
        assertThat(okexInstruments.length).isEqualTo(3);
        assertThat(okexInstruments[0].getInstrumentId()).isEqualTo("BTC-USD-190322");
        assertThat(okexInstruments[0].getUnderlyingIndex()).isEqualTo("BTC");
        assertThat(okexInstruments[0].getQuoteCurrency()).isEqualTo("USD");
        assertThat(okexInstruments[0].getTickSize()).isEqualTo("0.01");
        assertThat(okexInstruments[0].getContractVal()).isEqualTo("100");
        assertThat(okexInstruments[0].getListing()).isEqualTo("2019-03-08");
        assertThat(okexInstruments[0].getDelivery()).isEqualTo("2019-03-22");
        assertThat(okexInstruments[0].getTradeIncrement()).isEqualTo("1");
        assertThat(okexInstruments[0].getAlias()).isEqualTo("this_week");
    }
}
