package com.casumo.representations;

/**
 * Created by rcastro on 12/07/2016.
 */
public abstract class Movie {
    private final String name;
    private final long id;
    private static long ID_COUNTER;


    public Movie(String name) { // TODO add non blank & non null name check
        this.name = name;
        ID_COUNTER++;
        id = ID_COUNTER;
    }

    protected static double calculateCostWithDailySurcharge(int daysRented, double dailyCost, int maxDaysSamePrice) {
        double cost = 0;
        if (daysRented > 0)
            cost += dailyCost;
        if (daysRented > maxDaysSamePrice)
            cost += ((daysRented - maxDaysSamePrice) * dailyCost);
        return cost;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateCost(int daysRented);

    public abstract int calculateBonusPoints();

    public long getId() {
        return id;
    }
}
