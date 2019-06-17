package org.knowm.xchange.hbdm.dto.market;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;

public class HbdmDepthJsonTest {

  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is =
        HbdmDepthJsonTest.class.getResourceAsStream("/org/knowm/xchange/hbdm/hbdm_depth.json");

    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    HbdmDepth depth = mapper.readValue(is, HbdmDepth.class);

    // Verify that the example data was unmarshalled correctly
    assertThat(depth.getAsks()[0][0].doubleValue()).isEqualTo(7979);
  }
}
