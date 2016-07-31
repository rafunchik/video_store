package com.casumo.representations;

import com.casumo.representations.movie.Movie;
import com.casumo.representations.movie.NewRelease;
import com.casumo.representations.movie.OldMovie;
import com.casumo.representations.movie.RegularRelease;
import junit.framework.TestCase;


public class MoviesTest extends TestCase {
        Movie oldMovie, regularMovie, newMovie;
        public void setUp()
        {
            oldMovie = new OldMovie("");
            regularMovie = new RegularRelease("");
            newMovie = new NewRelease("");
        }

        /**
         *
         */
        public void testNewReleaseMoviePriceAndName()
        {
            String name = "Matrix";
            Movie movie = new NewRelease(name);
            assertEquals(120.0, movie.calculateCost(3));
            assertEquals(200.0, movie.calculateCost(5));
            assertEquals(name, movie.getName());
        }

        public void testRegularMoviePriceAndName()
        {
            String name = "Spider Man";
            Movie movie = new RegularRelease(name);
            assertEquals(30.0, movie.calculateCost(3));
            assertEquals(90.0, movie.calculateCost(5));
            assertEquals(name, movie.getName());
        }

        public void testOldMoviePriceAndName()
        {
            String name = "Out of Africa";
            Movie movie = new OldMovie(name);
            assertEquals(30.0, movie.calculateCost(5));
            assertEquals(60.0, movie.calculateCost(6));
            assertEquals(name, movie.getName());
        }

        public void testMovieRentalZeroDaysZeroCost()
        {
            assertEquals(0.0, oldMovie.calculateCost(0));
            assertEquals(0.0, newMovie.calculateCost(0));
            assertEquals(0.0, regularMovie.calculateCost(0));
        }

        public void testBonusPoints()
        {
            assertEquals(1, oldMovie.calculateBonusPoints());
            assertEquals(2, newMovie.calculateBonusPoints());
            assertEquals(1, regularMovie.calculateBonusPoints());
        }
}
