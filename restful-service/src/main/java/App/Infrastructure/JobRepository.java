package App.Infrastructure;

import App.Domain.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JobRepository implements IJobRepository {
    private JdbcTemplate databaseConnection;

    @Override
    public void setDatabaseConnection(JdbcTemplate databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Job create(Job job) {
        int jobId;
        if (job.getJobCompleted()) {
            String sql = "INSERT INTO jw193055.JOB (Job_date, Job_time, Street_address, City, State, Zip_code, Job_completed, Job_employee_note, Job_customer_note, Customer_id)\nVALUES ('"
                    + job.getJobDate() + "', '" + job.getJobTime() + "',  '" + job.getStreetAddress() + "', '"
                    + job.getCity() + "', '" + job.getState() + "', '" + job.getZipCode() + "', 1, '"
                    + job.getJobEmployeeNote() + "', '" + job.getJobCustomerNote() + "', "
                    + job.getCustomer().getCustomerId() + ");\nSELECT SCOPE_IDENTITY();";
            jobId = this.databaseConnection.queryForObject(sql, int.class);
        } else {
            String sql = "INSERT INTO jw193055.JOB (Job_date, Job_time, Street_address, City, State, Zip_code, Job_completed, Job_employee_note, Job_customer_note, Customer_id)\nVALUES ('"
                    + job.getJobDate() + "', '" + job.getJobTime() + "',  '" + job.getStreetAddress() + "', '"
                    + job.getCity() + "', '" + job.getState() + "', '" + job.getZipCode() + "', 0, '"
                    + job.getJobEmployeeNote() + "', '" + job.getJobCustomerNote() + "', "
                    + job.getCustomer().getCustomerId() + ");\nSELECT SCOPE_IDENTITY();";
            jobId = this.databaseConnection.queryForObject(sql, int.class);
        }
        for (ServicePrice servicePrice : job.getServices()) {
            String sql = "INSERT INTO jw193055.COMPLETES\nVALUES (" + jobId + ", '" + servicePrice.getServiceName()
                    + "', " + servicePrice.getServicePrice() + ");";
            this.databaseConnection.execute(sql);
        }
        for (SpecialEquipUses specialEquipUses : job.getSpecialEquipUses()) {
            String sql = "INSERT INTO jw193055.USES\nVALUES (" + jobId + ", " + specialEquipUses.getEquipId() + ", "
                    + specialEquipUses.getEquipAmount() + ");";
            this.databaseConnection.execute(sql);
        }
        return job;
    }

    @Override
    public int update(int id, Job job) {
        int rows;
        if (job.getJobCompleted()) {
            String sql = "UPDATE jw193055.JOB\nSET Job_date = '" + job.getJobDate() + "', Job_time = '"
                    + job.getJobTime()
                    + "', Street_address = '" + job.getStreetAddress() + "', City = '" + job.getCity() + "', State = '"
                    + job.getState() + "', Zip_code = '" + job.getZipCode()
                    + "', Job_completed = 1, Job_employee_note = '"
                    + job.getJobEmployeeNote() + "', Job_customer_note = '" + job.getJobCustomerNote()
                    + "'\nWHERE Job_id = " + id + ";";
            rows = this.databaseConnection.update(sql);
        } else {
            String sql = "UPDATE jw193055.JOB\nSET Job_date = '" + job.getJobDate() + "', Job_time = '"
                    + job.getJobTime()
                    + "', Street_address = '" + job.getStreetAddress() + "', City = '" + job.getCity() + "', State = '"
                    + job.getState() + "', Zip_code = '" + job.getZipCode()
                    + "', Job_completed = 0, Job_employee_note = '"
                    + job.getJobEmployeeNote() + "', Job_customer_note = '" + job.getJobCustomerNote()
                    + "'\nWHERE Job_id = " + id + ";";
            rows = this.databaseConnection.update(sql);
        }
        for (ServicePrice servicePrice : job.getServices()) {
            String sql = "UPDATE jw193055.COMPLETES\nSET Service_price = " + servicePrice.getServicePrice()
                    + "\nWHERE Job_id = " + id + " AND Service_Name = '" + servicePrice.getServiceName() + "';";
            rows += this.databaseConnection.update(sql);
        }
        for (SpecialEquipUses specialEquipUses : job.getSpecialEquipUses()) {
            String sql = "UPDATE jw193055.USES\nSET Equip_amount = " + specialEquipUses.getEquipAmount()
                    + "\nWHERE Job_id = " + id + " AND Equip_id = " + specialEquipUses.getEquipId() + ";";
            rows += this.databaseConnection.update(sql);
        }

        return rows;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM jw193055.JOB WHERE Job_id = " + id + ";";
        this.databaseConnection.execute(sql);
        return true;
    }

    @Override
    public List<Job> get(int id) {
        String sql = "SELECT J.Job_id, J.Job_date, J.Job_time, J.Street_address, J.City, J.State, J.Zip_code, J.Job_completed, J.Job_employee_note, J.Job_customer_note, C.Customer_id, C.Customer_first_name, C.Customer_last_name, C.Street_address AS BillingStreetAddress, C.City AS BillingCity, C.State AS BillingState, C.Zip_code AS BillingZipCode, C.Customer_phone_num, C.Customer_email\nFROM (jw193055.JOB AS J INNER JOIN jw193055.CUSTOMER AS C ON J.Customer_id = C.Customer_id)\nWHERE J.Job_id = "
                + id + ";";
        List<Job> jobs = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Job.class));
        for (Job job : jobs) {
            sql = "SELECT * FROM jw193055.COMPLETES WHERE Job_id = " + job.getJobId() + ";";
            List<ServicePrice> services = this.databaseConnection.query(sql,
                    BeanPropertyRowMapper.newInstance(ServicePrice.class));
            job.setService(services);

            sql = "SELECT E.Equip_id, E.Equip_name, U.Equip_amount, E.Equip_price\nFROM (jw193055.USES AS U  INNER JOIN jw193055.SPECIAL_EQUIP AS E ON U.Equip_id = E.Equip_id)\nWHERE U.Job_id = "
                    + job.getJobId() + ";";
            List<SpecialEquipUses> specialEquipUses = this.databaseConnection.query(sql,
                    BeanPropertyRowMapper.newInstance(SpecialEquipUses.class));
            job.setSpecialEquipUses(specialEquipUses);
        }
        return jobs;
    }

    @Override
    public List<Job> get() {
        String sql = "SELECT J.Job_id, J.Job_date, J.Job_time, J.Street_address, J.City, J.State, J.Zip_code, J.Job_completed, J.Job_employee_note, J.Job_customer_note, C.Customer_id, C.Customer_first_name, C.Customer_last_name, C.Street_address AS BillingStreetAddress, C.City AS BillingCity, C.State AS BillingState, C.Zip_code AS BillingZipCode, C.Customer_phone_num, C.Customer_email\nFROM (jw193055.JOB AS J INNER JOIN jw193055.CUSTOMER AS C ON J.Customer_id = C.Customer_id);";
        List<Job> jobs = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Job.class));
        for (Job job : jobs) {
            sql = "SELECT * FROM jw193055.COMPLETES WHERE Job_id = " + job.getJobId() + ";";
            List<ServicePrice> services = this.databaseConnection.query(sql,
                    BeanPropertyRowMapper.newInstance(ServicePrice.class));
            job.setService(services);

            sql = "SELECT E.Equip_id, E.Equip_name, U.Equip_amount, E.Equip_price\nFROM (jw193055.USES AS U  INNER JOIN jw193055.SPECIAL_EQUIP AS E ON U.Equip_id = E.Equip_id)\nWHERE U.Job_id = "
                    + job.getJobId() + ";";
            List<SpecialEquipUses> specialEquipUses = this.databaseConnection.query(sql,
                    BeanPropertyRowMapper.newInstance(SpecialEquipUses.class));
            job.setSpecialEquipUses(specialEquipUses);
        }
        return jobs;
    }

    public List<Job> get(String year, String month, String day) {
        String sql = "SELECT J.Job_id, J.Job_date, J.Job_time, J.Street_address, J.City, J.State, J.Zip_code, J.Job_completed, J.Job_employee_note, J.Job_customer_note, C.Customer_id, C.Customer_first_name, C.Customer_last_name, C.Street_address AS BillingStreetAddress, C.City AS BillingCity, C.State AS BillingState, C.Zip_code AS BillingZipCode, C.Customer_phone_num, C.Customer_email\nFROM (jw193055.JOB AS J INNER JOIN jw193055.CUSTOMER AS C ON J.Customer_id = C.Customer_id)\nWHERE J.Job_date = '"
                + year + "-" + month + "-" + day + "';";
        List<Job> jobs = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Job.class));
        for (Job job : jobs) {
            sql = "SELECT * FROM jw193055.COMPLETES WHERE Job_id = " + job.getJobId() + ";";
            List<ServicePrice> services = this.databaseConnection.query(sql,
                    BeanPropertyRowMapper.newInstance(ServicePrice.class));
            job.setService(services);

            sql = "SELECT E.Equip_id, E.Equip_name, U.Equip_amount, E.Equip_price\nFROM (jw193055.USES AS U  INNER JOIN jw193055.SPECIAL_EQUIP AS E ON U.Equip_id = E.Equip_id)\nWHERE U.Job_id = "
                    + job.getJobId() + ";";
            List<SpecialEquipUses> specialEquipUses = this.databaseConnection.query(sql,
                    BeanPropertyRowMapper.newInstance(SpecialEquipUses.class));
            job.setSpecialEquipUses(specialEquipUses);
        }
        return jobs;
    }

    public List<Job> get(String firstName, String lastName) {
        String sql = "SELECT J.Job_id, J.Job_date, J.Job_time, J.Street_address, J.City, J.State, J.Zip_code, J.Job_completed, J.Job_employee_note, J.Job_customer_note, C.Customer_id, C.Customer_first_name, C.Customer_last_name, C.Street_address AS BillingStreetAddress, C.City AS BillingCity, C.State AS BillingState, C.Zip_code AS BillingZipCode, C.Customer_phone_num, C.Customer_email\nFROM (jw193055.JOB AS J INNER JOIN jw193055.CUSTOMER AS C ON J.Customer_id = C.Customer_id)\nWHERE C.Customer_first_name = '"
                + firstName + "' AND C.Customer_last_name = '" + lastName + "';";
        List<Job> jobs = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Job.class));
        for (Job job : jobs) {
            sql = "SELECT * FROM jw193055.COMPLETES WHERE Job_id = " + job.getJobId() + ";";
            List<ServicePrice> services = this.databaseConnection.query(sql,
                    BeanPropertyRowMapper.newInstance(ServicePrice.class));
            job.setService(services);

            sql = "SELECT E.Equip_id, E.Equip_name, U.Equip_amount, E.Equip_price\nFROM (jw193055.USES AS U  INNER JOIN jw193055.SPECIAL_EQUIP AS E ON U.Equip_id = E.Equip_id)\nWHERE U.Job_id = "
                    + job.getJobId() + ";";
            List<SpecialEquipUses> specialEquipUses = this.databaseConnection.query(sql,
                    BeanPropertyRowMapper.newInstance(SpecialEquipUses.class));
            job.setSpecialEquipUses(specialEquipUses);
        }
        return jobs;
    }

}
