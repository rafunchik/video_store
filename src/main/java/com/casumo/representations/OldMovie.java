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
    public int calculateCost(int daysRented) {
        return MoviePricingService.getBasicPrice() * daysRented;
    }

    @Override
    public int calculateBonusPoints(int daysRented) {
        return 0;
    }

}
