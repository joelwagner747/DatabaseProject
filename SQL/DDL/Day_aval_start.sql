CREATE TABLE jw193055.DAY_AVAL_START
(
    Employee_id INT NOT NULL,
    Day_num INT NOT NULL,
    Aval_start TIME NOT NULL,
    CONSTRAINT FK_DAY_AVAL_START_DAY_AVAL FOREIGN KEY(Employee_id, Day_num) REFERENCES jw193055.DAY_AVAL(Employee_id, Day_num) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT PK_DAY_AVAL_START PRIMARY KEY (Employee_id, Day_num, Aval_start),
);