CREATE TABLE categories
(
    id         BINARY(16)   NOT NULL,
    created_on datetime NULL,
    updated_on datetime NULL,
    name       VARCHAR(255) NULL,
    CONSTRAINT pk_categories PRIMARY KEY (id)
);

CREATE TABLE products
(
    id            BINARY(16)   NOT NULL,
    created_on    datetime NULL,
    updated_on    datetime NULL,
    title         VARCHAR(255) NULL,
    `description` VARCHAR(1000) NULL,
    price DOUBLE NOT NULL,
    category_id   BINARY(16)   NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES categories (id);