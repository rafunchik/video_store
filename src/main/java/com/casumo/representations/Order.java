package com.casumo.representations;

import com.casumo.representations.movie.Movie;

import java.util.Collection;


public class Order implements StorableModel{
    private long id;
    private  Collection<Movie> movies;
    private  int daysRented;

    public Order(int daysRented, Collection<Movie> movies) {
        this.movies		= movies;
        this.daysRented = daysRented;
    }

    public Order (){
    }

    public double calculateCost() {
        double expectedCost = 0;
        for (Movie movie:movies)
            expectedCost += movie.calculateCost(daysRented);
        return expectedCost;
    }

    public int calculateBonusPoints() {
        int expectedPoints = 0;
        for (Movie movie:movies)
            expectedPoints += movie.calculateBonusPoints();
        return expectedPoints;
    }

    public int getDaysRented(){
        return daysRented;
    }

    public Collection<Movie> getMovies(){
        return movies;
    }
    public void setDaysRented(int daysRented){
        this.daysRented=daysRented;
    }

    public void setMovies(Collection<Movie> movies){
        this.movies = movies;
    }

    @Override
    public long getId() {
        return id;
    }
}
