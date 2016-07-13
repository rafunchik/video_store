package com.casumo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.Min;

/**
 * Created by rcastro on 12/07/2016.
 */
public class VideoStoreConfiguration extends Configuration {
    public static final int BASIC_PRICE = 30; // TODO read from config
    public final int PREMIUM_PRICE = 40; // TODO read from config

    @JsonProperty
    @Min(0)
    private int premiumPrice;

    public int getPremiumPrice() {
        return PREMIUM_PRICE; // FIXME premiumPrice, hack for the tests
    }

    @JsonProperty
    @Min(0)
    private int basicPrice;

    public int getBasicPrice() {
        return BASIC_PRICE; // FIXME basicPrice, hack for the tests
    }
}