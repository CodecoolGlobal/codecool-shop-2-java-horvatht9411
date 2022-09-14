DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS productCategory;
DROP TABLE IF EXISTS suppliers;
DROP TABLE IF EXISTS users;


CREATE TABLE productCategory
(
    id          SERIAL PRIMARY KEY,
    name        TEXT UNIQUE NOT NULL,
    department  TEXT NOT NULL,
    description TEXT
);

CREATE TABLE suppliers
(
    id          SERIAL PRIMARY KEY,
    name        TEXT UNIQUE NOT NULL,
    description TEXT
);

CREATE TABLE product
(
    id           SERIAL PRIMARY KEY,
    name         TEXT UNIQUE    NOT NULL,
    defaultPrice INTEGER NOT NULL,
    currency     TEXT    NOT NULL,
    description  TEXT,
    img_URL      TEXT    NOT NULL,
    supplier_id  INTEGER REFERENCES suppliers(id),
    category_id  INTEGER REFERENCES productCategory (id)

);



CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    name     TEXT UNIQUE NOT NULL,
    email    TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL
);


