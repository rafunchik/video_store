package com.casumo.representations.movie;

import com.casumo.services.MoviePricingService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public class NewRelease extends Movie {

    public NewRelease(String name) {
        super(name);
    }
    public NewRelease() {
        super();
    }
    @Override
    public double calculateCost(int daysRented) {
        final double dailyCost = MoviePricingService.getPremiumPrice();
        int maxDaysSamePrice = 1;
        return calculateCostWithDailySurcharge(daysRented, dailyCost, maxDaysSamePrice);
    }

    @Override
    public int calculateBonusPoints() {
        return 2;
    }
}
