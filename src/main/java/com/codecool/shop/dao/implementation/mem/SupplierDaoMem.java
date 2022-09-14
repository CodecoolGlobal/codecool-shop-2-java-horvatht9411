package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Supplier;

import java.util.HashSet;
import java.util.Set;

public class SupplierDaoMem implements SupplierDao {

    private Set<Supplier> data = new HashSet<>();
    private static SupplierDaoMem instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    private SupplierDaoMem() {
    }

    public static SupplierDaoMem getInstance() {
        if (instance == null) {
            instance = new SupplierDaoMem();
        }
        return instance;
    }

    @Override
    public Supplier getById(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Set<Supplier> getAll() {
        return data;
    }

    @Override
    public void add(Supplier supplier) {
        data.add(supplier);
        supplier.setId(data.size());
    }

}
