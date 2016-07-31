package com.casumo.representations.movie;

import com.casumo.services.MoviePricingService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public class OldMovie extends Movie {
    public OldMovie(String name) {
        super(name);
    }
    public OldMovie() {
        super();
    }
    @Override
    public double calculateCost(int daysRented) {
        final double dailyCost = MoviePricingService.getBasicPrice();
        int maxDaysSamePrice = 5;
        return calculateCostWithDailySurcharge(daysRented, dailyCost, maxDaysSamePrice);
    }

    @Override
    public int calculateBonusPoints() {
        return 1;
    }

}
