-- Inserting values into CUSTOMER table.
INSERT INTO jw193055.CUSTOMER (Customer_first_name, Customer_last_name, Street_address, City, State, Zip_code, Customer_phone_num, Customer_email)
VALUES
    ('Bob', 'Smith', '1717 Ford Way', 'Missoula', 'MT', '59808', '4062415555', 'bob.smith@email.com'),
    ('Jean', 'Jones', '100 Pineapple Lane', 'Missoula', 'MT', '59801', '4063334444', 'jean.jones@email.com'),
    ('Fred', 'Murry', '150 Tree Road', 'Missoula', 'MT', '59808', '4061234567', 'fred.murray@email.com'),
    ('Lucy', 'Steel', '215 Money Drive', 'Missoula', 'MT', '59808', '3149998888', 'lucy.steel@email.com'),
    ('Jim', 'Williams', '56 Apple Lane', 'Missoula', 'MT', '59801', '4069991111', 'jim.williams@email.com'),
    ('Tony', 'Stark', '100 Stark Way', 'Missoula', 'MT', '59808', '4061237890', 'tony.stark@email.com'),
    ('Steve', 'Rogers', '50 American Drive', 'Missoula', 'MT', '59808', '4067552610', 'steve.rogers@email.com'),
    ('Bruce', 'Banner', '800 Green Road', 'Missoula', 'MT', '59808', '4069898989', 'bruce.banner@email.com'),
    ('Bruce', 'Wayne', '500 Wayne Way', 'Missoula', 'MT', '59808', '5006007000', 'bruce.wayne@email.com'),
    ('Clark', 'Kent', '600 Super Drive', 'Missoula', 'MT', '59801', '4061112222', 'clark.kent@email.com');
GO

INSERT INTO jw193055.QUOTE (Street_address, City, State, Zip_code, Quote_state, Start_available, End_available, Quote_employee_note, Quote_customer_note, Customer_id)
VALUES
    ('1717 Ford Way', 'Missoula', 'MT', '59808','Pending', '2024-05-13', '2024-05-17', 'Requires Waterfed Pole', 'The landscapers are coming this week so it will have to be next week', 1),
    ('100 Pineapple Lane', 'Missoula', 'MT', '59801','Pending', '2024-05-9', '2024-06-30', 'Includes hard water removal', 'Be careful around the rose bushes', 2),
    ('100 Wayne Way', 'Missoula', 'MT', '59808','Approved', '2024-05-20', '2024-05-24', '32 feet ladder needed', 'Watch out for bats', 9),
    ('56 Apple Lane', 'Missoula', 'MT', '59801','Approved', '2024-05-13', '2024-05-31', '3 guy job', 'Can you dust the beams inside?', 5),
    ('100 Stark Way', 'Missoula', 'MT', '59808','Rejected', '2024-05-13', '2024-05-31', 'Lift Neede', 'Can you come back at a latter time', 6);
GO

INSERT INTO jw193055.INVOICE (Street_address, City, State, Zip_code, Invoice_date, Invoice_paid, Customer_id)
VALUES
    ('150 Tree Road', 'Missoula', 'MT', '59808', '2024-05-08', 0, 3),
    ('215 Money Drive', 'Missoula', 'MT', '59808', '2024-05-03', 0, 4),
    ('115 Money Drive', 'Missoula', 'MT', '59808', '2024-05-01', 1, 4),
    ('50 Stark Way', 'Missoula', 'MT', '59808', '2023-05-03', 1, 6),
    ('600 Super Drive', 'Missoula', 'MT', '59801', '2023-05-10', 1, 10);
GO

