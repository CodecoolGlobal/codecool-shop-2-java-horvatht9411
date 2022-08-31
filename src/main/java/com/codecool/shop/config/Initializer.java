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

    }
}