# Logical Data Requirements


	Businesses have customers that need to be kept track of. Each Customer has a first and last name, a phone number, an email address, and a billing address. The billing address may need to have the individual parts referenced separately. Customers have a unique customer number.


	New customers are provided quotes. Quotes include the customer, the address where the work is being done, and the date that the quote was made. The individual parts of the address as well as the whole may need to be referenced. Each quote also has a quote number that is used to identify it. Each quote must have a customer, and quotes are only for one customer. There are several different high-level services available. These high-level services are exterior window cleaning, interior window cleaning, both interior and exterior window cleaning, screen cleaning, roof cleaning, gutter cleaning, pressure washing, and miscellaneous services. Each service that is quoted has a price and has a state of approval or rejection. Each quote also stores employee notes and customer notes. Each quote also has a state. The states are pending, rejected, and approved. Services should only have a state of approval if the quote has a state of approved. Quotes also store a start and end date of a customer's potential availability window. This is used to schedule the quote if it is approved.

 
	When work is approved by the customer it becomes a job. Jobs have the customer that the job is being done for and the location of the job stored as an address. The individual parts of the address as well as the whole may need to be referenced. Jobs must have a customer and can only be for one customer. Each job has a unique job number. Each job has a name and price specified for its high-level services. These services are exterior window cleaning, interior window cleaning, both interior and exterior window cleaning, screen cleaning, roof cleaning, gutter cleaning, pressure washing, and miscellaneous services. A job has a date and a time that the job is scheduled for. Jobs can also have employee notes and customer notes. Each job can also have specialized supplies/equipment used on the job. Multiple different specialized supplies may be used, or none may be used. The quantity of specialized equipment used needs to be tracked. The job has a Boolean to indicate whether or not the job has been completed.

 
	The businesses have invoices for completed jobs. An invoice has a customer, a unique invoice number, the location of the work, and the date that the work was performed. The parts of the location may need to be referenced individually. Each invoice must have a customer and can only be for one customer. The invoice has the name and price for each of the high-level services performed. These are exterior window cleaning, interior window cleaning, both interior and exterior window cleaning, screen cleaning roof cleaning, gutter cleaning, pressure washing, and miscellaneous services. There is also a Boolean to indicate whether or not the invoice has been paid. 

 
	The businesses have employees. Each employee has a first name, last name, middle initial, a unique employee number, an email address, a phone number, and an address. The address does not need to have its individual parts referenced. For each employee, there is a Boolean indicating whether or not the employee is a manager. Employees have an employee password.

 
	For each employee, there is an availability window. These are the days and hours that an employee is available to work. This is specified each day of the week that the employee is available to work. The employee may not be available any day or they may be available every day of the week. For full-time employees, these are normal business hours for every weekday, and for part-time employees, these vary. The company does not typically work during the weekends so employees should not be available to work during those times. Available days are listed and if a day is not present then the employee is not available to work on that day.

 
	Each employee has a timesheet. These timesheets are for two-week periods so each employee will have many time sheets, but each timesheet can only be for one employee. A timesheet must have an employee that it is for. Timesheets store the start date and end date of the pay period. For each day the timesheet tracks the hours that the employee worked. There are up to 14 days. However, an employee may work some or none of those days.

 
	Days are used to track employee’s availability and timesheets. A day must be included in an availability window or timesheet; however, timesheets and availability windows may not always have days if there is no data for it. These days have a start time and end time. There may be more than one start and end time; however, there should always be the same number of start and end times. Each day also has a number indicating what day of the week or day of the pay period it is. These are 1-7 or 1-14.

 
	Employees can make requests for time off. A time off request has a start date of the time and an end date of the time. Each time off request must be for exactly one employee; however, an employee can make multiple time off requests. The request should also have a Boolean to indicate whether or not the request has been approved. 
	The business has specialized equipment. Each specialized equipment has a name, a quantity, a unique equipment number, a price, and a note. Notes can be added by employees. Specialized equipment can be used on a job but is not always used.

 
	The businesses also have work vehicles. Each vehicle has a year, make, model, unique VIN number, and unique license plate number. Each vehicle can also have a note on it made by employees.

 
	Businesses would like to have the ability to make assignments of employees, jobs, and equipment. Each assignment is for a particular day. Assignments can have one or more jobs assigned to them, but each assignment must have at least one job assigned to it. However, jobs do not always have to be assigned to an assignment. Assignments can have one to multiple employees assigned to complete the jobs in the assignment, but assignments do not always have employees assigned to them. For an employee to be assigned to a job, it must be within their availability window, and it cannot be during an approved time off. Jobs in an assignment may require specialized equipment. However, jobs in separate assignments cannot use the same specialized equipment unless the quantity of each specialized equipment is enough to be used on both jobs. Each assignment also has a unique assignment number. Each assignment may also include a vehicle for the employees to use. There may be more than one vehicle on an assignment, but assignments do not always have to have a vehicle.

 
