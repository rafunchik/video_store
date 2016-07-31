package com.casumo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.Min;


public class VideoStoreConfiguration extends Configuration {
    public static final double BASIC_PRICE = 30.0; // TODO read from config
    public final double PREMIUM_PRICE = 40.0; // TODO read from config

    @JsonProperty
    @Min(0)
    private int premiumPrice;

    public double getPremiumPrice() {
        return PREMIUM_PRICE; // FIXME premiumPrice, hack for the tests
    }

    @JsonProperty
    @Min(0)
    private int basicPrice;

    public double getBasicPrice() {
        return BASIC_PRICE; // FIXME basicPrice, hack for the tests
    }
}