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

    public double calculateCost(int daysRented) {
        double cost = 0;
        for (Movie movie:movies)
            cost += movie.calculateCost(daysRented);
        return cost;
    }

    public int calculateBonusPoints() {
        int points = 0;
        for (Movie movie:movies)
            points += movie.calculateBonusPoints();
        return points;
    }
}