INSERT INTO jw193055.JOB (Job_date, Job_time, Street_address, City, State, Zip_code, Job_completed, Job_employee_note, Job_customer_note, Customer_id)
VALUES
    ('2024-05-13', '08:30:00', '500 Wayne Way', 'Missoula', 'MT', '59808', 0, 'Bring 32 Ladder', 'Do not drive the batmobile', 9),
    ('2024-05-14', '12:00:00', '600 Super Drive', 'Missoula', 'MT', '59801', 0, 'Bring Pressue Washer', 'Stop looking for a telephone booth', 10),
    ('2024-05-14', '08:30:00', '800 Green Road', 'Missoula', 'MT', '59808', 0, 'Do not upset the client', 'Hulk Smash', 8),
    ('2024-05-9', '08:30:00', '50 American Drive', 'Missoula', 'MT', '59808', 1, 'Hard water removal', 'Do not throw the shield', 7),
    ('2024-05-9', '12:30:00', '200 Wayne Way', 'Missoula', 'MT', '59808', 1, 'Roof Cleaning', 'Stop bugging Robin', 9);
GO

INSERT INTO jw193055.SERVICE (Service_name)
VALUES
    ('Exterior Window Cleaning'),
    ('Interior Window Cleaning'),
    ('Interior and Exterior Window Cleaning'),
    ('Screen Cleaning'),
    ('Roof Cleaning'),
    ('Gutter Cleaning'),
    ('Pressure Washing'),
    ('Miscellaneous Services');
GO

INSERT INTO jw193055.SPECIAL_EQUIP (Equip_name, Equip_quantity, Equip_price, Equip_note)
VALUES
    ('Waterfed Pole', 1, 0, 'Change Filter'),
    ('32 Foot Ladder', 2, 25.00, 'Replace Rope'),
    ('Pressure Washer', 1, 50.00, 'Get more Soap'),
    ('Leaf Blower', 4, 15.00, 'Buy More Gas'),
    ('Porso Brite', 50, 10.00, 'Buy More');
GO

INSERT INTO jw193055.EMPLOYEE (Employee_id, Employee_first_name, Employee_mid_initial, Employee_last_name, Street_address, City, State, Zip_code, Employee_email, Employee_phone_num, Employee_password, Employee_manager)
VALUES
    (9999, 'Peter', 'B', 'Parker', '50 Plaza Way', 'Missoula', 'MT', '59808', 'peter.parker@email.com', '4062465555', 'spiderman', 0),
    (8888, 'Tom', 't', 'Jones', '100 Montana Drive', 'Missoula', 'MT', '59808', 'tom.jones@email.com', '4065758888', 'password', 0),
    (7777, 'Charles', 'J', 'Wood', '500 Old Fence Post Road', 'Missoula', 'MT', '59808', 'charles.wood@email.com', '4062465555', 'password', 0),
    (6666, 'Phil', 'B', 'Strong', '7 Mullan Road', 'Missoula', 'MT', '59808', 'phil.strong@email.com', '4066912345', 'password', 0),
    (5555, 'Steve', 'C', 'Clean', '10 Clean Drive', 'Missoula', 'MT', '59808', 'steve.clean@email.com', '4067896601', 'password', 1);
GO

INSERT INTO jw193055.ASSIGNMENT (Assignment_date)
VALUES
    ('2024-05-13'),
    ('2024-05-14'),
    ('2024-05-9');
GO

INSERT INTO jw193055.VEHICLE (VIN_num, License_num, Year, Make, Model, Vehicle_note)
VALUES
    ('1f111111111111111', '4B34C5', 2010, 'Ford', 'F150', 'Add air to tires'),
    ('1f222222222222222', '4C34C5', 2015, 'Ford', 'F150', ''),
    ('1f333333333333333', '4B34C7', 2018, 'Ford', 'Ranger', 'Change Oil');
GO

INSERT INTO jw193055.TIMEOFF (Employee_id, Start_date, End_date, Approved)
VALUES
    (9999, '2024-05-20', '2024-05-24', 1),
    (8888, '2024-05-13', '2024-05-13', 1),
    (7777, '2024-05-16', '2024-05-17', 0),
    (6666, '2024-05-27', '2024-05-31', 0),
    (5555, '2024-05-3', '2024-05-3', 1);
