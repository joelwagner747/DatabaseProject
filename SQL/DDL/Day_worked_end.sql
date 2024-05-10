CREATE TABLE jw193055.DAY_WORKED_END
(
    Employee_id INT NOT NULL,
    Start_date DATE NOT NULL,
    Day_num INT NOT NULL,
    Worked_End TIME NOT NULL,
    CONSTRAINT FK_DAY_WORKED_END_DAY_WORKED FOREIGN KEY(Employee_id, Start_date, Day_num) REFERENCES jw193055.DAY_WORKED(Employee_id, Start_date, Day_num) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT PK_DAY_WORKED_END PRIMARY KEY (Employee_id, Start_date, Day_num, Worked_End),
);