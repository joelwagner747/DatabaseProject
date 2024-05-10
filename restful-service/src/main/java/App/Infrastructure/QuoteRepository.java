package App.Infrastructure;

import App.Domain.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class QuoteRepository implements IQuoteRepository {

    private JdbcTemplate databaseConnection;

    @Override
    public void setDatabaseConnection(JdbcTemplate databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Quote create(Quote quote) {
        String sql = "SELECT * FROM jw193055.CUSTOMER WHERE Customer_id = " + quote.getCustomer().getCustomerId() + ";";
        List<Customer> existingCustomer = this.databaseConnection.query(sql,
                BeanPropertyRowMapper.newInstance(Customer.class));
        int customerId = quote.getCustomer().getCustomerId();
        if (existingCustomer.size() == 0) {
            Customer customer = quote.getCustomer();
            sql = "INSERT INTO jw193055.CUSTOMER\nValues ('" + customer.getCustomerFirstName() + "', '"
                    + customer.getCustomerLastName() + "', '" + customer.getStreetAddress() + "', '"
                    + customer.getCity() + "', '" + customer.getState() + "', '" + customer.getZipCode() + "', '"
                    + customer.getCustomerPhoneNum() + "', '" + customer.getCustomerEmail()
                    + "');\nSELECT SCOPE_IDENTITY();";
            customerId = this.databaseConnection.queryForObject(sql, int.class);
        }

        sql = "INSERT INTO jw193055.QUOTE (Street_address, City, State, Zip_code,Quote_state, Start_available, End_available, Quote_employee_note, Quote_customer_note, Customer_id)\nVALUES ('"
                + quote.getStreetAddress() + "', '" + quote.getCity()
                + "', '" + quote.getState() + "', '" + quote.getZipCode() + "', '" + quote.getQuoteState() + "', '"
                + quote.getStartAvailable() + "', '" + quote.getEndAvailable() + "', '" + quote.getQuoteEmployeeNote()
                + "', '" + quote.getQuoteCustomerNote() + "', " + customerId
                + ");\nSELECT SCOPE_IDENTITY();";

        int quoteId = this.databaseConnection.queryForObject(sql, int.class);

        for (ServiceQuote serviceQuotes : quote.getServiceQuotes()) {
            if (serviceQuotes.getServiceApproved()) {
                sql = "INSERT INTO jw193055.QUOTED\nVALUES (" + quoteId + ", '" + serviceQuotes.getServiceName() + "', "
                        + serviceQuotes.getServicePrice() + ", 1);";
                this.databaseConnection.execute(sql);
            } else {
                sql = "INSERT INTO jw193055.QUOTED\nVALUES (" + quoteId + ", '" + serviceQuotes.getServiceName() + "', "
                        + serviceQuotes.getServicePrice() + ", 0);";
                this.databaseConnection.execute(sql);
            }
        }
        return quote;

    }

    @Override
    public int update(int id, Quote quote) {
        String sql = "UPDATE jw193055.QUOTE\nSET Street_address = '" + quote.getStreetAddress() + "', City = '"
                + quote.getCity() + "', State = '" + quote.getState() + "', Zip_code = '" + quote.getZipCode()
                + "', Quote_state = '" + quote.getQuoteState() + "', Start_available = '" + quote.getStartAvailable()
                + "', End_available = '" + quote.getEndAvailable() + "', Quote_employee_note = '"
                + quote.getQuoteEmployeeNote() + "', Quote_customer_note = '" + quote.getQuoteCustomerNote()
                + "'\nWHERE Quote_id = " + id + ";";
        int rows = this.databaseConnection.update(sql);
        for (ServiceQuote serviceQuote : quote.getServiceQuotes()) {
            if (serviceQuote.getServiceApproved()) {
                sql = "UPDATE jw193055.QUOTED\nSET Service_price = "
                        + serviceQuote.getServicePrice() + ", Service_approved = 1\nWHERE Quote_id = " + id
                        + " AND Service_name = '" + serviceQuote.getServiceName() + "';";
                rows += this.databaseConnection.update(sql);
            } else {
                sql = "UPDATE jw193055.QUOTED\nSET Service_name = '" + serviceQuote.getServiceName()
                        + "', Service_price = "
                        + serviceQuote.getServicePrice() + ", Service_approved = 0\nWHERE Quote_id = " + id
                        + " AND Service_name = '" + serviceQuote.getServiceName() + "';";
                rows += this.databaseConnection.update(sql);
            }
        }
        return rows;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM jw193055.QUOTE WHERE Quote_id = " + id + ";";
        this.databaseConnection.execute(sql);
        return true;
    }

    @Override
    public List<Quote> get(int id) {
        String sql = "SELECT Q.Quote_id, Q.Street_address, Q.City, Q.State, Q.Zip_code, Q.Quote_state, Q.Date_of_creation, Q.Start_available, Q.End_available, Q.Quote_employee_note, Q.Quote_customer_note, C.Customer_id, C.Customer_first_name, C.Customer_last_name, C.Street_address AS BillingStreetAddress, C.City AS BillingCity, C.State AS BillingState, C.Zip_code AS BillingZipCode, C.Customer_phone_num, C.Customer_email\nFROM (jw193055.QUOTE AS Q JOIN jw193055.CUSTOMER AS C ON Q.Customer_id = C.Customer_id)\nWHERE Q.Quote_id = "
                + id + ";";
        List<Quote> quotes = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Quote.class));
        for (Quote quote : quotes) {
            sql = "SELECT * FROM jw193055.QUOTED WHERE Quote_id = " + quote.getQuoteId() + ";";
            List<ServiceQuote> serviceQuotes = this.databaseConnection.query(sql,
                    BeanPropertyRowMapper.newInstance(ServiceQuote.class));
            quote.setServiceQuotes(serviceQuotes);
        }
        return quotes;
    }

    public List<Quote> get(String firstName, String lastName) {
        String sql = "SELECT Q.Quote_id, Q.Street_address, Q.City, Q.State, Q.Zip_code, Q.Quote_state, Q.Date_of_creation, Q.Start_available, Q.End_available, Q.Quote_employee_note, Q.Quote_customer_note, C.Customer_id, C.Customer_first_name, C.Customer_last_name, C.Street_address AS BillingStreetAddress, C.City AS BillingCity, C.State AS BillingState, C.Zip_code AS BillingZipCode, C.Customer_phone_num, C.Customer_email\nFROM (jw193055.QUOTE AS Q JOIN jw193055.CUSTOMER AS C ON Q.Customer_id = C.Customer_id)\nWHERE C.Customer_first_name = '"
                + firstName + "' AND C.Customer_last_name = '" + lastName + "';";
        List<Quote> quotes = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Quote.class));
        for (Quote quote : quotes) {
            sql = "SELECT * FROM jw193055.QUOTED WHERE Quote_id = " + quote.getQuoteId() + ";";
            List<ServiceQuote> serviceQuotes = this.databaseConnection.query(sql,
                    BeanPropertyRowMapper.newInstance(ServiceQuote.class));
            quote.setServiceQuotes(serviceQuotes);
        }
        return quotes;
    }

    @Override
    public List<Quote> get() {
        String sql = "SELECT Q.Quote_id, Q.Street_address, Q.City, Q.State, Q.Zip_code, Q.Quote_state, Q.Date_of_creation, Q.Start_available, Q.End_available, Q.Quote_employee_note, Q.Quote_customer_note, C.Customer_id, C.Customer_first_name, C.Customer_last_name, C.Street_address AS BillingStreetAddress, C.City AS BillingCity, C.State AS BillingState, C.Zip_code AS BillingZipCode, C.Customer_phone_num, C.Customer_email\nFROM (jw193055.QUOTE AS Q JOIN jw193055.CUSTOMER AS C ON Q.Customer_id = C.Customer_id);";
        List<Quote> quotes = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Quote.class));
        for (Quote quote : quotes) {
            sql = "SELECT * FROM jw193055.QUOTED WHERE Quote_id = " + quote.getQuoteId() + ";";
            List<ServiceQuote> serviceQuotes = this.databaseConnection.query(sql,
                    BeanPropertyRowMapper.newInstance(ServiceQuote.class));
            quote.setServiceQuotes(serviceQuotes);
        }
        return quotes;
    }
}
