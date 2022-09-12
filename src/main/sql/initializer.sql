INSERT INTO productcategory (name, department, description) VALUES
    ('Horgászbotok', 'horgaszbotok', '')
;

INSERT INTO suppliers (name, description) VALUES
    ('EURO STAR', 'horgászbot')
;

INSERT INTO product (name, defaultprice, currency, description, img_url, supplier_id, category_id) VALUES
    ('Euro Star feeder bot', 12915, 'HUF', 'EUROSTAR MASTER CLASS FEEDER 3+2 30-90gr feeder bot. Az EUROSTAR egyik legsikeresebb és legjobban eltalált szériája a MASTER CLASS feeder bot család.', 'https://epeca.hu/_user/page/webshop/3/em60391/em60391.webp',(SELECT id FROM suppliers WHERE name = 'EURO STAR'), (SELECT id FROM productcategory WHERE name = 'Horgászbotok'));
;


