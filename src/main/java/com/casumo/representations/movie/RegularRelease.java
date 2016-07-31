package com.casumo.representations.movie;

import com.casumo.services.MoviePricingService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public class RegularRelease extends Movie {

    public RegularRelease(String name) {
        super(name);
    }
    public RegularRelease() {
        super();
    }
    @Override
    public double calculateCost(int daysRented) {
        final double priceIncrement = MoviePricingService.getBasicPrice();
        int maxDaysSamePrice = 3;
        return calculateCostWithDailySurcharge(daysRented, priceIncrement, maxDaysSamePrice);
    }

    @Override
    public int calculateBonusPoints() {
        return 1;
    }

}
