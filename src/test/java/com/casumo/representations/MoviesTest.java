package com.casumo.representations;

import junit.framework.TestCase;

/**
 * Created by rcastro on 12/07/2016.
 */
public class MoviesTest extends TestCase {

        /**
         *
         */
        public void testNewReleaseMoviePriceAndName()
        {
            String name = "Matrix";
            Movie movie = new NewRelease(name);
            assertEquals(120, movie.calculateCost(3));
            assertEquals(200, movie.calculateCost(5));
            assertEquals(name, movie.getName());
        }

        public void testRegularMoviePriceAndName()
        {
            String name = "Spider Man";
            Movie movie = new RegularRelease(name);
            assertEquals(30, movie.calculateCost(3));
            assertEquals(90, movie.calculateCost(5));
            assertEquals(name, movie.getName());
        }

        public void testOldMoviePriceAndName()
        {
            String name = "Out of Africa";
            Movie movie = new OldMovie(name);
            assertEquals(30, movie.calculateCost(5));
            assertEquals(60, movie.calculateCost(6));
            assertEquals(name, movie.getName());
        }

        public void testIDIncrement()
        {
            Movie movie = new NewRelease("");
            long id = movie.getId();
            movie = new RegularRelease("");
            assertEquals(id+1, movie.getId());
            movie = new OldMovie("");
            assertEquals(id+2, movie.getId());
            movie = new NewRelease("");
            assertEquals(id+3, movie.getId());
        }
}
