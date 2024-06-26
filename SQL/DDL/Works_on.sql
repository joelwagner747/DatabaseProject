CREATE TABLE jw193055.WORKS_ON
(
    Employee_id INT NOT NULL CONSTRAINT FK_WORKS_ON_EMPLOYEE FOREIGN KEY(Employee_id) REFERENCES jw193055.EMPLOYEE(Employee_id) ON UPDATE CASCADE ON DELETE CASCADE,
    Assignment_id INT NOT NULL CONSTRAINT FK_WORKS_ON_ASSIGNMENT FOREIGN KEY(Assignment_id) REFERENCES jw193055.ASSIGNMENT(Assignment_id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT PK_WORKS_ON PRIMARY KEY (Employee_id, Assignment_id),
);