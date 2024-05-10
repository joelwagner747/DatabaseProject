package App.Application.Controllers;

import App.Domain.Invoice;
import App.Infrastructure.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/Invoice")
public class InvoiceController {

    @Autowired
    private JdbcTemplate databaseConnection;

    private InvoiceRepository invoiceRepository;

    public InvoiceController() {
        this.invoiceRepository = new InvoiceRepository();
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> get() {
        this.invoiceRepository.setDatabaseConnection(databaseConnection);
        return this.invoiceRepository.get();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> get(@PathVariable("id") int id) {
        this.invoiceRepository.setDatabaseConnection(databaseConnection);
        return this.invoiceRepository.get(id);
    }

    @GetMapping("/{year}/{month}/{day}")
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> get(@PathVariable("year") String year, @PathVariable("month") String month,
            @PathVariable("day") String day) {
        this.invoiceRepository.setDatabaseConnection(databaseConnection);
        return this.invoiceRepository.get(year, month, day);
    }

    @GetMapping("/{firstName}/{lastName}")
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> get(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        this.invoiceRepository.setDatabaseConnection(databaseConnection);
        return this.invoiceRepository.get(firstName, lastName);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody() Invoice historyToSave) {
        this.invoiceRepository.setDatabaseConnection(databaseConnection);
        this.invoiceRepository.create(historyToSave);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void put(@RequestBody() Invoice historyToUpdate, @PathVariable("id") int id) {
        this.invoiceRepository.setDatabaseConnection(databaseConnection);
        this.invoiceRepository.update(id, historyToUpdate);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        this.invoiceRepository.setDatabaseConnection(databaseConnection);
        this.invoiceRepository.delete(id);
    }

}
