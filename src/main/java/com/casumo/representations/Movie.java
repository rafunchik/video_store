package com.casumo.representations;

/**
 * Created by rcastro on 12/07/2016.
 */
public abstract class Movie {
    public final int BASIC_PRICE = 30; // TODO read from config
    private final String name;
    private final int id;
    private static int ID_COUNTER;


    public Movie(String name) {
        this.name = name;
        ID_COUNTER++;
        id = ID_COUNTER;
    }

    public int getPrice(){
        return BASIC_PRICE;
    }
}
