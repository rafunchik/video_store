package com.casumo.representations;

/**
 * Created by rcastro on 12/07/2016.
 */
public class NewRelease extends Movie {
    public final int PREMIUM_PRICE = 40;

    public NewRelease(String name) {
        super(name);
    }

    @Override
    public int calculateCost(int daysRented) {
        return PREMIUM_PRICE;
    }

    @Override
    public int calculateBonusPoints(int daysRented) {
        return 0;
    }
}
