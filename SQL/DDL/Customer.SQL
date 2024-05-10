CREATE TABLE jw193055.CUSTOMER
(
    Customer_id INT IDENTITY(1,1) CONSTRAINT PK_CUSTOMER PRIMARY KEY,
    Customer_first_name VARCHAR(100) NOT NULL,
    Customer_last_name VARCHAR(100) NOT NULL,
    Street_address VARCHAR(100) NOT NULL,
    City VARCHAR(35) NOT NULL,
    State CHAR(2) NOT NULL,
    Zip_code CHAR(5) NOT NULL,
    Customer_phone_num CHAR(10) NOT NULL,
    Customer_email VARCHAR(255) NOT NULL,
);

-- DROP TABLE jw193055.CUSTOMER;