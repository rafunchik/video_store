package com.casumo.resources;


import com.casumo.dao.BaseDAO;
import com.casumo.dao.InMemoryDAO;
import com.casumo.representations.movie.Movie;
import com.casumo.representations.movie.NewRelease;
import com.casumo.representations.movie.OldMovie;
import com.casumo.representations.movie.RegularRelease;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Entity;

import static org.junit.Assert.assertEquals;


public class MovieResourceTest {
    private static final BaseDAO<Movie> movieDao = new InMemoryDAO<>();

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new MovieResource(movieDao))
            .build();


    @Test
    public void testCreateMovies() {
        //new release
        String name = "new release";
        Movie movie = new NewRelease(name);
        resources.client().target("/videostore/movie/10/").request().put(Entity.json(movie), NewRelease.class);
        assertEquals(name, movieDao.getById(10).getName());
        name = "regular release";
        movie = new RegularRelease(name);
        resources.client().target("/videostore/movie/11/").request().put(Entity.json(movie), RegularRelease.class);
        assertEquals(name, movieDao.getById(11).getName());
        name = "old release";
        movie = new OldMovie(name);
        resources.client().target("/videostore/movie/12/").request().put(Entity.json(movie), OldMovie.class);
        assertEquals(name, movieDao.getById(12).getName());
    }
}