GO

INSERT INTO jw193055.DAY_AVAL (Employee_id, Day_num)
VALUES
    (9999, 2),
    (9999, 3),
    (9999, 4),
    (9999, 5),
    (9999, 6),
    (8888, 2),
    (8888, 3),
    (8888, 4),
    (8888, 5),
    (8888, 6),
    (7777, 2),
    (7777, 3),
    (7777, 4),
    (7777, 5),
    (7777, 6),
    (6666, 2),
    (6666, 3),
    (6666, 4),
    (6666, 5),
    (6666, 6),
    (5555, 2),
    (5555, 3),
    (5555, 4),
    (5555, 5),
    (5555, 6);
GO

INSERT INTO jw193055.TIMESHEET (Employee_id, Start_date, End_date)
VALUES
    (9999, '2024-04-27', '2024-05-10'),
    (8888, '2024-04-27', '2024-05-10'),
    (7777, '2024-04-27', '2024-05-10'),
    (6666, '2024-04-27', '2024-05-10'),
    (5555, '2024-04-27', '2024-05-10');
GO

INSERT INTO jw193055.DAY_WORKED (Employee_id, Start_date, Day_num)
VALUES
    (9999, '2024-04-27', 3),
    (9999, '2024-04-27', 4),
    (9999, '2024-04-27', 5),
    (9999, '2024-04-27', 6),
    (9999, '2024-04-27', 7);
GO

INSERT INTO jw193055.IS_ASSIGNED (Job_id, Assignment_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 2),
    (4, 3),
    (5, 3);
GO

INSERT INTO jw193055.QUOTED (Quote_id, Service_name, Service_price, Service_approved)
VALUES
    (1, 'Exterior Window Cleaning', 200.00, 0),
    (1, 'Pressure Washing', 300.00, 0),
    (2, 'Interior and Exterior Window Cleaning', 200.00, 0),
    (3, 'Interior and Exterior Window Cleaning', 1000.00, 1),
    (4, 'Interior and Exterior Window Cleaning', 300.00, 1),
    (4, 'Gutter Cleaning', 200.00, 0),
    (5, 'Interior and Exterior Window Cleaning', 1200.00, 0),
    (5, 'Roof Cleaning', 500.00, 0),
    (5, 'Screen Cleaning', 100.00, 0);
GO

INSERT INTO jw193055.PREFORMED (Invoice_id, Service_name, Service_price)
VALUES
    (1, 'Exterior Window Cleaning', 200.00),
    (1, 'Pressure Washing', 300.00),
    (2, 'Interior and Exterior Window Cleaning', 200.00),
    (3, 'Interior and Exterior Window Cleaning', 500.00),
    (4, 'Interior and Exterior Window Cleaning', 300.00),
    (4, 'Gutter Cleaning', 200.00),
    (5, 'Interior and Exterior Window Cleaning', 600.00),
    (5, 'Roof Cleaning', 500.00),
    (5, 'Screen Cleaning', 100.00);
GO

INSERT INTO jw193055.COMPLETES (Job_id, Service_name, Service_price)
VALUES
    (2, 'Pressure Washing', 300.00),
    (2, 'Interior and Exterior Window Cleaning', 200.00),
    (1, 'Interior and Exterior Window Cleaning', 1000.00),
    (3, 'Interior and Exterior Window Cleaning', 300.00),
    (4, 'Gutter Cleaning', 200.00),
    (4, 'Interior and Exterior Window Cleaning', 600.00),
    (5, 'Roof Cleaning', 500.00),
    (5, 'Screen Cleaning', 100.00);
GO

INSERT INTO jw193055.USES (Job_id, Equip_id, Equip_amount)
VALUES
    (1, 2, 1),
    (2, 3, 1),
    (4, 4, 2),
    (4, 5, 10),
    (5, 4, 2);
GO

