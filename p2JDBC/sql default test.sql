
use project;
-- db admin
create table admin(
   id INT NOT NULL AUTO_INCREMENT,
   password VARCHAR(40),
   name VARCHAR(40),
   added_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY ( id )
);


INSERT INTO admin (email, password, name)
VALUES
	("admin@gmail.com", "admin123", "admin"),
	("alpha@gmail.com", "alpha123", "alpha"),
    ("beta@gmail.com", "beta123", "beta"),
    ("omega@gmail.com", "omega123", "omega"),
    ("gama@gmail.com", "gama123", "gama");
    

DROP PROCEDURE IF EXISTS ADDadmin;

DELIMITER $$
CREATE PROCEDURE ADDadmin()
	BEGIN
		DECLARE i INT DEFAULT 1;
        declare mail VARCHAR(45) DEFAULT CONCAT('admin',i,'@email.com');
        declare n VARCHAR(45) DEFAULT CONCAT('admin',i);
        declare pass VARCHAR(45) DEFAULT CONCAT('adminpass',i);
        add_loop :LOOP
        INSERT INTO customer ( email, password, name)
			VALUES ( mail , pass, n);
            SET i=i+1;
            IF i=10 THEN 
				LEAVE add_loop;
            END IF;
		END LOOP add_loop;
END $$
CALL ADDadmin();
SELECT * FROM  admin;

-- db customer
CREATE TABLE customer(
	id INT NOT NULL AUTO_INCREMENT,
    address VARCHAR(100),
    added_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    email VARCHAR(50),
    gender VARCHAR(1),
    name VARCHAR(40),
    password VARCHAR(40),
    phone VARCHAR(40),
    customer INT,
    PRIMARY KEY(id)
);

DROP PROCEDURE IF EXISTS ADDc;

DELIMITER $$
CREATE PROCEDURE ADDc()
	BEGIN
		DECLARE i INT DEFAULT 1;
        DECLARE are VARCHAR(200) DEFAULT 'address';
        declare mail VARCHAR(45) DEFAULT CONCAT('user',i,'@email.com');
        declare n VARCHAR(45) DEFAULT 'user';
        declare pass VARCHAR(45) DEFAULT 'userpass';
        declare cell VARCHAR(10) DEFAULT '0123456789';
        add_loop :LOOP
        INSERT INTO customer (address, email, name, password, phone)
			VALUES ( CONCAT(are,i) ,  mail , concat(n,i) ,  concat(pass,i) , cell);
            SET i=i+1;
            IF i=100 THEN 
				LEAVE add_loop;
            END IF;
		END LOOP add_loop;
END $$

CALL ADDc();
SELECT * FROM  project.customer;

-- db product
CREATE TABLE product(
	id INT NOT NULL AUTO_INCREMENT,    
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    description VARCHAR(200),
    image VARCHAR(20),
    image_name VARCHAR(20),
    name VARCHAR(10),
    price INT,
    discount INT,
    product_category VARCHAR(20),
    PRIMARY KEY(id)
);


CREATE TABLE cart(
	id INT NOT NULL AUTO_INCREMENT,
    discount_price INT,
    quantity INT,
    total_price INT,
    customer INT,
    product_id INT,
    PRIMARY KEY(id)
);

CREATE TABLE orders(
	id INT NOT NULL AUTO_INCREMENT,
    order_no INT,
    custoemr_name VARCHAR(45),
    mobile_number VARCHAR(45),
    email_id VARCHAR(45),
    address VARCHAR(45),
    address_type VARCHAR(45),
    image VARCHAR(45),
    image_name VARCHAR(45),
    product_name VARCHAR(45),
    quantity INT,
    product_price INT,
    product_selling_price INT,
    product_total_price INT,
    order_status VARCHAR(10),
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP
);





















