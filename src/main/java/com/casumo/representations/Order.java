package com.casumo.representations;

/**
 * Created by rafaelcastro on 7/13/16.
 */
public class Order {

    private Movie movie;
    private int daysRented;

    public Order (Movie movie, int daysRented) {
        this.movie 		= movie;
        this.daysRented = daysRented;
    }

    public String getName() {
        return movie.getName();
    }

    public double calculateCost() {
        return movie.calculateCost(daysRented);
    }

//    public int getCostumBonusPoints() {
//        return movie.determineFrequentRenterPoints(daysRented);
//    }
}
