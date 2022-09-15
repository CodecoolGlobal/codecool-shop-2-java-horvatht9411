DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS productCategory;
DROP TABLE IF EXISTS suppliers;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS orderDetails;


CREATE TABLE productCategory
(
    id          SERIAL PRIMARY KEY,
    name        TEXT UNIQUE NOT NULL,
    department  TEXT        NOT NULL,
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
    name         TEXT UNIQUE NOT NULL,
    defaultPrice INTEGER     NOT NULL,
    currency     TEXT        NOT NULL,
    description  TEXT,
    img_URL      TEXT        NOT NULL,
    supplier_id  INTEGER REFERENCES suppliers (id),
    category_id  INTEGER REFERENCES productCategory (id)

);


CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    name     TEXT NOT NULL,
    email    TEXT UNIQUE NOT NULL,
    password TEXT        NOT NULL,
    salt TEXT NOT NULL
);

CREATE TABLE orders
(
    id          SERIAL  NOT NULL PRIMARY KEY,
    user_id     INTEGER,
    name        TEXT    NOT NULL,
    email       TEXT    NOT NULL,
    city        TEXT    NOT NULL,
    address     TEXT    NOT NULL,
    zip_code    INTEGER NULL,
    state       TEXT    NOT NULL,
    card_name   TEXT    NOT NULL,
    card_number TEXT    NOT NULL,
    exp_month   TEXT    NOT NULL,
    exp_year    TEXT    NOT NULL,
    cvv         TEXT    NOT NULL
);

CREATE TABLE orderDetails
(
    product_id INTEGER NOT NULL,
    quantity   INTEGER NOT NULL,
    cart_id    INTEGER REFERENCES orders (id)
);


