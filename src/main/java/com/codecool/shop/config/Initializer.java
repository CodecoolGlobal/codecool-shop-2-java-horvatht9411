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
        ProductCategory bedAndChairs = new ProductCategory("Asztalok és székek", "asztalokesszekek", "");
        productCategoryDataStore.add(bedAndChairs);
        ProductCategory gadgets = new ProductCategory("Aprócikkek", "aprocikkek", "");
        productCategoryDataStore.add(gadgets);
        ProductCategory bankAndRodpod = new ProductCategory("Bank Stick & Rod Pod", "bankstick&rodpod", "");
        productCategoryDataStore.add(bankAndRodpod);
        ProductCategory baits = new ProductCategory("Csalik", "csalik", "");
        productCategoryDataStore.add(baits);
        ProductCategory boxes = new ProductCategory("Dobozok", "dobozok", "");
        productCategoryDataStore.add(boxes);
        ProductCategory feedingAccessories = new ProductCategory("Etetés kellékei", "eteteskellekei", "");
        productCategoryDataStore.add(feedingAccessories);
        ProductCategory headLights = new ProductCategory("Fejlámpák", "fejlampak", "");
        productCategoryDataStore.add(headLights);
        ProductCategory fishingRods = new ProductCategory("Horgászbotok", "horgaszbotok", "");
        productCategoryDataStore.add(fishingRods);
        ProductCategory accessories = new ProductCategory("Kiegészítők", "kiegeszitok", "");
        productCategoryDataStore.add(accessories);
        ProductCategory books = new ProductCategory("Könyvek", "konyvek", "");
        productCategoryDataStore.add(books);
        ProductCategory fishnets = new ProductCategory("Merítőszákok", "meritoszakok", "");
        productCategoryDataStore.add(fishnets);
        ProductCategory strikeIndicators = new ProductCategory("Kapásjelzők", "kapasjelzok", "");
        productCategoryDataStore.add(strikeIndicators);
        ProductCategory reels = new ProductCategory("Orsók", "orsok", "");
        productCategoryDataStore.add(reels);
        ProductCategory clothes = new ProductCategory("Ruházat", "ruhazat", "");
        productCategoryDataStore.add(clothes);
        ProductCategory tents = new ProductCategory("Sátrak", "satrak", "");
        productCategoryDataStore.add(tents);
        ProductCategory feelerRod = new ProductCategory("Tapogatórúd", "tapogatorud", "");
        productCategoryDataStore.add(feelerRod);
        ProductCategory bags = new ProductCategory("Táskák", "taskak", "");
        productCategoryDataStore.add(bags);
        ProductCategory shoppingVoucher = new ProductCategory("Vásárlási utalvány", "vasarlasiutalvány","");
        productCategoryDataStore.add(shoppingVoucher);


        //setting up products and printing it
        productDataStore.add(new Product("Amazon Fire", new BigDecimal("49.9"), "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", shoppingVoucher, amazon));
        productDataStore.add(new Product("Lenovo IdeaPad Miix 700", new BigDecimal("479"), "USD", "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.", reels, lenovo));
        productDataStore.add(new Product("Amazon Fire HD 8", new BigDecimal("89"), "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", headLights, amazon));
    }
}
