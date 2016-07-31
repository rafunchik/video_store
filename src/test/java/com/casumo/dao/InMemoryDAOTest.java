package com.casumo.dao;

import com.casumo.representations.movie.Movie;
import com.casumo.representations.movie.RegularRelease;
import junit.framework.TestCase;


public class InMemoryDAOTest extends TestCase {
    private static final BaseDAO<Movie> moviedao = new InMemoryDAO<>();

    public void testSaveAndRetrieveMovie(){
        Movie movie = new RegularRelease("test");
        long id = movie.getId();
        moviedao.save(movie);
        assertEquals(movie, moviedao.getById(id));
    }

}
