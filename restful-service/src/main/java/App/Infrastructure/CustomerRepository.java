package App.Infrastructure;

import App.Domain.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {

    private JdbcTemplate databaseConnection;

    @Override
    public void setDatabaseConnection(JdbcTemplate databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Customer create(Customer customer) {
        String sql = "INSERT INTO jw193055.CUSTOMER\nValues ('" + customer.getCustomerFirstName() + "', '"
                + customer.getCustomerLastName() + "', '" + customer.getStreetAddress() + "', '" + customer.getCity()
                + "', '" + customer.getState() + "', '" + customer.getZipCode() + "', '"
                + customer.getCustomerPhoneNum() + "', '" + customer.getCustomerEmail() + "');";
        this.databaseConnection.execute(sql);
        return customer;
    }

    @Override
    public int update(int id, Customer customer) {
        String sql = "UPDATE jw193055.CUSTOMER\nSET Customer_first_name = '" + customer.getCustomerFirstName()
                + "', Customer_last_name = '"
                + customer.getCustomerLastName() + "', Street_address = '" + customer.getStreetAddress()
                + "', City = '" + customer.getCity() + "', State = '" + customer.getState() + "', Zip_code = '"
                + customer.getZipCode() + "', Customer_phone_num = '" + customer.getCustomerPhoneNum()
                + "', Customer_email = '" + customer.getCustomerEmail() + "'\nWHERE Customer_id = " + id + ";";
        int rows = this.databaseConnection.update(sql);
        return rows;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM jw193055.CUSTOMER WHERE Customer_id = " + id + ";";
        this.databaseConnection.execute(sql);
        return true;
    }

    @Override
    public List<Customer> get() {
        String sql = "SELECT * FROM jw193055.CUSTOMER\nORDER BY Customer_last_name, Customer_first_name ASC;";
        List<Customer> customers = this.databaseConnection.query(sql,
                BeanPropertyRowMapper.newInstance(Customer.class));
        return customers;
    }

    @Override
    public List<Customer> get(int id) {
        String sql = "SELECT * FROM jw193055.CUSTOMER AS C WHERE C.Customer_id = '" + id + "';";
        List<Customer> customers = this.databaseConnection.query(sql,
                BeanPropertyRowMapper.newInstance(Customer.class));
        return customers;
    }

    public List<Customer> get(String firstName, String lastName) {
        String sql = "SELECT * FROM jw193055.CUSTOMER AS C WHERE C.Customer_first_name = '" + firstName
                + "' AND C.Customer_last_name = '" + lastName
                + "'\n;";
        List<Customer> customers = this.databaseConnection.query(sql,
                BeanPropertyRowMapper.newInstance(Customer.class));
        return customers;
    }

}
