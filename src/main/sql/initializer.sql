INSERT INTO productcategory (name, department, description)
VALUES ('Asztalok és székek', 'asztalokesszekek', ''),
       ('Aprócikkek', 'aprocikkek', ''),
       ('Bank Stick & Rod Pod', 'bankstick&rodpod', ''),
       ('Csalik', 'csalik', ''),
       ('Dobozok', 'dobozok', ''),
       ('Horgászbotok', 'horgaszbotok', ''),
       ('Kiegészítők', 'kiegeszitok', ''),
       ('Orsók', 'orsok', ''),
       ('Ruházat', 'ruhazat', ''),
       ('Sátrak', 'satrak', ''),
       ('Tapogatórúd', 'tapogatorud', ''),
       ('Táskák', 'taskak', '')
;

INSERT INTO suppliers (name, description)
VALUES ('NOVIS SYNCRO', 'Horgászbot'),
       ('EURO STAR', 'Horgászbot'),
       ('SONIK', 'Horgász felszerelés'),
       ('MIVARDI', 'Horgász szék'),
       ('CARP ACADEMY', 'Horgász felszerelés'),
       ('WEBCAST', 'Horgász felszerelés'),
       ('DELPHIN', 'Horgász felszerelés'),
       ('BALATON BAITS', 'Csalik'),
       ('NASH', 'Horgász felszerelés'),
       ('PENN', 'The best just got better...'),
       ('SHIMANO', 'For over 80 years, creating the most innovative products'),
       ('DAIWA', 'Combination of design, quality and innovation'),
       ('HOTSPOT DESIGN', 'Technical and outdoor items suitable for fishing sessions and everyday use'),
       ('MEPPS', 'The worlds #1 Lure'),
       ('CORMORAN', ''),
       ('JRC', '')
;

