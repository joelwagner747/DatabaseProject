package App.Infrastructure;

import App.Domain.*;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class InvoiceRepository implements IInvoiceRepository {
    private JdbcTemplate databaseConnection;

    @Override
    public void setDatabaseConnection(JdbcTemplate databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Invoice create(Invoice invoice) {
        int invoiceId;
        if (invoice.getInvoicePaid()) {
            String sql = "INSERT INTO jw193055.INVOICE (Street_address, City, State, Zip_code, Invoice_date, Invoice_paid, Customer_id)\nVALUES ('"
                    + invoice.getStreetAddress() + "', '" + invoice.getCity() + "', '" + invoice.getState() + "', '"
                    + invoice.getZipCode() + "', '" + invoice.getInvoiceDate() + "', 1, '"
                    + invoice.getCustomer().getCustomerId() + "');\nSELECT SCOPE_IDENTITY();";
            invoiceId = this.databaseConnection.queryForObject(sql, int.class);
        } else {
            String sql = "INSERT INTO jw193055.INVOICE (Street_address, City, State, Zip_code, Invoice_date, Invoice_paid, Customer_id)\nVALUES ('"
                    + invoice.getStreetAddress() + "', '" + invoice.getCity() + "', '" + invoice.getState() + "', '"
                    + invoice.getZipCode() + "', '" + invoice.getInvoiceDate() + "', 0, '"
                    + invoice.getCustomer().getCustomerId() + "');\nSELECT SCOPE_IDENTITY();";
            invoiceId = this.databaseConnection.queryForObject(sql, int.class);
        }
        for (ServicePrice servicePrice : invoice.getServicesCompleted()) {
            String sql = "INSERT INTO jw193055.PREFORMED\nVALUES (" + invoiceId + ", '" + servicePrice.getServiceName()
                    + "', " + servicePrice.getServicePrice() + ");";
            this.databaseConnection.execute(sql);
        }

        return invoice;
    }

    @Override
    public int update(int id, Invoice invoice) {
        int rows;
        if (invoice.getInvoicePaid()) {
            String sql = "UPDATE jw193055.INVOICE\nSET Street_address = '" + invoice.getStreetAddress() + "', City = '"
                    + invoice.getCity() + "', State = '" + invoice.getState() + "', Zip_code = '" + invoice.getZipCode()
                    + "', Invoice_date = '" + invoice.getInvoiceDate() + "', Invoice_paid = 1\nWHERE Invoice_id = " + id
                    + ";";
            rows = this.databaseConnection.update(sql);
        } else {
            String sql = "UPDATE jw193055.INVOICE\nSET Street_address = '" + invoice.getStreetAddress() + "', City = '"
                    + invoice.getCity() + "', State = '" + invoice.getState() + "', Zip_code = '" + invoice.getZipCode()
                    + "', Invoice_date = '" + invoice.getInvoiceDate() + "', Invoice_paid = 0\nWHERE Invoice_id = " + id
                    + ";";
            rows = this.databaseConnection.update(sql);
        }
        for (ServicePrice servicePrice : invoice.getServicesCompleted()) {
            String sql = "UPDATE jw193055.PREFORMED\n SET Service_price = " + servicePrice.getServicePrice()
                    + "\nWHERE Invoice_id = " + id + " AND Service_Name = '" + servicePrice.getServiceName() + "';";
            rows += this.databaseConnection.update(sql);
        }
        return rows;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM jw193055.INVOICE WHERE Invoice_id = " + id + ";";
        this.databaseConnection.execute(sql);
        return true;
    }

    @Override
    public List<Invoice> get(int id) {
        String sql = "SELECT I.Invoice_id, I.Street_address, I.City, I.State, I.Zip_code, I.Invoice_date, I.Invoice_paid, C.Customer_id, C.Customer_first_name, C.Customer_last_name, C.Street_address AS BillingStreetAddress, C.City AS BillingCity, C.State AS BillingState, C.Zip_code AS BillingZipCode, C.Customer_phone_num, C.Customer_email\nFROM (jw193055.INVOICE AS I INNER JOIN jw193055.CUSTOMER AS C ON I.Customer_id = C.Customer_id)\nWHERE I.Invoice_id = "
                + id + ";";
        List<Invoice> invoices = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Invoice.class));
        for (Invoice invoice : invoices) {
            sql = "SELECT * FROM jw193055.PREFORMED WHERE Invoice_id = " + invoice.getInvoiceId() + ";";
            List<ServicePrice> services = this.databaseConnection.query(sql,
                    BeanPropertyRowMapper.newInstance(ServicePrice.class));
            invoice.setServicesCompleted(services);
        }
        return invoices;
    }

    @Override
    public List<Invoice> get() {
        String sql = "SELECT I.Invoice_id, I.Street_address, I.City, I.State, I.Zip_code, I.Invoice_date, I.Invoice_paid, C.Customer_id, C.Customer_first_name, C.Customer_last_name, C.Street_address AS BillingStreetAddress, C.City AS BillingCity, C.State AS BillingState, C.Zip_code AS BillingZipCode, C.Customer_phone_num, C.Customer_email\nFROM (jw193055.INVOICE AS I INNER JOIN jw193055.CUSTOMER AS C ON I.Customer_id = C.Customer_id);";
        List<Invoice> invoices = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Invoice.class));
        for (Invoice invoice : invoices) {
            sql = "SELECT * FROM jw193055.PREFORMED WHERE Invoice_id = " + invoice.getInvoiceId() + ";";
            List<ServicePrice> services = this.databaseConnection.query(sql,
                    BeanPropertyRowMapper.newInstance(ServicePrice.class));
            invoice.setServicesCompleted(services);
        }
        return invoices;
    }

    public List<Invoice> get(String year, String month, String day) {
        String sql = "SELECT I.Invoice_id, I.Street_address, I.City, I.State, I.Zip_code, I.Invoice_date, I.Invoice_paid, C.Customer_id, C.Customer_first_name, C.Customer_last_name, C.Street_address AS BillingStreetAddress, C.City AS BillingCity, C.State AS BillingState, C.Zip_code AS BillingZipCode, C.Customer_phone_num, C.Customer_email\nFROM (jw193055.INVOICE AS I INNER JOIN jw193055.CUSTOMER AS C ON I.Customer_id = C.Customer_id)\nWHERE I.Invoice_date = '"
                + year + "-" + month + "-" + day + "';";
        List<Invoice> invoices = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Invoice.class));
        for (Invoice invoice : invoices) {
            sql = "SELECT * FROM jw193055.PREFORMED WHERE Invoice_id = " + invoice.getInvoiceId() + ";";
            List<ServicePrice> services = this.databaseConnection.query(sql,
                    BeanPropertyRowMapper.newInstance(ServicePrice.class));
            invoice.setServicesCompleted(services);
        }
        return invoices;
    }

    public List<Invoice> get(String firstName, String lastName) {
        String sql = "SELECT I.Invoice_id, I.Street_address, I.City, I.State, I.Zip_code, I.Invoice_date, I.Invoice_paid, C.Customer_id, C.Customer_first_name, C.Customer_last_name, C.Street_address AS BillingStreetAddress, C.City AS BillingCity, C.State AS BillingState, C.Zip_code AS BillingZipCode, C.Customer_phone_num, C.Customer_email\nFROM (jw193055.INVOICE AS I INNER JOIN jw193055.CUSTOMER AS C ON I.Customer_id = C.Customer_id)\nWHERE C.Customer_first_name = '"
                + firstName + "' AND C.Customer_last_name = '" + lastName + "';";
        List<Invoice> invoices = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Invoice.class));
        for (Invoice invoice : invoices) {
            sql = "SELECT * FROM jw193055.PREFORMED WHERE Invoice_id = " + invoice.getInvoiceId() + ";";
            List<ServicePrice> services = this.databaseConnection.query(sql,
                    BeanPropertyRowMapper.newInstance(ServicePrice.class));
            invoice.setServicesCompleted(services);
        }
        return invoices;
    }

}
