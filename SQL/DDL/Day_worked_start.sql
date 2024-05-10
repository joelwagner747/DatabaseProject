CREATE TABLE jw193055.DAY_WORKED_START
(
    Employee_id INT NOT NULL,
    Start_date DATE NOT NULL,
    Day_num INT NOT NULL,
    Worked_Start TIME NOT NULL,
    CONSTRAINT FK_DAY_WORKED_START_DAY_WORKED FOREIGN KEY(Employee_id, Start_date, Day_num) REFERENCES jw193055.DAY_WORKED(Employee_id, Start_date, Day_num) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT PK_DAY_WORKED_START PRIMARY KEY (Employee_id, Start_date, Day_num, Worked_Start),
);