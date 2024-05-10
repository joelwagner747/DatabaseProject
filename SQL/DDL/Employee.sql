CREATE TABLE jw193055.EMPLOYEE 
(
    Employee_id INT CONSTRAINT PK_EMPLOYEE PRIMARY KEY,
    Employee_first_name VARCHAR(100) NOT NULL,
    Employee_mid_initial CHAR(1) NOT NULL,
    Employee_last_name VARCHAR(100) NOT NULL,
    Street_address VARCHAR(100) NOT NULL,
    City VARCHAR(35) NOT NULL,
    State CHAR(2) NOT NULL,
    Zip_code CHAR(5) NOT NULL,
    Employee_email VARCHAR(255) NOT NULL,
    Employee_phone_num CHAR(10) NOT NULL,
    Employee_password VARCHAR(128) NOT NULL,
    Employee_manager BIT NOT NULL CONSTRAINT DF_EMPLOYEE_ISMANAGER DEFAULT 0,
);