INSERT INTO product (name, defaultprice, currency, description, img_url, supplier_id, category_id)
VALUES ('Euro Star feeder bot', 12915, 'HUF', 'EUROSTAR MASTER CLASS FEEDER 3+2 30-90gr feeder bot. Az EUROSTAR egyik legsikeresebb és legjobban eltalált szériája a MASTER CLASS feeder bot család.', 'https://epeca.hu/_user/page/webshop/3/em60391/em60391.webp',(SELECT id FROM suppliers WHERE name = 'EURO STAR'), (SELECT id FROM productcategory WHERE name = 'Horgászbotok')),
    ('Novis Syncro feeder bot', 8991, 'HUF', 'Speciális, a magyar vizekre kifejlesztett feeder bot.', 'https://epeca.hu/_user/page/webshop/13/1610-360/1610-360.webp', (SELECT id FROM suppliers WHERE name = 'NOVIS SYNCRO'), (SELECT id FROM productcategory WHERE name = 'Horgászbotok')),
    ('Sonik bojlis bot', 155000, 'HUF', 'A Sonik Gravity pontyozóbotok irigylésre méltó hírnevet szereztek az elmúlt évtized során. A világ vezető anyagmérnökeivel lévő partneri viszony és Frank Warwick közreműködésének eredménye az új csúcsmodell.', 'https://epeca.hu/_user/page/webshop/1/snac0-050/snac0-050.webp',  (SELECT id FROM suppliers WHERE name = 'SONIK'), (SELECT id FROM productcategory WHERE name = 'Horgászbotok')),
    ('SHIMANO Tiagra Ultra Game', 150000, 'HUF', 'The Tiagra Ultra Game is a high-end boat rod that makes no compromises.', 'https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/t/i/tiult5080stp_shimano_21_tiagra_ultra_game_50-80lbs_stand_up_trolling_angelrute_001.jpg', (SELECT id FROM suppliers WHERE name = 'SHIMANO'), (SELECT id FROM productcategory WHERE name = 'Horgászbotok')),
    ('DAIWA Infinity X45 Carp', 100000, 'HUF', 'The Infinity carp fishing rods combine current DAIWA fishing rod construction technologies with high quality and innovative components.', 'https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/1/11990-366_9_1.jpg', (SELECT id FROM suppliers WHERE name = 'DAIWA'), (SELECT id FROM productcategory WHERE name = 'Horgászbotok')),

    ('JRC Cocoon 2 Relaxa Recliner', 30000, 'HUF', '', 'https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/4/1404450.jpg', (SELECT id FROM suppliers WHERE name = 'JRC'), (SELECT id FROM productcategory WHERE name = 'Asztalok és székek')),
    ('JRC Extreme TX2 Sleep System Wide', 60000, 'HUF', '', 'https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/5/1503021.jpg', (SELECT id FROM suppliers WHERE name = 'JRC'), (SELECT id FROM productcategory WHERE name = 'Asztalok és székek')),
    ('Mivardi CamoCODE Combi Horgász Fotel', 35000, 'HUF', 'Szín: digital camoflage Terhelhetőség: 140kg', 'https://epeca.hu/_user/page/webshop/11/mivardi-camocode-combi-fotel/mivardi-camocode-combi-fotel.jpg', (SELECT id FROM suppliers WHERE name = 'MIVARDI'), (SELECT id FROM productcategory WHERE name = 'Asztalok és székek')),
    ('Mivardi Premium Long horgász Fotel', 30000, 'HUF', 'szélesség: 70cm tömeg: 6,1 kg terhelhetőség: 120 kg', 'https://epeca.hu/_user/page/webshop/11/m-chprel/m-chprel.webp', (SELECT id FROM suppliers WHERE name = 'MIVARDI'), (SELECT id FROM productcategory WHERE name = 'Asztalok és székek')),
    ('Carp Academy Giant Fotel', 50000, 'HUF', '-párnázott ülés és háttámla -magasított ülőfelület -többfokozatú háttámla állítás -minőségi kidolgozás -teleszkópos lábak -süppedésmentes billenőtalpak -magasított háttámla -erősített acél váz -kartámasz -1600 Oxford nylon borítás -ülőfelület 53cm, háttámla 62cm,szélesség 52cm -150kg', 'https://epeca.hu/_user/page/webshop/13/7139-001/7139-001.webp', (SELECT id FROM suppliers WHERE name = 'CARP ACADEMY'), (SELECT id FROM productcategory WHERE name = 'Asztalok és székek')),
    ('SONIK SK-TEK horgász ágy/bojlis ágy', 50000, 'HUF', 'Cikkszám: SN715-001\n Anyaga: Acél + alumínium\n Jellemző: 190T külső anyag\n Méret: 212x84x43-58 cm\n Súly: 12,5 kg\n Szállítási méret: 84x87x30 cm\n Típus: 4 Season\n', 'https://epeca.hu/_user/page/webshop/1/sn715-001/sn715-001.webp', (SELECT id FROM suppliers WHERE name = 'SONIK'), (SELECT id FROM productcategory WHERE name = 'Asztalok és székek')),

    ('DAIWA J-Braid Grand X8, 3000m, multicolor, Braided Fishing Line', 25450, 'HUF', 'The J Braid Grand X8 is the advanced version of the world famous J Braid X8.', 'https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/2/12795-120_1_1103x1500_1.jpg', (SELECT id FROM suppliers WHERE name = 'DAIWA'), (SELECT id FROM productcategory WHERE name = 'Aprócikkek')),
    ('DAIWA Tournament x8 Braid EVO+', 5000, 'HUF', 'The well-known Tournament 8 Braid has been further optimized for the EVO + version. In particular, the surface coating with a higher silicone content has been improved.', 'https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/2/12760-118_1_2.jpg', (SELECT id FROM suppliers WHERE name = 'DAIWA'), (SELECT id FROM productcategory WHERE name = 'Aprócikkek')),
    ('Forgókapocs 12-es 10/cs', 270, 'HUF', 'Fenekező és úszós horgászatra is egyaránt alkalmas forgókapocs.Előkék,etetőkosarak,úszók gyors cseréjét teszi lehetővé.', 'https://epeca.hu/_user/page/webshop/13/5511-012/5511-012.webp', (SELECT id FROM suppliers WHERE name = 'SONIK'), (SELECT id FROM productcategory WHERE name = 'Aprócikkek')),
    ('Bojlis paszta ólom 120GR 2DB/CSOM', 1000, 'HUF', 'A bordázott csúszó ólom a klasszikus fenekezéshez, a nehéz-feeder és bojlis módszerhez is alkalmazható.', 'https://epeca.hu/_user/page/webshop/1/58216-420/58216-420.webp', (SELECT id FROM suppliers WHERE name = 'CARP ACADEMY'), (SELECT id FROM productcategory WHERE name = 'Aprócikkek')),
    ('Webcast PVA', 3000, 'HUF', 'Három átmérőben választható, hogy a mini Stick Mix-es PVA csomagok vagy a hatalmas pelletzsákok is elkészíthetőek legyenek. A Webcast PVA háló egy tölthető rövid adagolócsőre van felhúzva, és egy pontos illeszkedésű tömörítő rúd is található a vízálló csomagolásában.', 'https://nashhungary.hu/wp-content/uploads/2022/02/6089-t8632-1-3-800.jpg', (SELECT id FROM suppliers WHERE name = 'WEBCAST'), (SELECT id FROM productcategory WHERE name = 'Aprócikkek')),
    ('Shimano Kairiki SX8', 12990, 'HUF', 'KARIKI - The Braid with mysterious Power! Advanced 8 carrier Japanese PE braid, manufactured with S-EBT (Shimano Enhanced Body Technology).', 'https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/s/h/shimano-kairiki-steel-grey_28.jpg', (SELECT id FROM suppliers WHERE name = 'SHIMANO'), (SELECT id FROM productcategory WHERE name = 'Aprócikkek')),

    ('Rodpod Delphin SKAUT', 20130, 'HUF', 'A full alumínium Delphin SKAUT rodpod kategóriájában a legjobb. A kompakt méreteknek köszönhetően, valamint az átgondolt összerakásánál fogva kényelmesen belefér a textil szállító tárolóba mely csak 30x15x5cm! ', 'https://epeca.hu/_user/page/webshop/2/870000328/870000328.webp', (SELECT id FROM suppliers WHERE name = 'DELPHIN'), (SELECT id FROM productcategory WHERE name = 'Bank Stick & Rod Pod')),
    ('Rodpod Delphin RPX 4 Silver | 3 botra', 44770, 'HUF', 'Az aki nem éppen fekete szín kedvelője, bizonyára az RPX4 Silvert fogja választani. A tökéletes dizájn a homokozási technológia, valamint az alumínium szerkezet oxidációjának köszönhető szürke árnyalatban. Átdolgozott csatlakozással csatlakoznak a lábak a rodpod fő szerkezetéhez. ', 'https://epeca.hu/_user/page/webshop/2/870000333/870000333.webp', (SELECT id FROM suppliers WHERE name = 'DELPHIN'), (SELECT id FROM productcategory WHERE name = 'Bank Stick & Rod Pod')),
    ('Nash Bank Life Table', 24770, 'HUF', 'Nagyon erős, összehajtható asztal, ami állítható hosszúságú lábakkal és rögzítőrendszerrel rendelkezik, ezeknek köszönhetően pedig az egyenetlen talajon is stabilan áll. Könnyen tisztítható felülettel látták el, amin egy Nash logó is található.', 'https://nashhungary.hu/wp-content/uploads/2022/01/6378-t1203-1-3-800.jpg', (SELECT id FROM suppliers WHERE name = 'NASH'), (SELECT id FROM productcategory WHERE name = 'Bank Stick & Rod Pod')),

    ('Balaton Baits Deluxe főzött bojli 20mm 250g - fokhagyma', 1500, 'HUF', 'A Prime egy erősen fűszeres nagy protein tartalmú bojli. Jellegzetes illata semmivel sem téveszthető össze.', 'https://epeca.hu/_user/page/webshop/6/bb-01-001-017/bb-01-001-017.jpg', (SELECT id FROM suppliers WHERE name = 'BALATON BAITS'), (SELECT id FROM productcategory WHERE name = 'Csalik')),
    ('Nash - Pineapple Crush Pop Ups', 1590, 'HUF', '12 mm, 15 mm, 20 mm',  'https://nashhungary.hu/wp-content/uploads/2022/01/Pine-Pop.jpg', (SELECT id FROM suppliers WHERE name = 'NASH'), (SELECT id FROM productcategory WHERE name = 'Csalik')),
    ('Nash - Squid and Krill Boilies', 3590, 'HUF', 'Nagy szivárgású mix, költséghatékony előfőzött gabonafélékkel, olcsóbb mint a drága tejprotein, de az attraktorok könnyen távoznak és jól emészthető.', 'https://nashhungary.hu/wp-content/uploads/2022/01/6749-b3419-1-3-800.jpg', (SELECT id FROM suppliers WHERE name = 'NASH'), (SELECT id FROM productcategory WHERE name = 'Csalik')),
    ('SBS BOILIES+50ML BAIT DIP - SQUID O. & STRA\n', 3550, 'HUF', 'Az SBS legkedvezőbb árfekvésű kész bojlija mellé egy ajándék dipet adunk, mely párosításhoz továbbra is nagyon kedvező áron lehet hozzájutni!', 'https://epeca.hu/_user/page/webshop/1/sbs60-002/sbs60-002.webp', (SELECT id FROM suppliers WHERE name = 'EURO STAR'), (SELECT id FROM productcategory WHERE name = 'Csalik')),
    ('DAIWA Tournament XL Shiner 130F', 1500, 'HUF', '', 'https://www.fishernator.com/media/catalog/product/cache/8/image/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/6/16710-101_1_1.jpg', (SELECT id FROM suppliers WHERE name = 'DAIWA'), (SELECT id FROM productcategory WHERE name = 'Csalik')),
    ('DAIWA Pop Up Hookbait', 1470, 'HUF', '', 'https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/3/13300-300_pop_up_red_1.jpg', (SELECT id FROM suppliers WHERE name = 'DAIWA'), (SELECT id FROM productcategory WHERE name = 'Csalik')),
    ('Spinner - Mepps Aglia TW with fish silver', 1700, 'HUF', '', 'https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/5/2/52-71004_p_web.jpg', (SELECT id FROM suppliers WHERE name = 'MEPPS'), (SELECT id FROM productcategory WHERE name = 'Csalik')),

    ('Box Logic Chod Box', 6090, 'HUF', 'Egy doboz kimondottan a chod rigekhez, stiff hinge horogrészekhez és minden más hosszú, hajlított zsugoros előkéhez. Egy belső szivacshengerrel, az előkék feszes és stabil tárolásához, hogy megtartsák formájukat. Akár 15 előkéhez. Gombostűkkel szállítva.', 'https://nashhungary.hu/wp-content/uploads/2022/01/9507-t0279_2-1-3-800.jpg', (SELECT id FROM suppliers WHERE name = 'EURO STAR'), (SELECT id FROM productcategory WHERE name = 'Dobozok')),

    ('CORMORAN Cormoran Umbrella XXL', 22900, 'HUF', '', 'https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/6/8/68-35300_anglerschirm.jpg', (SELECT id FROM suppliers WHERE name = 'CORMORAN'), (SELECT id FROM productcategory WHERE name = 'Kiegészítők')),
    ('JRC Radar CX Alarms Set, Bite Indicator Set', 42900, 'HUF', '',  'https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/e/m/emea_1404485_is.jpg', (SELECT id FROM suppliers WHERE name = 'JRC'), (SELECT id FROM productcategory WHERE name = 'Kiegészítők')),
    ('SHIMANO Tribal TX, Carp Fishing Landing Net', 21900, 'HUF', '', 'https://www.fishernator.com/media/catalog/product/cache/8/image/1500x1500/9df78eab33525d08d6e5fb8d27136e95/t/x/tx-plus-42in-landing-net_1250x1250px_v1_3.jpg', (SELECT id FROM suppliers WHERE name = 'SHIMANO'), (SELECT id FROM productcategory WHERE name = 'Kiegészítők')),
    ('Daiwa Infinity Boat Pod, Boat Rod Pod', 11200, 'HUF', '', 'https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/8/18800-900_3.jpg', (SELECT id FROM suppliers WHERE name = 'DAIWA'), (SELECT id FROM productcategory WHERE name = 'Kiegészítők')),

    ('Penn International VIS', 300000, 'HUF', 'The PENN International VI series is designed and manufactured in the USA of domestic and imported components.', 'https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/i/n/international_vis_int130vis_001.jpg', (SELECT id FROM suppliers WHERE name = 'PENN'), (SELECT id FROM productcategory WHERE name = 'Orsók')),
    ('Shimano 20 Stella', 299000, 'HUF', 'The reel has been improved on many points: it is even stronger, more though, more durable and more powerful.', 'https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/s/t/stlsw30000c_001.jpg', (SELECT id FROM suppliers WHERE name = 'SHIMANO'), (SELECT id FROM productcategory WHERE name = 'Orsók')),
    ('Shimano Tiagra', 200000, 'HUF', 'The indestructible and proven Tiagra reels give confidence in the fight with the capitals. Leading the world in the Big Game reels.',  'https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/t/i/ti130a-shimano-tiagra-130a-trolling-saltwater-fishing-reel-1.jpg', (SELECT id FROM suppliers WHERE name = 'SHIMANO'), (SELECT id FROM productcategory WHERE name = 'Orsók')),


    ('Team Daiwa Flotation Suit', 9000, 'HUF', 'Two-piece high-quality swim suit!', 'https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/8/18510-120_1_11.jpg', (SELECT id FROM suppliers WHERE name = 'DAIWA'), (SELECT id FROM productcategory WHERE name = 'Ruházat')),
    ('HOTSPOT DESIGN Anorak Jacket Carpfishing Mania', 11000, 'HUF', 'Exceptionally warm, breathable, robust, waterproof and wind-resistant, features who are mixed with a timeless and stylish design, the result is a premium quality jacket.', 'https://www.fishernator.com/media/catalog/product/cache/8/image/1500x1500/9df78eab33525d08d6e5fb8d27136e95/0/1/0108007_1.jpg', (SELECT id FROM suppliers WHERE name = 'HOTSPOT DESIGN'), (SELECT id FROM productcategory WHERE name = 'Ruházat')),

    ('JRC Extreme TX2 2-Man Bivvy', 90000, 'HUF', '', 'https://www.fishernator.com/media/catalog/product/cache/8/thumbnail/1500x1500/9df78eab33525d08d6e5fb8d27136e95/1/5/1503039.jpg', (SELECT id FROM suppliers WHERE name = 'JRC'), (SELECT id FROM productcategory WHERE name = 'Sátrak')),


    ('Nash Prodding Stick Kit\n', 25000, 'HUF', 'Egy frisített dizájn az idő próbálta Nash Prodding Stick Kit-nek. Üvegszálas tagok, rugós rögzítéssel biztosítják a meder legpontosabb feltérképezését, a táplálkozási helyek, mélyedések és természetes tápanyagforrások gyors megtalálását.', 'https://nashhungary.hu/wp-content/uploads/2022/01/NASH-PRODDING-STICK-KIT1.jpg', (SELECT id FROM suppliers WHERE name = 'NASH'), (SELECT id FROM productcategory WHERE name = 'Tapogatórúd')),

    ('Nash Carryall', 32500, 'HUF', 'Strapabíró, az időtállóan bízonyított dizájn, ami teljes rugalmasságot biztosít három méretben, hogy minden túrának és minden tárolási követelménynek megfeleljen. A Small, Medium és Large Carryallok a valaha volt legnépszerűbb pontyhorgász táskák.','https://nashhungary.hu/wp-content/uploads/2022/02/8387-t3548-1-3-800.jpg', (SELECT id FROM suppliers WHERE name = 'NASH'), (SELECT id FROM productcategory WHERE name = 'Táskák'))
;