# Functional Features and Requirements


	Businesses would like the system to be tiered for two different types of employees. The first tier is managers/owners. Managers can create a quote by inputting prices for each high-level category, and the system will then calculate the total. If a quote is for an existing customer, managers select from the existing customers. If the quote is for a new customer, managers will input the customer's info and both the quote and the new customer will be created.  When creating the quote, managers have the option to input additional notes for employees. Managers can edit existing quotes at any time. Once created, quotes are sent to the customer for approval. If a quote is not approved within a specified amount of time, it is deleted.

 
	Managers can create jobs. Jobs are created either from existing quotes or past invoices. Jobs are created from quotes once they are approved either by the client or manager after talking to the client. In either case, once the quote has been marked as approved a manager creates the job from the quote. All information from the quote except for the approval status is copied over to the job. The manager schedules a job for a particular time and can add specialized equipment to the job and notes for the employees. Once jobs are created, they are assigned a unique job number. 
 
 
 	Jobs created from invoices are created in the same way where the manager selects the invoice and information is copied over. The job is then assigned a date and any specialized equipment. Managers can edit jobs any time after they are created. The most likely cause is rescheduling a job. When a job has been created from a quote, the quote is deleted from the system; however, invoices remain in the system. Jobs can be deleted from the system.
	Managers can create invoices. Invoices are typically created from jobs. Jobs must be marked as complete to have invoices created from them. To create the invoice, the system copies the customer information and service information from the job and calculates the total price including additional charges for specialized equipment and supplies. The date of the invoice is the scheduled date of the job. The invoice is then sent to the customer to be paid. If the invoice is not created from a job, an existing customer must be selected, or new customer information added. The price for the high-level categories must also be inputted and the date that the job was completed. An invoice is marked as paid either when a customer pays online or when marked as paid by a manager.

 
	Managers can also add new customers outside of quotes. They input the customer's first and last name, phone number, email address, and billing address. A unique customer number is then created for the customer. Managers can also edit existing customers at any time to change any of their contact info.

 
	Managers can add new employees by inputting the required information. They can also edit employee information. For each employee, they can also specify the availability window after talking to the employee. Managers also approve or deny time off requests of employees.

 
	Managers can add new specialized equipment to the system and modify existing equipment. The same is true for vehicles.

 
	Managers can also modify the prices of existing subservices or add new subservices.

 
	The second tier is regular employees. Managers/owners have all the functionality of regular employees in addition to their own functionality. Employees can view jobs and assignments and make notes on jobs, equipment, and vehicles. Employees can edit their contact own information and fill out timesheets that are in the current pay period. Employees can also create requests for time off and delete requests for time off.


	Employees can close out a job. Closing out a job is simply marking the job as completed. When a job is closed out the employee can add additional specialized equipment or supplies that were used on the job, so they can be charged for.

 
	Customers are the last users of the system. Businesses want to be able to send customers links to view quotes and invoices. Customers can approve quotes and add notes to the quote. When approving quotes customers can select whatever services they want done and an availability window for them for the job to get done. The approved quote is then sent to a manager to be finalized and scheduled as a job. Customers can also view invoices and be able to pay online; however, payment would be handled through a third-party service. Customers can also deny quotes. When customers deny quotes, they can input a reason for declining service.

 
	All managers and employees must log in to access their features; however, customers do not need to create an account or log in to approve quotes or view and pay invoices. Employees can change and reset their password. Employees' login ID is their employee number.

 
	The system has various automated functions. It should auto-remind customers about upcoming jobs. It should also notify managers when quotes are approved, jobs are completed, invoices are paid, and time off is requested. The system should create a new timesheet when a pay period finishes. When a timesheet is no longer current, it cannot be edited.

 
End Users:
Casual Users: Owners/Managers
Naïve Users: Owners/Managers, Employees, and Customers
Sophisticated Users: Joel Wagner
Database Administrator: Addison Boyer
Database Designer: Joel Wagner


# Assumptions Made for ER Diagram
-	SERVICE only stores the name of one of the high-level services and a particular high-level service is reused on QUOTE, JOB, and INVOICE. These high-level services are simply the generic services the company offers and are not entity specific. However, each referencing entity has a particular price and potentially other information about the high-level service on that particular instance of the entity. These are the relationship attributes that are specific to the quote, job, or invoice in combination with that particular service. I chose this approach because it allows a business to easily add a new service without having to change the entire database schema. It also prevents wasted space by not having to store used high-level services on the QUOTE, JOB, or INVOICE entities.

-	DAY_AVAL and DAY_WORKED are modeled as entities rather than attributes because it saves space and prevents null values. If they were modeled as entities, there would be 14 additional attributes for EMPLOYEE and 28 additional attributes for TIMESHEET. Many of these may very well have null values since an employee may only work a couple of days in a pay period or only be available a couple of days a week.  In this case, most of these attributes would just be a waste of space. By using a weak entity, an instance of a day is only created and stored if there are actual data values to put in for start and end time. The DAYS are identified by a day_number which is 1-7 for availability and 1-14 for timesheet. If a particular day number does have a corresponding DAY entity instance, then it must mean that either the employee is not available to work that day or the employee did not work any hours that day depending on the use case. Modeled the data this way prevents wasted space and null values.
-	I separated the DAY entity into two entities for either employee availability or timesheet because if it was one then it would have two identifying relationships, and each must have total participation. This does not make sense because a particular instance of the DAY entity should not participate in both a relationship to timesheet and a relationship employee at the same time. It must either participate in one or the other.
-	Employee availability is not its own entity because the only information it would have been an owning relationship to DAY_AVAL and an identifying relationship to EMPLOYEE. This does not make sense since there is no additional entity specific information so availability can be better modeled as a relationship between weak entity DAY_AVAL and EMPLOYEE with 0 to 7 instances.
-	TIMEOFF, DAY_AVAL, and TIMESHEET are all modeled as weak entity types because they do not make sense apart from a relationship to EMPLOYEE. I could include some generic unique attribute for each of these; however, none of these entities make any sense apart from their relationship to EMPLOYEE. This is why they are weak entities.
-	DAY_WORKED is modeled as a weak entity because it does not make sense apart from its relationship to TIMESHEET. The only way an instance DAY_WORKED makes sense is through its relationship to an instance of TIMESHEET.
