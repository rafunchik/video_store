package com.casumo.representations;

import java.util.Collection;

/**
 * Created by rafaelcastro on 7/13/16.
 */
public class Order {

    private Collection<Movie> movies;
    private int daysRented;

    public Order (Collection<Movie> movies, int daysRented) {
        this.movies		= movies;
        this.daysRented = daysRented;
    }

    public double calculateCost() {
        return movie.calculateCost(daysRented);
    }

    public int calculateBonusPoints() {
        return movie.determineFrequentRenterPoints(daysRented);
    }
}
