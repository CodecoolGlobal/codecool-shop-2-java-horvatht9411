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

INSERT INTO product (name, defaultprice, currency, description, img_url, supplier_id, category_id) VALUES
    ('Euro Star feeder bot', 12915, 'HUF', 'EUROSTAR MASTER CLASS FEEDER 3+2 30-90gr feeder bot. Az EUROSTAR egyik legsikeresebb és legjobban eltalált szériája a MASTER CLASS feeder bot család.', 'https://epeca.hu/_user/page/webshop/3/em60391/em60391.webp',(SELECT id FROM suppliers WHERE name = 'EURO STAR'), (SELECT id FROM productcategory WHERE name = 'Horgászbotok')),
;


