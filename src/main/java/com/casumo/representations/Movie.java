package com.casumo.representations;

/**
 * Created by rcastro on 12/07/2016.
 */
public abstract class Movie {
    private final String name;
    private final long id;
    private static long ID_COUNTER;


    public Movie(String name) { // TODO add non blank name check
        this.name = name;
        ID_COUNTER++;
        id = ID_COUNTER;
    }

    public String getName() {
        return name;
    }

    public abstract int calculateCost(int daysRented);

    public abstract int calculateBonusPoints(int daysRented);

    public long getId() {
        return id;
    }
}
