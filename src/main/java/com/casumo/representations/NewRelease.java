package com.casumo.representations;

import com.casumo.services.MoviePricingService;

/**
 * Created by rcastro on 12/07/2016.
 */
public class NewRelease extends Movie {

    public NewRelease(String name) {
        super(name);
    }

    @Override
    public double calculateCost(int daysRented) {
        final double dailyCost = MoviePricingService.getPremiumPrice();
        int maxDaysSamePrice = 1;
        return Movie.calculateCostWithDailySurcharge(daysRented, dailyCost, maxDaysSamePrice);
    }

    @Override
    public int calculateBonusPoints() {
        return 2;
    }
}
