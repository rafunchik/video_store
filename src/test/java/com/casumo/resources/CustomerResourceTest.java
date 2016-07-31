package com.casumo.resources;

import com.casumo.dao.BaseDAO;
import com.casumo.dao.InMemoryDAO;
import com.casumo.representations.Customer;
import com.casumo.representations.Order;
import com.casumo.representations.movie.Movie;
import com.casumo.representations.movie.NewRelease;
import com.casumo.representations.movie.OldMovie;
import com.casumo.representations.movie.RegularRelease;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class CustomerResourceTest {
    private static final BaseDAO<Movie> movieDao = mock(InMemoryDAO.class);
    private static final BaseDAO<Customer> customerDao = new InMemoryDAO<>();

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new CustomerResource(movieDao, customerDao))
            .build();

    @Before
    public void setup() {
        Movie outOfAfrica = new OldMovie("Out of Africa");
        Movie spiderMan = new RegularRelease("Spiderman");
        Movie spiderMan2 = new RegularRelease("Spiderman 2");
        Movie matrix = new NewRelease("Matrix");
        when(movieDao.getById(1)).thenReturn(outOfAfrica);
        when(movieDao.getById(2)).thenReturn(spiderMan);
        when(movieDao.getById(3)).thenReturn(spiderMan2);
        when(movieDao.getById(4)).thenReturn(matrix);
        resources.client().target("/videostore/customer/1/").request().put(Entity.json(new Customer()), Customer.class);
    }


    private void assertOrderCost(Order order, double expectedCost) {
        assertEquals(expectedCost, order.calculateCost(), 0);
    }

    @Test
    public void testRentSomeMoviesAssertCost() {
        String targetUrl = "/videostore/customer/1/order";
        //Matrix 11 (New release) 1 days 40 SEK
        Form form = new Form();
        form.param("id", "4");
        form.param("days", "1");
        Order order = resources.client().target(targetUrl).request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), Order.class);
        assertOrderCost(order, 40.0);
        //Spider Man (Regular rental) 5 days 90 SEK
        form = new Form();
        form.param("id", "2");
        form.param("days", "5");
        order = resources.client().target(targetUrl).request().post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE), Order.class);
        assertOrderCost(order, 90.0);
        //Spider Man 2 (Regular rental) 2 days 30 SEK
        form = new Form();
        form.param("id", "3");
        form.param("days", "2");
        order = resources.client().target(targetUrl).request().post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE), Order.class);
        assertOrderCost(order, 30.0);
        //Out of Africa (Old film) 7 days 90 SEK
        form = new Form();
        form.param("id", "1");
        form.param("days", "7");
        order = resources.client().target(targetUrl).request().post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE), Order.class);
        assertOrderCost(order, 90.0);
        long expectedCost = 0;
        Customer testCostumer = resources.client().target("/videostore/customer/1/").request().get(Customer.class);
        for (Order o:testCostumer.getOrders()){
            expectedCost += o.calculateCost();
        }
        assertEquals(expectedCost, 250.0, 0);
    }

    @Test
    public void testSurchargeMoviesLateReturn() {
        //TODO remove code duplication
        Form form = new Form();
        form.param("days", "2");
        String targetUrl = "/videostore/customer/1/movie/4/";
        double cost = resources.client().target(targetUrl).request().post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE), Double.class);
        assertEquals(cost, 80.0, 0);
        form = new Form();
        form.param("days", "1");
        targetUrl = "/videostore/customer/1/movie/2/";
        cost = resources.client().target(targetUrl).request().post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE), Double.class);
        assertEquals(cost, 30.0, 0);
    }
}
