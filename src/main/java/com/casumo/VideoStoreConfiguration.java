package com.casumo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.Min;

/**
 * Created by rcastro on 12/07/2016.
 */
public class VideoStoreConfiguration extends Configuration {

    @JsonProperty
    @Min(0)
    private int premiumPrice;

    public int getPremiumPrice() {
        return premiumPrice;
    }

    @JsonProperty
    @Min(0)
    private int basicPrice;

    public int getBasicPrice() {
        return premiumPrice;
    }
}