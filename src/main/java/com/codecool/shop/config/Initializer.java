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

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier novisSyncro = new Supplier("NOVIS SYNCRO", "Horgászbot");
        supplierDataStore.add(novisSyncro);
        Supplier euroStar = new Supplier("EURO STAR", "Horgászbot");
        supplierDataStore.add(euroStar);
        Supplier sonik = new Supplier("SONIK", "Horgász felszerelés");
        supplierDataStore.add(sonik);
        Supplier mivardi = new Supplier("MIVARDI", "Horgász szék");
        supplierDataStore.add(mivardi);
        Supplier carpAcademy = new Supplier("CARP ACADEMY", "Horgász felszerelés");
        supplierDataStore.add(mivardi);
        Supplier webcast = new Supplier("WEBCAST", "Horgász felszerelés");
        supplierDataStore.add(mivardi);
        Supplier delphin = new Supplier("DELPHIN", "Horgász felszerelés");
        supplierDataStore.add(mivardi);
        Supplier balatonBaits = new Supplier("BALATON BAITS", "Csalik");
        supplierDataStore.add(balatonBaits);
        Supplier nash = new Supplier("NASH", "Horgász felszerelés");
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
        ProductCategory fishingRods = new ProductCategory("Horgászbotok", "horgaszbotok", "");
        productCategoryDataStore.add(fishingRods);
        ProductCategory accessories = new ProductCategory("Kiegészítők", "kiegeszitok", "");
        productCategoryDataStore.add(accessories);
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


        //setting up products and printing it
        // fishing rods
        productDataStore.add(new Product("Novis Syncro feeder bot", 8991, "HUF", "Speciális, a magyar vizekre kifejlesztett feeder bot.", fishingRods, novisSyncro, "https://epeca.hu/_user/page/webshop/13/1610-360/1610-360.webp"));
        productDataStore.add(new Product("Euro Star feeder bot", 12915, "HUF", "EUROSTAR MASTER CLASS FEEDER 3+2 30-90gr feeder bot. Az EUROSTAR egyik legsikeresebb és legjobban eltalált szériája a MASTER CLASS feeder bot család.", fishingRods, euroStar, "https://epeca.hu/_user/page/webshop/3/em60391/em60391.webp"));
        productDataStore.add(new Product("Sonik bojlis bot", 155000, "HUF", "A Sonik Gravity pontyozóbotok irigylésre méltó hírnevet szereztek az elmúlt évtized során. A világ vezető anyagmérnökeivel lévő partneri viszony és Frank Warwick közreműködésének eredménye az új csúcsmodell.", fishingRods, sonik, "https://epeca.hu/_user/page/webshop/1/snac0-050/snac0-050.webp"));
        productDataStore.add(new Product("SHIMANO Tiagra Ultra Game", 150000, "HUF", "The Tiagra Ultra Game is a high-end boat rod that makes no compromises.", fishingRods, shimano, "https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/t/i/tiult5080stp_shimano_21_tiagra_ultra_game_50-80lbs_stand_up_trolling_angelrute_001.jpg"));
        productDataStore.add(new Product("DAIWA Infinity X45 Carp", 100000, "HUF", "The Infinity carp fishing rods combine current DAIWA fishing rod construction technologies with high quality and innovative components.", fishingRods, daiwa, "https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/1/11990-366_9_1.jpg"));

        //bed and chairs
        productDataStore.add(new Product("JRC Cocoon 2 Relaxa Recliner", 30000, "HUF", "", bedAndChairs, jrc, "https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/4/1404450.jpg"));
        productDataStore.add(new Product("JRC Extreme TX2 Sleep System Wide", 60000, "HUF", "", bedAndChairs, jrc, "https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/5/1503021.jpg"));
        productDataStore.add(new Product("Mivardi CamoCODE Combi Horgász Fotel", 35000, "HUF", "Szín: digital camoflage Terhelhetőség: 140kg", bedAndChairs, mivardi, "https://epeca.hu/_user/page/webshop/11/mivardi-camocode-combi-fotel/mivardi-camocode-combi-fotel.jpg"));
        productDataStore.add(new Product("Mivardi Premium Long horgász Fotel", 30000, "HUF", "szélesség: 70cm tömeg: 6,1 kg terhelhetőség: 120 kg", bedAndChairs, mivardi, "https://epeca.hu/_user/page/webshop/11/m-chprel/m-chprel.webp"));
        productDataStore.add(new Product("Carp Academy Giant Fotel", 50000, "HUF", "-párnázott ülés és háttámla -magasított ülőfelület -többfokozatú háttámla állítás -minőségi kidolgozás -teleszkópos lábak -süppedésmentes billenőtalpak -magasított háttámla -erősített acél váz -kartámasz -1600 Oxford nylon borítás -ülőfelület 53cm, háttámla 62cm,szélesség 52cm -150kg", bedAndChairs, carpAcademy, "https://epeca.hu/_user/page/webshop/13/7139-001/7139-001.webp"));
        productDataStore.add(new Product("SONIK SK-TEK horgász ágy/bojlis ágy", 50000, "HUF", "Cikkszám: SN715-001\n Anyaga: Acél + alumínium\n Jellemző: 190T külső anyag\n Méret: 212x84x43-58 cm\n Súly: 12,5 kg\n Szállítási méret: 84x87x30 cm\n Típus: 4 Season\n", bedAndChairs, sonik, "https://epeca.hu/_user/page/webshop/1/sn715-001/sn715-001.webp"));

        //gadgets
        productDataStore.add(new Product("DAIWA J-Braid Grand X8, 3000m, multicolor, Braided Fishing Line", 25450, "HUF", "The J Braid Grand X8 is the advanced version of the world famous J Braid X8.", gadgets, daiwa, "https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/2/12795-120_1_1103x1500_1.jpg"));
        productDataStore.add(new Product("DAIWA Tournament x8 Braid EVO+", 5000, "HUF", "The well-known Tournament 8 Braid has been further optimized for the EVO + version. In particular, the surface coating with a higher silicone content has been improved.", gadgets, daiwa, "https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/2/12760-118_1_2.jpg"));
        productDataStore.add(new Product("Forgókapocs 12-es 10/cs", 270, "HUF", "Fenekező és úszós horgászatra is egyaránt alkalmas forgókapocs.Előkék,etetőkosarak,úszók gyors cseréjét teszi lehetővé.", gadgets, sonik, "https://epeca.hu/_user/page/webshop/13/5511-012/5511-012.webp"));
        productDataStore.add(new Product("Bojlis paszta ólom 120GR 2DB/CSOM", 1000, "HUF", "A bordázott csúszó ólom a klasszikus fenekezéshez, a nehéz-feeder és bojlis módszerhez is alkalmazható.", gadgets, carpAcademy, "https://epeca.hu/_user/page/webshop/1/58216-420/58216-420.webp"));
        productDataStore.add(new Product("Webcast PVA", 3000, "HUF", "Három átmérőben választható, hogy a mini Stick Mix-es PVA csomagok vagy a hatalmas pelletzsákok is elkészíthetőek legyenek. A Webcast PVA háló egy tölthető rövid adagolócsőre van felhúzva, és egy pontos illeszkedésű tömörítő rúd is található a vízálló csomagolásában.", gadgets, webcast, "https://nashhungary.hu/wp-content/uploads/2022/02/6089-t8632-1-3-800.jpg"));
        productDataStore.add(new Product("Shimano Kairiki SX8", 12990, "HUF", "KARIKI - The Braid with mysterious Power! Advanced 8 carrier Japanese PE braid, manufactured with S-EBT (Shimano Enhanced Body Technology).", gadgets, shimano, "https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/s/h/shimano-kairiki-steel-grey_28.jpg"));

        //banks and rodpods
        productDataStore.add(new Product("Rodpod Delphin SKAUT", 20130, "HUF", "A full alumínium Delphin SKAUT rodpod kategóriájában a legjobb. A kompakt méreteknek köszönhetően, valamint az átgondolt összerakásánál fogva kényelmesen belefér a textil szállító tárolóba mely csak 30x15x5cm! ", bankAndRodpod, delphin, "https://epeca.hu/_user/page/webshop/2/870000328/870000328.webp"));
        productDataStore.add(new Product("Rodpod Delphin RPX 4 Silver | 3 botra", 44770, "HUF", "Az aki nem éppen fekete szín kedvelője, bizonyára az RPX4 Silvert fogja választani. A tökéletes dizájn a homokozási technológia, valamint az alumínium szerkezet oxidációjának köszönhető szürke árnyalatban. Átdolgozott csatlakozással csatlakoznak a lábak a rodpod fő szerkezetéhez. ", bankAndRodpod, delphin, "https://epeca.hu/_user/page/webshop/2/870000333/870000333.webp"));
        productDataStore.add(new Product("Nash Bank Life Table", 24770, "HUF", "Nagyon erős, összehajtható asztal, ami állítható hosszúságú lábakkal és rögzítőrendszerrel rendelkezik, ezeknek köszönhetően pedig az egyenetlen talajon is stabilan áll. Könnyen tisztítható felülettel látták el, amin egy Nash logó is található.", bankAndRodpod, nash, "https://nashhungary.hu/wp-content/uploads/2022/01/6378-t1203-1-3-800.jpg"));

        //baits
        productDataStore.add(new Product("Balaton Baits Deluxe főzött bojli 20mm 250g - fokhagyma", 1500, "HUF", "A Prime egy erősen fűszeres nagy protein tartalmú bojli. Jellegzetes illata semmivel sem téveszthető össze.", baits, balatonBaits, "https://epeca.hu/_user/page/webshop/6/bb-01-001-017/bb-01-001-017.jpg"));
        productDataStore.add(new Product("Nash - Pineapple Crush Pop Ups", 1590, "HUF", "12 mm, 15 mm, 20 mm", baits, nash, "https://nashhungary.hu/wp-content/uploads/2022/01/Pine-Pop.jpg"));
        productDataStore.add(new Product("Nash - Squid and Krill Boilies", 3590, "HUF", "Nagy szivárgású mix, költséghatékony előfőzött gabonafélékkel, olcsóbb mint a drága tejprotein, de az attraktorok könnyen távoznak és jól emészthető.", baits, nash, "https://nashhungary.hu/wp-content/uploads/2022/01/6749-b3419-1-3-800.jpg"));
        productDataStore.add(new Product("SBS BOILIES+50ML BAIT DIP - SQUID O. & STRA\n", 3550, "HUF", "Az SBS legkedvezőbb árfekvésű kész bojlija mellé egy ajándék dipet adunk, mely párosításhoz továbbra is nagyon kedvező áron lehet hozzájutni!", baits, euroStar, "https://epeca.hu/_user/page/webshop/1/sbs60-002/sbs60-002.webp"));
        productDataStore.add(new Product("DAIWA Tournament XL Shiner 130F", 1500, "HUF", "", baits, daiwa, "https://www.fishernator.com/media/catalog/product/cache/8/image/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/6/16710-101_1_1.jpg"));
        productDataStore.add(new Product("DAIWA Pop Up Hookbait", 1470, "HUF", "", baits, daiwa, "https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/3/13300-300_pop_up_red_1.jpg"));
        productDataStore.add(new Product("Spinner - Mepps Aglia TW with fish silver", 1700, "USD", "", baits, mepps, "https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/5/2/52-71004_p_web.jpg"));

        //boxes
        productDataStore.add(new Product("Box Logic Chod Box", 6090, "HUF", "Egy doboz kimondottan a chod rigekhez, stiff hinge horogrészekhez és minden más hosszú, hajlított zsugoros előkéhez. Egy belső szivacshengerrel, az előkék feszes és stabil tárolásához, hogy megtartsák formájukat. Akár 15 előkéhez. Gombostűkkel szállítva.", boxes, euroStar, "https://nashhungary.hu/wp-content/uploads/2022/01/9507-t0279_2-1-3-800.jpg"));

        //clothes
        productDataStore.add(new Product("Team Daiwa Flotation Suit", 9000, "HUF", "Two-piece high-quality swim suit!", clothes, daiwa, "https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/8/18510-120_1_11.jpg"));
        productDataStore.add(new Product("HOTSPOT DESIGN Anorak Jacket Carpfishing Mania", 11000, "HUF", "Exceptionally warm, breathable, robust, waterproof and wind-resistant, features who are mixed with a timeless and stylish design, the result is a premium quality jacket.", clothes, hotspotdesign, "https://www.fishernator.com/media/catalog/product/cache/8/image/1500x1500/9df78eab33525d08d6e5fb8d27136e95/0/1/0108007_1.jpg"));

        //tents
        productDataStore.add(new Product("JRC Extreme TX2 2-Man Bivvy", 90000, "HUF", "", tents, jrc, "https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/5/1503039.jpg"));

        //accessories
        productDataStore.add(new Product("CORMORAN Cormoran Umbrella XXL", 22900, "HUF", "", accessories, cormoran, "https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/6/8/68-35300_anglerschirm.jpg"));
        productDataStore.add(new Product("JRC Radar CX Alarms Set, Bite Indicator Set", 42900, "HUF", "", accessories, jrc, "https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/e/m/emea_1404485_is.jpg"));
        productDataStore.add(new Product("SHIMANO Tribal TX, Carp Fishing Landing Net", 21900, "HUF", "", accessories, shimano, "https://www.fishernator.com/media/catalog/product/cache/8/image/1500x1500/9df78eab33525d08d6e5fb8d27136e95/t/x/tx-plus-42in-landing-net_1250x1250px_v1_3.jpg"));
        productDataStore.add(new Product("Daiwa Infinity Boat Pod, Boat Rod Pod", 11200, "HUF", "", accessories, daiwa, "https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/8/18800-900_3.jpg"));

        //reels
        productDataStore.add(new Product("Penn International VIS", 300000, "HUF", "The PENN International VI series is designed and manufactured in the USA of domestic and imported components.", reels, penn, "https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/i/n/international_vis_int130vis_001.jpg"));
        productDataStore.add(new Product("Shimano 20 Stella", 299000, "HUF", "The reel has been improved on many points: it is even stronger, more though, more durable and more powerful.", reels, shimano, "https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/s/t/stlsw30000c_001.jpg"));
        productDataStore.add(new Product("Shimano Tiagra", 200000, "HUF", "The indestructible and proven Tiagra reels give confidence in the fight with the capitals. Leading the world in the Big Game reels.", reels, shimano, "https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/t/i/ti130a-shimano-tiagra-130a-trolling-saltwater-fishing-reel-1.jpg"));

        // feelerRod
        productDataStore.add(new Product("Nash Prodding Stick Kit\n", 25000, "HUF", "Egy frisített dizájn az idő próbálta Nash Prodding Stick Kit-nek. Üvegszálas tagok, rugós rögzítéssel biztosítják a meder legpontosabb feltérképezését, a táplálkozási helyek, mélyedések és természetes tápanyagforrások gyors megtalálását.", feelerRod, nash, "https://nashhungary.hu/wp-content/uploads/2022/01/NASH-PRODDING-STICK-KIT1.jpg"));

        //bags
        productDataStore.add(new Product("Nash Carryall", 32500, "HUF", "Strapabíró, az időtállóan bízonyított dizájn, ami teljes rugalmasságot biztosít három méretben, hogy minden túrának és minden tárolási követelménynek megfeleljen. A Small, Medium és Large Carryallok a valaha volt legnépszerűbb pontyhorgász táskák.", bags, nash, "https://nashhungary.hu/wp-content/uploads/2022/02/8387-t3548-1-3-800.jpg"));
    }
}
