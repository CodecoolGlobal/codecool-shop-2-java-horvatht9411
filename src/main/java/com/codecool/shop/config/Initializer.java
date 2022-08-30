package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier amazon = new Supplier("Amazon", "Digital content and services");
        supplierDataStore.add(amazon);
        Supplier lenovo = new Supplier("Lenovo", "Computers");
        supplierDataStore.add(lenovo);

        //setting up a new product category
        ProductCategory bedAndChairs = new ProductCategory("Asztalok és székek", "Fishing", "");
        ProductCategory gadgets = new ProductCategory("Aprócikkek", "Fishing", "");
        ProductCategory bankAndRodpod = new ProductCategory("Bank Stick & Rod Pod", "Fishing", "");
        ProductCategory baits = new ProductCategory("Csalik", "Fishing", "");
        ProductCategory boxes = new ProductCategory("Dobozok", "Fishing", "");
        ProductCategory feedingAccessories = new ProductCategory("Etetés kellékei", "Fishing", "");
        ProductCategory headLights = new ProductCategory("Fejlámpák", "Fishing", "");
        ProductCategory fishingRods = new ProductCategory("Horgászbotok", "Fishing", "");
        ProductCategory strikeIndicators = new ProductCategory("Kapásjelzők", "Fishing", "");
        ProductCategory accessories = new ProductCategory("Kiegészítők", "Fishing", "");
        ProductCategory books = new ProductCategory("Könyvek", "Fishing", "");
        ProductCategory fishnets = new ProductCategory("Merítőszákok", "Fishing", "");
        ProductCategory reels = new ProductCategory("Orsók", "Fishing", "");
        ProductCategory clothes = new ProductCategory("Ruházat", "Fishing", "");
        ProductCategory tents = new ProductCategory("Sátrak", "Fishing", "");
        ProductCategory feelerRod = new ProductCategory("Tapogatórúd", "Fishing", "");
        ProductCategory bags = new ProductCategory("Táskák", "Fishing", "");
        ProductCategory shoppingVoucher = new ProductCategory("Vásárlási utalvány", "Fishing","");
        productCategoryDataStore.add(bedAndChairs);
        productCategoryDataStore.add(gadgets);
        productCategoryDataStore.add(bankAndRodpod);
        productCategoryDataStore.add(baits);
        productCategoryDataStore.add(boxes);
        productCategoryDataStore.add(feedingAccessories);
        productCategoryDataStore.add(fishingRods);
        productCategoryDataStore.add(strikeIndicators);
        productCategoryDataStore.add(accessories);
        productCategoryDataStore.add(books);
        productCategoryDataStore.add(fishnets);
        productCategoryDataStore.add(reels);
        productCategoryDataStore.add(clothes);
        productCategoryDataStore.add(tents);
        productCategoryDataStore.add(feelerRod);
        productCategoryDataStore.add(bags);
        productCategoryDataStore.add(shoppingVoucher);


        //setting up products and printing it
        productDataStore.add(new Product("Amazon Fire", new BigDecimal("49.9"), "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", shoppingVoucher, amazon));
        productDataStore.add(new Product("Lenovo IdeaPad Miix 700", new BigDecimal("479"), "USD", "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.", reels, lenovo));
        productDataStore.add(new Product("Amazon Fire HD 8", new BigDecimal("89"), "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", headLights, amazon));
    }
}
