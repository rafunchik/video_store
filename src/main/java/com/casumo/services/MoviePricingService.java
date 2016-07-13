package com.casumo.services;

import com.casumo.VideoStoreConfiguration;
import com.casumo.representations.Movie;

/**
 * Created by rcastro on 12/07/2016.
 */
public class MoviePricingService {
    private static VideoStoreConfiguration CONFIG = new VideoStoreConfiguration();
    public static int getPremiumPrice() {
        return CONFIG.getPremiumPrice();
    }
    public static int getBasicPrice() {
        return CONFIG.getBasicPrice();
    }

}
