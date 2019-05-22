package org.knowm.xchange.okex.v3.service;

import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.okex.v3.OkexDigest;
import org.knowm.xchange.okex.v3.OkexExchange;
import org.knowm.xchange.okex.v3.TimestampNonceFactory;

public class OkexBaseAuthenticatedService extends OkexBaseService {

    protected final TimestampNonceFactory timestampNonceFactory = new TimestampNonceFactory();

    protected final String apiKey;

    protected final String apiPassphrase;

    protected final OkexDigest okexDigest;

    /**
     * Constructor
     *
     * @param exchange
     */
    protected OkexBaseAuthenticatedService(OkexExchange exchange) {
        super(exchange);
        ExchangeSpecification specification = exchange.getExchangeSpecification();
        apiKey = specification.getApiKey();
        String apiSecret = specification.getSecretKey();
        if (specification.getExchangeSpecificParametersItem("Passphrase") == null) {
            apiPassphrase = specification.getPassword();
        } else {
            apiPassphrase = specification.getExchangeSpecificParametersItem("Passphrase").toString();
        }
        if (apiKey == null || apiSecret == null || apiPassphrase == null) {
            throw new ExchangeException("ApiKey, SecretKey or Passphrase not set!");
        }
        okexDigest = new OkexDigest(apiSecret);

    }

}
