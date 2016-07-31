package com.casumo.representations;

import com.casumo.representations.movie.Movie;
import com.casumo.representations.movie.NewRelease;
import com.casumo.representations.movie.OldMovie;
import com.casumo.representations.movie.RegularRelease;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class OrderTest extends TestCase {
    private static final Random randomGenerator = new Random();
    private List<Movie> movies;
    private int numDaysRental;

    private Movie getRandomMovie(){
        Movie [] movies = {new OldMovie("old movie"), new RegularRelease("regular release"), new NewRelease("new release")};
        int index = randomGenerator.nextInt(movies.length);
        return movies[index];
    }

    public void setUp(){
        int numMovies = randomGenerator.nextInt(10);
        numDaysRental = randomGenerator.nextInt(10);
        movies = new ArrayList<>(numMovies);
        while (numMovies>0){
            movies.add(getRandomMovie());
            numMovies--;
        }

    }

    public void testOrderCostEqualsSumMoviesCost(){
        double expectedCost = 0;
        for (Movie movie:movies){
            expectedCost += movie.calculateCost(numDaysRental);
        }
        Order order = new Order(numDaysRental, movies);
        assertEquals(expectedCost, order.calculateCost());
    }

    public void testOrderPointsEqualSumMoviesPoints(){
        int expectedPoints = 0;
        for (Movie movie:movies){
            expectedPoints += movie.calculateBonusPoints();
        }
        Order order = new Order(numDaysRental, movies);
        assertEquals(expectedPoints, order.calculateBonusPoints());
    }
}
