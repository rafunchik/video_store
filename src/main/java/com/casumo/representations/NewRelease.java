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
    public int getPrice(){
        return PREMIUM_PRICE;
    }
}
