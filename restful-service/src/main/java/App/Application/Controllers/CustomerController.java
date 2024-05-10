package App.Application.Controllers;

import App.Domain.Customer;
import App.Infrastructure.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/Customer")
public class CustomerController {

    @Autowired
    private JdbcTemplate databaseConnection;

    private CustomerRepository customerRepository;

    public CustomerController() {
        this.customerRepository = new CustomerRepository();
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> get() {
        this.customerRepository.setDatabaseConnection(this.databaseConnection);
        return this.customerRepository.get();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> get(@PathVariable("id") int id) {
        this.customerRepository.setDatabaseConnection(databaseConnection);
        return this.customerRepository.get(id);
    }

    @GetMapping("/{firstName}/{lastName}")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> get(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        this.customerRepository.setDatabaseConnection(databaseConnection);
        return this.customerRepository.get(firstName, lastName);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody() Customer historyToSave) {
        this.customerRepository.setDatabaseConnection(databaseConnection);
        this.customerRepository.create(historyToSave);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void put(@RequestBody() Customer historyToUpdate, @PathVariable("id") int id) {
        this.customerRepository.setDatabaseConnection(databaseConnection);
        this.customerRepository.update(id, historyToUpdate);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        this.customerRepository.setDatabaseConnection(databaseConnection);
        this.customerRepository.delete(id);
    }

}
