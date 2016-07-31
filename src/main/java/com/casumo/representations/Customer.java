package com.casumo.representations;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Customer implements StorableModel {
    private long id;
    private List<Order> orders;


    public Customer(long customerId){
        this();
        id = customerId;

    }

    public Customer(){
        orders = new ArrayList<>();

    }

    @JsonIgnore
    public int getBonusPoints() {
        int bonusPoints = 0;
        for (Order order:orders){
            bonusPoints += order.calculateBonusPoints();
        }
        return bonusPoints;
    }


    @Override
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
