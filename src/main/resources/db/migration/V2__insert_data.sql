INSERT INTO categories (name) VALUES ('Electronics'), ('Accessories'), ('Clothes');

INSERT INTO tags (name) VALUES ('New'), ('Hot'), ('Discount');

INSERT INTO products (name, price,description, category_id) VALUES
                                                    ('iPhone 16 Pro', 1200.00, 'white 256gb',1),
                                                    ('MacBook Air M3', 1500.00,'dark blue' ,1),
                                                    ('T-Shirt Basic', 25.00,'red ' ,3);

INSERT INTO product_tags (product_id, tag_id) VALUES
                                                  (1, 1),
                                                  (1, 2),
                                                  (2, 1),
                                                  (3, 3);