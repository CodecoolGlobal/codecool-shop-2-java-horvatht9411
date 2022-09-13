package com.codecool.shop.dao;

import com.codecool.shop.model.Supplier;

import java.util.Set;

public interface SupplierDao {

    Set<Supplier> getAll();

    Supplier getById(int id);

    void add(Supplier supplier);
}
