
CREATE DATABASE IF NOT EXISTS gastronomie;

CREATE TABLE IF NOT EXISTS client (
    code_client INTEGER PRIMARY KEY AUTO_INCREMENT,
    name_client VARCHAR(255) NOT NULL,
    first_name_client VARCHAR(255) NOT NULL,
    telephone_client VARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS employ (
    code_employ INTEGER PRIMARY KEY AUTO_INCREMENT,
    type_employ VARCHAR(20) NOT NULL,
    name_employ VARCHAR(255) NOT NULL,
    first_name_employ VARCHAR(255) NOT NULL,
    password_cais VARCHAR(255),
    telephone_employ VARCHAR(10) NOT NULL,
    image_employ VARCHAR(255) NOT NULL,
    cin_employ varchar(14) NOT NULL
);

CREATE TABLE IF NOT EXISTS image (
    code_img INTEGER PRIMARY KEY AUTO_INCREMENT,
    path_img VARCHAR(255) NOT NULL,
    is_principale BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS product (
   code_product INTEGER PRIMARY KEY AUTO_INCREMENT,
   name_product varchar(255) NOT NULL,
   description_product TEXT
);

CREATE TABLE IF NOT EXISTS product_image (
    code_img INTEGER NOT NULL,
    code_product INTEGER NOT NULL,
    CONSTRAINT fk_product_pi
        FOREIGN KEY (code_product)
        REFERENCES product (code_product)
        ON DELETE CASCADE ON UPDATE NO ACTION,
    CONSTRAINT fk_img_pi
        FOREIGN KEY (code_img)
        REFERENCES image (code_img)
        ON DELETE CASCADE ON UPDATE NO ACTION

);

CREATE TABLE IF NOT EXISTS price_produit (
     code_price INTEGER PRIMARY KEY AUTO_INCREMENT,
     code_product INTEGER NOT NULL,
     date_price DATETIME NOT NULL,
     value_price FLOAT NOT NULL,
     CONSTRAINT product_pp
         FOREIGN KEY (code_product)
         REFERENCES product(code_product)
         ON DELETE RESTRICT ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS command (
    code_command INTEGER PRIMARY KEY AUTO_INCREMENT,
    code_employ INTEGER NOT NULL,
    code_client INTEGER NOT NULL,
    CONSTRAINT fk_client_c
        FOREIGN KEY (code_client)
        REFERENCES client (code_client)
        ON DELETE RESTRICT ON UPDATE NO ACTION ,
    CONSTRAINT fk_employ_c
        FOREIGN KEY (code_employ)
        REFERENCES employ(code_employ)
        ON DELETE RESTRICT ON UPDATE NO ACTION ,
    date_command DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS product_command (
    code_product INTEGER NOT NULL,
    code_command INTEGER NOT NULL,
    nombre INTEGER(3) DEFAULT 1,
    CONSTRAINT fk_product_pc
        FOREIGN KEY (code_product)
        REFERENCES product(code_product)
        ON DELETE RESTRICT ON UPDATE NO ACTION ,
    CONSTRAINT fk_command_pc
        FOREIGN KEY (code_command)
        REFERENCES command(code_command)
        ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS livraison (
    code_livraison INTEGER PRIMARY KEY AUTO_INCREMENT,
    code_employ INTEGER NOT NULL,
    frait_livraison FLOAT NOT NULL,
    lieu_livraison varchar(255) NOT NULL,
    date_livraison DATETIME NOT NULL,
    CONSTRAINT fk_employ
        FOREIGN KEY (code_employ)
        REFERENCES employ(code_employ)
        ON DELETE RESTRICT ON UPDATE NO ACTION

);
