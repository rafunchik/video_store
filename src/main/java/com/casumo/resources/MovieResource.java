package com.casumo.resources;

import com.casumo.dao.BaseDAO;
import com.casumo.representations.Customer;
import com.casumo.representations.movie.Movie;
import com.casumo.representations.movie.NewRelease;

import javax.ws.rs.*;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("videostore")
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {
    BaseDAO<Movie> movieDao;

    public MovieResource(BaseDAO<Movie> movieDao) {
        this.movieDao = movieDao;
    }

    @PUT
    @Path("/movie/{movieId}/")
    public Response updateMovie(@PathParam("movieId") long movieId, Movie movie){
        movie.setId(movieId);
        movie = movieDao.save(movie);
        //TODO if created return 201 (created with url) otherwise 204
        return Response.ok(movie).build();
    }
}
