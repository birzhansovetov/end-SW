CREATE TABLE categories (
    id BIGSERIAL PRIMARY KEY ,
    name VARCHAR(255)

);

CREATE TABLE tags (
    id BIGSERIAL PRIMARY KEY ,
    name VARCHAR(255)
);

CREATE TABLE products (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(255),
                          price INT NOT NULL,
                          description VARCHAR(255),
                          category_id BIGINT REFERENCES categories(id)
);

CREATE TABLE product_tags (
                              product_id BIGINT REFERENCES products(id),
                              tag_id BIGINT REFERENCES tags(id)
);