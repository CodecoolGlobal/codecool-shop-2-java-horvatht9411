package com.codecool.shop.dao;

import com.codecool.shop.model.Supplier;

import java.util.Set;

public interface SupplierDao {

    void add(Supplier supplier);

    Supplier find(int id);

    Set<Supplier> getAll();
}
