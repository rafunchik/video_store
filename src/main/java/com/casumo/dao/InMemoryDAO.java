package com.casumo.dao;

import com.casumo.representations.StorableModel;

import java.util.HashMap;
import java.util.Map;


public class InMemoryDAO<T extends StorableModel> implements BaseDAO<T> {
    Map<Long, T> store;

    public InMemoryDAO(){
        store = new HashMap<>();
    }

    @Override
    public T getById(long id) {
        return store.get(id);
    }

    @Override
    public T save(T object) {
        return store.putIfAbsent(object.getId(), object);
    }

    @Override
    public T delete(long id) {
        return null;
    }
}
