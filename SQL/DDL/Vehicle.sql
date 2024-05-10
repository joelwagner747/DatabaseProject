CREATE TABLE jw193055.VEHICLE
(
    VIN_num CHAR(17) CONSTRAINT PK_VEHICLE PRIMARY KEY,
    License_num VARCHAR(15) NOT NULL CONSTRAINT KEY_VEHICLE UNIQUE,
    Year INT NOT NULL CONSTRAINT CK_VEHICLE_YEAR CHECK (Year > 1900),
    Make VARCHAR(25) NOT NULL,
    Model VARCHAR(25) NOT NULL,
    Vehicle_note VARCHAR(MAX),
);