INSERT INTO jw193055.TAKES (Assignment_id, VIN_num)
VALUES
    (1, '1f111111111111111'),
    (1, '1f333333333333333'),
    (2, '1f222222222222222'),
    (3, '1f111111111111111'),
    (3, '1f333333333333333'),
    (3, '1f222222222222222');
GO

INSERT INTO jw193055.WORKS_ON (Employee_id, Assignment_id)
VALUES
    (5555, 1),
    (6666, 1),
    (7777, 2),
    (9999, 2),
    (8888, 2),
    (5555, 3),
    (6666, 3),
    (7777, 3),
    (9999, 3),
    (8888, 3);
GO

INSERT INTO jw193055.DAY_AVAL_START(Employee_id, Day_num, Aval_start)
VALUES
    (5555, 2, '08:00:00'),
    (5555, 3, '08:00:00'),
    (5555, 4, '08:00:00'),
    (5555, 5, '08:00:00'),
    (5555, 6, '08:00:00'),
    (6666, 2, '08:00:00'),
    (6666, 3, '08:00:00'),
    (6666, 4, '08:00:00'),
    (6666, 5, '08:00:00'),
    (6666, 6, '08:00:00'),
    (7777, 2, '08:00:00'),
    (7777, 3, '08:00:00'),
    (7777, 4, '08:00:00'),
    (7777, 5, '08:00:00'),
    (7777, 6, '08:00:00'),
    (8888, 2, '08:00:00'),
    (8888, 3, '08:00:00'),
    (8888, 4, '08:00:00'),
    (8888, 5, '08:00:00'),
    (8888, 6, '08:00:00'),
    (9999, 2, '08:00:00'),
    (9999, 3, '08:00:00'),
    (9999, 4, '08:00:00'),
    (9999, 5, '08:00:00'),
    (9999, 6, '08:00:00');
GO

INSERT INTO jw193055.DAY_AVAL_END(Employee_id, Day_num, Aval_end)
VALUES
    (5555, 2, '17:00:00'),
    (5555, 3, '17:00:00'),
    (5555, 4, '17:00:00'),
    (5555, 5, '17:00:00'),
    (5555, 6, '17:00:00'),
    (6666, 2, '17:00:00'),
    (6666, 3, '17:00:00'),
    (6666, 4, '17:00:00'),
    (6666, 5, '17:00:00'),
    (6666, 6, '17:00:00'),
    (7777, 2, '17:00:00'),
    (7777, 3, '17:00:00'),
    (7777, 4, '17:00:00'),
    (7777, 5, '17:00:00'),
    (7777, 6, '17:00:00'),
    (8888, 2, '17:00:00'),
    (8888, 3, '17:00:00'),
    (8888, 4, '17:00:00'),
    (8888, 5, '17:00:00'),
    (8888, 6, '17:00:00'),
    (9999, 2, '17:00:00'),
    (9999, 3, '17:00:00'),
    (9999, 4, '17:00:00'),
    (9999, 5, '17:00:00'),
    (9999, 6, '17:00:00');
GO

INSERT INTO jw193055.DAY_WORKED_START(Employee_id, Start_date, Day_num, Worked_Start)
VALUES
    (9999, '2024-04-27', 3, '08:00:00'),
    (9999, '2024-04-27', 4, '08:00:00'),
    (9999, '2024-04-27', 5, '08:00:00'),
    (9999, '2024-04-27', 6, '08:00:00'),
    (9999, '2024-04-27', 7, '08:00:00');
GO

INSERT INTO jw193055.DAY_WORKED_END(Employee_id, Start_date, Day_num, Worked_End)
VALUES
    (9999, '2024-04-27', 3, '17:00:00'),
    (9999, '2024-04-27', 4, '17:00:00'),
    (9999, '2024-04-27', 5, '17:00:00'),
    (9999, '2024-04-27', 6, '17:00:00'),
    (9999, '2024-04-27', 7, '17:00:00');
GO