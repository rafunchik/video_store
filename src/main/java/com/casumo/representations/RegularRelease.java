package com.casumo.representations;

import com.casumo.services.MoviePricingService;

/**
 * Created by rcastro on 12/07/2016.
 */
public class RegularRelease extends Movie {

    public RegularRelease(String name) {
        super(name);
    }

    @Override
    public double calculateCost(int daysRented) {
        final double priceIncrement = MoviePricingService.getBasicPrice();
        int maxDaysSamePrice = 3;
        return Movie.calculateCostWithDailySurcharge(daysRented, priceIncrement, maxDaysSamePrice);
    }

    @Override
    public int calculateBonusPoints() {
        return 1;
    }

}
