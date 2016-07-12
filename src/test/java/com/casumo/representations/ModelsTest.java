package com.casumo.representations;

import com.casumo.VideoStoreConfiguration;
import junit.framework.TestCase;

/**
 * Created by rcastro on 12/07/2016.
 */
public class ModelsTest extends TestCase {
    public final int PREMIUM_PRICE = 40;
    public final int BASIC_PRICE = 30;

        /**
         *
         */
        public void testNewReleaseMoviePrice()
        {
            Movie movie = new NewRelease("Matrix");
            assertEquals(PREMIUM_PRICE, movie.getPrice());
        }

        public void testRegularMoviePrice()
        {
            Movie movie = new RegularRelease("Spider Man");
            assertEquals(BASIC_PRICE, movie.getPrice());
        }

        public void testOldMoviePrice()
        {
            Movie movie = new OldMovie("Out of Africa");
            assertEquals(BASIC_PRICE, movie.getPrice());
        }
}
