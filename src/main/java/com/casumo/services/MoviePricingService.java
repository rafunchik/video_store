package com.casumo.services;

import com.casumo.VideoStoreConfiguration;


public class MoviePricingService {
    private static VideoStoreConfiguration CONFIG = new VideoStoreConfiguration();
    public static double getPremiumPrice() {
        return CONFIG.getPremiumPrice();
    }
    public static double getBasicPrice() {
        return CONFIG.getBasicPrice();
    }

}
