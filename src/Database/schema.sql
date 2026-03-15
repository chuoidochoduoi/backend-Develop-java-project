

create schema myproject;




CREATE TABLE admin (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL
);

CREATE TABLE product (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         brand VARCHAR(50) NOT NULL,
                         price DECIMAL(12,2) NOT NULL,
                         stock INT NOT NULL
);

CREATE TABLE customer (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          phone VARCHAR(20),
                          email VARCHAR(100) UNIQUE,
                          address VARCHAR(255)
);

CREATE TABLE invoice (
                         id SERIAL PRIMARY KEY,
                         customer_id INT,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         total_amount DECIMAL(12,2) NOT NULL,
                         FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE invoice_details (
                                 id SERIAL PRIMARY KEY,
                                 invoice_id INT,
                                 product_id INT,
                                 quantity INT NOT NULL,
                                 unit_price DECIMAL(12,2) NOT NULL,
                                 FOREIGN KEY (invoice_id) REFERENCES invoice(id),
                                 FOREIGN KEY (product_id) REFERENCES product(id)
);

insert into admin(username, password) VALUES ('cuong2','123456')