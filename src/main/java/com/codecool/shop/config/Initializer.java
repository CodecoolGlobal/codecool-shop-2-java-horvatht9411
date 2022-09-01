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
        Supplier novisSyncro = new Supplier("Nevis Syncro", "Horgászbot");
        supplierDataStore.add(novisSyncro);
        Supplier euroStar = new Supplier("Euro Star", "Horgászbot");
        supplierDataStore.add(euroStar);
        Supplier sonik = new Supplier("Sonik", "Horgász felszerelés");
        supplierDataStore.add(sonik);
        Supplier mivardi = new Supplier("Mivardi", "Horgász szék");
        supplierDataStore.add(mivardi);
        Supplier carpAcademy = new Supplier("Carp Academy", "Horgász felszerelés");
        supplierDataStore.add(mivardi);
        Supplier webcast = new Supplier("Webcast", "Horgász felszerelés");
        supplierDataStore.add(mivardi);
        Supplier delphin = new Supplier("Delphin", "Horgász felszerelés");
        supplierDataStore.add(mivardi);
        Supplier balatonBaits = new Supplier("Balaton Baits", "Csalik");
        supplierDataStore.add(balatonBaits);
        Supplier nash = new Supplier("Nash", "Horgász felszerelés");
        supplierDataStore.add(nash);
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
        ProductCategory bedAndChairs = new ProductCategory("Ágyak és székek", "Fishing", "");
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
        ProductCategory shoppingVoucher = new ProductCategory("Vásárlási utalvány", "Fishing", "");
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
        // fishing rods
        productDataStore.add(new Product("Novis Syncro feeder bot", 8991, "HUF", "Speciális, a magyar vizekre kifejlesztett feeder bot.", fishingRods, novisSyncro, "https://epeca.hu/_user/page/webshop/13/1610-360/1610-360.webp"));
        productDataStore.add(new Product("Euro Star feeder bot", 12915, "HUF", "EUROSTAR MASTER CLASS FEEDER 3+2 30-90gr feeder bot. Az EUROSTAR egyik legsikeresebb és legjobban eltalált szériája a MASTER CLASS feeder bot család.", fishingRods, euroStar, "https://epeca.hu/_user/page/webshop/3/em60391/em60391.webp"));
        productDataStore.add(new Product("Sonik bojlis bot", 155000, "HUF", "A Sonik Gravity pontyozóbotok irigylésre méltó hírnevet szereztek az elmúlt évtized során. A világ vezető anyagmérnökeivel lévő partneri viszony és Frank Warwick közreműködésének eredménye az új csúcsmodell.", fishingRods, sonik, "https://epeca.hu/_user/page/webshop/1/snac0-050/snac0-050.webp"));

        //bed and chairs
        productDataStore.add(new Product("Mivardi CamoCODE Combi Horgász Fotel", 35000, "HUF", "Szín: digital camoflage Terhelhetőség: 140kg", bedAndChairs, mivardi, "https://epeca.hu/_user/page/webshop/11/mivardi-camocode-combi-fotel/mivardi-camocode-combi-fotel.jpg"));
        productDataStore.add(new Product("Mivardi Premium Long horgász Fotel", 30000, "HUF", "szélesség: 70cm tömeg: 6,1 kg terhelhetőség: 120 kg", bedAndChairs, mivardi, "https://epeca.hu/_user/page/webshop/11/m-chprel/m-chprel.webp"));
        productDataStore.add(new Product("Carp Academy Giant Fotel", 50000, "HUF", "-párnázott ülés és háttámla -magasított ülőfelület -többfokozatú háttámla állítás -minőségi kidolgozás -teleszkópos lábak -süppedésmentes billenőtalpak -magasított háttámla -erősített acél váz -kartámasz -1600 Oxford nylon borítás -ülőfelület 53cm, háttámla 62cm,szélesség 52cm -150kg", bedAndChairs, carpAcademy, "https://epeca.hu/_user/page/webshop/13/7139-001/7139-001.webp"));
        productDataStore.add(new Product("SONIK SK-TEK horgász ágy/bojlis ágy", 50000, "HUF", "Cikkszám: SN715-001\n Anyaga: Acél + alumínium\n Jellemző: 190T külső anyag\n Méret: 212x84x43-58 cm\n Súly: 12,5 kg\n Szállítási méret: 84x87x30 cm\n Típus: 4 Season\n", bedAndChairs, sonik, "https://epeca.hu/_user/page/webshop/1/sn715-001/sn715-001.webp"));

        //gadgets
        productDataStore.add(new Product("Forgókapocs 12-es 10/cs", 270, "HUF", "Fenekező és úszós horgászatra is egyaránt alkalmas forgókapocs.Előkék,etetőkosarak,úszók gyors cseréjét teszi lehetővé.", gadgets, sonik, "https://epeca.hu/_user/page/webshop/13/5511-012/5511-012.webp"));
        productDataStore.add(new Product("Bojlis paszta ólom 120GR 2DB/CSOM", 1000, "HUF", "A bordázott csúszó ólom a klasszikus fenekezéshez, a nehéz-feeder és bojlis módszerhez is alkalmazható.", gadgets, carpAcademy, "https://epeca.hu/_user/page/webshop/1/58216-420/58216-420.webp"));
        productDataStore.add(new Product("Webcast PVA\n", 3000, "HUF", "Három átmérőben választható, hogy a mini Stick Mix-es PVA csomagok vagy a hatalmas pelletzsákok is elkészíthetőek legyenek. A Webcast PVA háló egy tölthető rövid adagolócsőre van felhúzva, és egy pontos illeszkedésű tömörítő rúd is található a vízálló csomagolásában.", gadgets, webcast, "https://nashhungary.hu/wp-content/uploads/2022/02/6089-t8632-1-3-800.jpg"));

        //banks and rodpods
        productDataStore.add(new Product("Rodpod Delphin SKAUT", 20130, "HUF", "A full alumínium Delphin SKAUT rodpod kategóriájában a legjobb. A kompakt méreteknek köszönhetően, valamint az átgondolt összerakásánál fogva kényelmesen belefér a textil szállító tárolóba mely csak 30x15x5cm! ", bankAndRodpod, delphin, "https://epeca.hu/_user/page/webshop/2/870000328/870000328.webp"));
        productDataStore.add(new Product("Rodpod Delphin RPX 4 Silver | 3 botra", 44770, "HUF", "Az aki nem éppen fekete szín kedvelője, bizonyára az RPX4 Silvert fogja választani. A tökéletes dizájn a homokozási technológia, valamint az alumínium szerkezet oxidációjának köszönhető szürke árnyalatban. Átdolgozott csatlakozással csatlakoznak a lábak a rodpod fő szerkezetéhez. ", bankAndRodpod, delphin, "https://epeca.hu/_user/page/webshop/2/870000333/870000333.webp"));
        productDataStore.add(new Product("Nash Bank Life Table", 24770, "HUF", "Nagyon erős, összehajtható asztal, ami állítható hosszúságú lábakkal és rögzítőrendszerrel rendelkezik, ezeknek köszönhetően pedig az egyenetlen talajon is stabilan áll. Könnyen tisztítható felülettel látták el, amin egy Nash logó is található.", bankAndRodpod, nash, "https://nashhungary.hu/wp-content/uploads/2022/01/6378-t1203-1-3-800.jpg"));

        //baits
        productDataStore.add(new Product("Balaton Baits Deluxe főzött bojli 20mm 250g - fokhagyma", 1500, "HUF", "A Prime egy erősen fűszeres nagy protein tartalmú bojli. Jellegzetes illata semmivel sem téveszthető össze.", baits, balatonBaits, "https://epeca.hu/_user/page/webshop/6/bb-01-001-017/bb-01-001-017.jpg"));
        productDataStore.add(new Product("Nash - Pineapple Crush Pop Ups", 1590, "HUF", "12 mm, 15 mm, 20 mm", baits, nash, "https://nashhungary.hu/wp-content/uploads/2022/01/Pine-Pop.jpg"));
        productDataStore.add(new Product("Nash - Squid and Krill Boilies", 3590, "HUF", "Nagy szivárgású mix, költséghatékony előfőzött gabonafélékkel, olcsóbb mint a drága tejprotein, de az attraktorok könnyen távoznak és jól emészthető.", baits, nash, "https://nashhungary.hu/wp-content/uploads/2022/01/6749-b3419-1-3-800.jpg"));
        productDataStore.add(new Product("SBS BOILIES+50ML BAIT DIP - SQUID O. & STRA\n", 3550, "HUF", "Az SBS legkedvezőbb árfekvésű kész bojlija mellé egy ajándék dipet adunk, mely párosításhoz továbbra is nagyon kedvező áron lehet hozzájutni! A kiválasztott bojlival megegyező ízesítésű ajándék 3 in 1 Turbo Bait Dip (50 ml) használatával jelentősen megnövelhetjük esélyünket a halfogásra, különösen abban az esetben, ha a horgászatra viszonylag rövid idő áll rendelkezésünkre.", baits, euroStar, "https://epeca.hu/_user/page/webshop/1/sbs60-002/sbs60-002.webp"));

        //boxes
        productDataStore.add(new Product("Box Logic Chod Box", 6090, "HUF", "Egy doboz kimondottan a chod rigekhez, stiff hinge horogrészekhez és minden más hosszú, hajlított zsugoros előkéhez. Egy belső szivacshengerrel, az előkék feszes és stabil tárolásához, hogy megtartsák formájukat. Akár 15 előkéhez. Gombostűkkel szállítva.", boxes, euroStar, "https://nashhungary.hu/wp-content/uploads/2022/01/9507-t0279_2-1-3-800.jpg"));

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