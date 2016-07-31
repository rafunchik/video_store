package com.casumo.resources;

import com.casumo.dao.BaseDAO;
import com.casumo.representations.Customer;
import com.casumo.representations.movie.Movie;
import com.casumo.representations.Order;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@Path("videostore")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
    BaseDAO<Movie> movieDao;
    BaseDAO<Customer> customerDao;

    public CustomerResource(BaseDAO<Movie> movieDao, BaseDAO<Customer> customerDao) {
        this.movieDao = movieDao;
        this.customerDao = customerDao;
    }

    @PUT
    @Path("/customer/{customerId}/")
    public Response updateCustomer(@PathParam("customerId") long customerId, Customer customer){
        customer.setId(customerId);
        customer = customerDao.save(customer);
        //TODO if created return 201 (created with url)
        return Response.ok(customer).build();
    }

    @GET
    @Path("/customer/{customerId}/")
    public Response getCustomer(@PathParam("customerId") long customerId){
        Customer customer = customerDao.getById(customerId);
        return Response.ok(customer).build();
    }

    @POST
    @Path("/customer/{customerId}/order")
    public Response rentMovies(@PathParam("customerId") final long customerId, @FormParam("id") final List<Long> movieIds, @FormParam("days") final int days){
        Set<Movie> movies = new LinkedHashSet<>(movieIds.size());
        for (long id:movieIds){
            movies.add(movieDao.getById(id));
        }
        Customer customer = customerDao.getById(customerId);
        Order order = new Order(days, movies);
        customer.addOrder(order);
        return Response.ok(order).build();
        //TODO add OrderResource, and here instead of null, return a URL to the newly created order
        //return Response.created(null).build();
    }

    @POST
    @Path("/customer/{customerId}/movie/{movieId}")
    public Response returnMovie(@PathParam("customerId") final long customerId, @PathParam("movieId") final long movieId, @FormParam("days") final int days){
        Movie movie = movieDao.getById(movieId);
        return Response.ok(movie.calculateCost(days)).build();
    }
}
