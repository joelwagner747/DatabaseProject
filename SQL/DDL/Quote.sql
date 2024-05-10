CREATE TABLE jw193055.QUOTE
(
    Quote_id INT IDENTITY(1,1) CONSTRAINT PK_QUOTE PRIMARY KEY,
    Street_address VARCHAR(100) NOT NULL,
    City VARCHAR(35) NOT NULL,
    State CHAR(2) NOT NULL,
    Zip_code CHAR(5) NOT NULL,
    Quote_state CHAR(8) NOT NULL CONSTRAINT QUOTE_STATE_VALID CHECK (Quote_state IN ('Pending', 'Rejected', 'Approved')),
    Date_of_creation DATE NOT NULL,
    Start_available DATE,
    End_available DATE,
    Quote_employee_note VARCHAR(MAX),
    Quote_customer_note VARCHAR(MAX),
    Customer_id INT NOT NULL CONSTRAINT FK_QUOTE_CUSTOMER FOREIGN KEY(Customer_num) REFERENCES jw193055.CUSTOMER(Customer_id),
);

GO

ALTER TABLE jw193055.QUOTE 
ADD CONSTRAINT DF_QUOTE_DATE_OF_CREATION DEFAULT CAST(GETDATE() AS DATE) FOR Date_of_creation;

GO

-- DROP TABLE jw193055.QUOTE;