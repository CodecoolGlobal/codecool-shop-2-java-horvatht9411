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
        Supplier penn = new Supplier("PENN", "The best just got better...");
        supplierDataStore.add(penn);
        Supplier shimano = new Supplier("SHIMANO", "For over 80 years, creating the most innovative products");
        supplierDataStore.add(shimano);
        Supplier daiwa = new Supplier("DAIWA", "Combination of design, quality and innovation");
        supplierDataStore.add(daiwa);
        Supplier hotspotdesign = new Supplier("HOTSPOT DESIGN", "Technical and outdoor items suitable for fishing sessions and everyday use");
        supplierDataStore.add(hotspotdesign);
        Supplier mepps = new Supplier("MEPPS", "The world's #1 Lure");
        supplierDataStore.add(mepps);
        Supplier cormoran = new Supplier("CORMORAN", "");
        supplierDataStore.add(cormoran);
        Supplier jrc = new Supplier("JRC", "");
        supplierDataStore.add(jrc);

        //setting up a new product category
        ProductCategory fishingReels = new ProductCategory("Fishing Reels", "Fishing", "");
        ProductCategory fishingRods = new ProductCategory("Fishing Rods", "Fishing", "");
        ProductCategory fishingLines = new ProductCategory("Fishing lines", "Fishing", "");
        ProductCategory fishingClothing = new ProductCategory("Fishing Clothing", "Fishing", "");
        ProductCategory luresAndFloats = new ProductCategory("Lures and Floats", "Fishing", "");
        ProductCategory chairsBedsTentsUmbrellas = new ProductCategory("Chairs, Beds, Tents, Umbrellas", "Fishing", "");
        ProductCategory fishingAccessories = new ProductCategory("Fishing Accessories", "Fishing", "");
        ProductCategory books = new ProductCategory("Books", "Fishing", "");
        ProductCategory voucher = new ProductCategory("Voucher", "Fishing","");


        productCategoryDataStore.add(fishingReels);
        productCategoryDataStore.add(fishingRods);
        productCategoryDataStore.add(fishingLines);
        productCategoryDataStore.add(fishingClothing);
        productCategoryDataStore.add(luresAndFloats);
        productCategoryDataStore.add(chairsBedsTentsUmbrellas);
        productCategoryDataStore.add(fishingRods);
        productCategoryDataStore.add(fishingAccessories);
        productCategoryDataStore.add(books);
        productCategoryDataStore.add(voucher);


        //setting up products and printing it
        productDataStore.add(new Product("Penn International VIS", new BigDecimal("949.9"), "USD", "The PENN International VI series is designed and manufactured in the USA of domestic and imported components.", fishingReels, penn, "https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/i/n/international_vis_int130vis_001.jpg"));
        productDataStore.add(new Product("Shimano 20 Stella", new BigDecimal("1049.9"), "USD", "The reel has been improved on many points: it is even stronger, more though, more durable and more powerful.", fishingReels, shimano,"https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/s/t/stlsw30000c_001.jpg"));
        productDataStore.add(new Product("Shimano Tiagra", new BigDecimal("899.9"), "USD", "The indestructible and proven Tiagra reels give confidence in the fight with the capitals. Leading the world in the Big Game reels.", fishingReels, shimano,"https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/t/i/ti130a-shimano-tiagra-130a-trolling-saltwater-fishing-reel-1.jpg"));
        productDataStore.add(new Product("SHIMANO Tiagra Ultra Game", new BigDecimal("649.9"), "USD", "The Tiagra Ultra Game is a high-end boat rod that makes no compromises.", fishingRods, shimano,"https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/t/i/tiult5080stp_shimano_21_tiagra_ultra_game_50-80lbs_stand_up_trolling_angelrute_001.jpg"));
        productDataStore.add(new Product("DAIWA Infinity X45 Carp", new BigDecimal("349.9"), "USD", "The Infinity carp fishing rods combine current DAIWA fishing rod construction technologies with high quality and innovative components.", fishingRods, daiwa,"https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/1/11990-366_9_1.jpg"));
        productDataStore.add(new Product("DAIWA Tournament x8 Braid EVO+", new BigDecimal("599.9"), "USD", "The well-known Tournament 8 Braid has been further optimized for the EVO + version. In particular, the surface coating with a higher silicone content has been improved.", fishingLines, daiwa,"https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/2/12760-118_1_2.jpg"));
        productDataStore.add(new Product("Shimano Kairiki SX8", new BigDecimal("399.9"), "USD", "KARIKI - The Braid with mysterious Power! Advanced 8 carrier Japanese PE braid, manufactured with S-EBT (Shimano Enhanced Body Technology).", fishingLines, shimano,"https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/s/h/shimano-kairiki-steel-grey_28.jpg"));
        productDataStore.add(new Product("DAIWA J-Braid Grand X8, 3000m, multicolor, Braided Fishing Line", new BigDecimal("349.9"), "USD", "The J Braid Grand X8 is the advanced version of the world famous J Braid X8.", fishingLines, daiwa,"https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/2/12795-120_1_1103x1500_1.jpg"));
        productDataStore.add(new Product("Team Daiwa Flotation Suit", new BigDecimal("49.9"), "USD", "Two-piece high-quality swim suit!", fishingClothing, daiwa,"https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/8/18510-120_1_11.jpg"));
        productDataStore.add(new Product("HOTSPOT DESIGN Anorak Jacket Carpfishing Mania", new BigDecimal("49.9"), "USD", "Exceptionally warm, breathable, robust, waterproof and wind-resistant, features who are mixed with a timeless and stylish design, the result is a premium quality jacket.", fishingClothing, hotspotdesign,"https://www.fishernator.com/media/catalog/product/cache/8/image/1500x1500/9df78eab33525d08d6e5fb8d27136e95/0/1/0108007_1.jpg"));
        productDataStore.add(new Product("DAIWA Tournament XL Shiner 130F", new BigDecimal("19.9"), "USD", "", luresAndFloats, daiwa,"https://www.fishernator.com/media/catalog/product/cache/8/image/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/6/16710-101_1_1.jpg"));
        productDataStore.add(new Product("DAIWA Pop Up Hookbait", new BigDecimal("19.9"), "USD", "", luresAndFloats, daiwa,"https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/3/13300-300_pop_up_red_1.jpg"));
        productDataStore.add(new Product("Spinner - Mepps Aglia TW with fish silver", new BigDecimal("19.9"), "USD", "", luresAndFloats, mepps,"https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/5/2/52-71004_p_web.jpg"));
        productDataStore.add(new Product("JRC Extreme TX2 2-Man Bivvy", new BigDecimal("229.9"), "USD", "", chairsBedsTentsUmbrellas, jrc,"https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/5/1503039.jpg"));
        productDataStore.add(new Product("JRC Extreme TX2 Sleep System Wide", new BigDecimal("329.9"), "USD", "", chairsBedsTentsUmbrellas, jrc,"https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/5/1503021.jpg"));
        productDataStore.add(new Product("JRC Cocoon 2 Relaxa Recliner", new BigDecimal("129.9"), "USD", "", chairsBedsTentsUmbrellas, jrc,"https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/4/1404450.jpg"));
        productDataStore.add(new Product("CORMORAN Cormoran Umbrella XXL", new BigDecimal("89.9"), "USD", "", chairsBedsTentsUmbrellas, cormoran,"https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/6/8/68-35300_anglerschirm.jpg"));
        productDataStore.add(new Product("JRC Radar CX Alarms Set, Bite Indicator Set", new BigDecimal("189.9"), "USD", "", fishingAccessories, jrc,"https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/e/m/emea_1404485_is.jpg"));
        productDataStore.add(new Product("SHIMANO Tribal TX, Carp Fishing Landing Net", new BigDecimal("119.9"), "USD", "", fishingAccessories, shimano,"https://www.fishernator.com/media/catalog/product/cache/8/image/1500x1500/9df78eab33525d08d6e5fb8d27136e95/t/x/tx-plus-42in-landing-net_1250x1250px_v1_3.jpg"));
        productDataStore.add(new Product("Daiwa Infinity Boat Pod, Boat Rod Pod", new BigDecimal("139.9"), "USD", "", fishingAccessories, daiwa,"https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/8/18800-900_3.jpg"));
    }
}
