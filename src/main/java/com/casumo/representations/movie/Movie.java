package com.casumo.representations.movie;

import com.casumo.representations.StorableModel;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public abstract class Movie implements StorableModel {
    private String name; // ie Title
    private long id;


    public Movie(String name) { // TODO add non blank & non null name check
        this();
        this.name = name;

    }

    public Movie() {
    }


    protected double calculateCostWithDailySurcharge(int daysRented, double dailyCost, int maxDaysSamePrice) {
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

    public void setId(long id) {
        this.id = id;
    }
}
