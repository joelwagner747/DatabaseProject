CREATE TABLE jw193055.SPECIAL_EQUIP
(
    Equip_id INT IDENTITY(1,1) CONSTRAINT PK_SPECIAL_EQUIP PRIMARY KEY,
    Equip_name VARCHAR(100) NOT NULL,
    Equip_quantity INT NOT NULL,
    Equip_price DECIMAL(14, 2) NOT NULL CONSTRAINT CK_EQUIP_PRICE CHECK (Equip_price >= 0),
    Equip_note VARCHAR(MAX),
);