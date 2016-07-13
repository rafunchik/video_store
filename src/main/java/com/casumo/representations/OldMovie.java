package com.casumo.representations;

import com.casumo.services.MoviePricingService;

/**
 * Created by rcastro on 12/07/2016.
 */
public class OldMovie extends Movie {
    public OldMovie(String name) {
        super(name);
    }

    @Override
    public double calculateCost(int daysRented) {
        final double dailyCost = MoviePricingService.getBasicPrice();
        int maxDaysSamePrice = 5;
        return Movie.calculateCostWithDailySurcharge(daysRented, dailyCost, maxDaysSamePrice);
    }

    @Override
    public int calculateBonusPoints() {
        return 1;
    }

}
