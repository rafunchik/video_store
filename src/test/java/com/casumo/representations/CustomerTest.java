package com.casumo.representations;

import com.casumo.representations.movie.Movie;
import com.casumo.representations.movie.NewRelease;
import com.casumo.representations.movie.OldMovie;
import com.casumo.representations.movie.RegularRelease;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class CustomerTest extends TestCase {
    private static final Random randomGenerator = new Random();
    private List<Order> orders;


    private Order getRandomOrder(){
        //TODO randomize
        Movie outOfAfrica = new OldMovie("Out of Africa");
        Movie spiderMan = new RegularRelease("Spiderman");
        Movie spiderMan2 = new RegularRelease("Spiderman 2");
        Movie matrix = new NewRelease("Matrix");
        Movie [] movies = {outOfAfrica, spiderMan, spiderMan2, matrix};
        return new Order(randomGenerator.nextInt(10), Arrays.asList(movies));
    }

    public void setUp(){
        int numOrders = randomGenerator.nextInt(10);
        orders = new ArrayList<>(numOrders);
        while (numOrders>0){
            orders.add(getRandomOrder());
            numOrders--;
        }
    }


    public void testBonusPointsEqualSumOrderPoints(){
        int expectedPoints = 0;
        Customer customer = new Customer(1);
        customer.setOrders(orders);
        for (Order order:orders){
            expectedPoints += order.calculateBonusPoints();
        }
        assertEquals(expectedPoints, customer.getBonusPoints());
    }

    public void testAddingOrderAddsBonusPoints(){
        int expectedPoints = 0;
        Customer customer = new Customer(1);
        Order order = orders.get(0);
        customer.addOrder(order);
        expectedPoints += order.calculateBonusPoints();
        assertEquals(expectedPoints, customer.getBonusPoints());
    }
}
