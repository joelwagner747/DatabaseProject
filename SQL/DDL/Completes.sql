CREATE TABLE jw193055.COMPLETES
(
    Job_id INT NOT NULL CONSTRAINT FK_COMPLETES_JOB FOREIGN KEY(Job_id) REFERENCES jw193055.JOB(Job_id) ON UPDATE CASCADE ON DELETE CASCADE,
    Service_name VARCHAR(100) NOT NULL CONSTRAINT FK_COMPLETES_SERVICE FOREIGN KEY(Service_name) REFERENCES jw193055.SERVICE(Service_name) ON UPDATE CASCADE ON DELETE CASCADE,
    Service_price DECIMAL(14, 2) NOT NULL CONSTRAINT CK_COMPLETES_PRICE CHECK(Service_price >= 0),
    CONSTRAINT PK_COMPLETES PRIMARY KEY (Job_id, Service_name),
);