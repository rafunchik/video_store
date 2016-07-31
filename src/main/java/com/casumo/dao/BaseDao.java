package com.casumo.dao;


public interface BaseDAO <T>{
    T getById(long id);
    T save(T object);
    T delete(long id);
}
