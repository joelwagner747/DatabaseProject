package App.Application.Controllers;

import App.Domain.Quote;
import App.Domain.ServiceQuote;
import App.Infrastructure.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/Quote")
public class QuoteController {

    @Autowired
    private JdbcTemplate databaseConnection;

    private QuoteRepository quoteRepository;

    public QuoteController() {
        this.quoteRepository = new QuoteRepository();
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Quote> get() {
        this.quoteRepository.setDatabaseConnection(databaseConnection);
        return this.quoteRepository.get();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Quote> get(@PathVariable("id") int id) {
        this.quoteRepository.setDatabaseConnection(databaseConnection);
        return this.quoteRepository.get(id);
    }

    @GetMapping("/{firstName}/{lastName}")
    @ResponseStatus(HttpStatus.OK)
    public List<Quote> get(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        this.quoteRepository.setDatabaseConnection(databaseConnection);
        return this.quoteRepository.get(firstName, lastName);
    }

    @PostMapping("/")
    public ResponseEntity<?> post(@RequestBody() Quote historyToSave) {
        if (statusIsCorrect(historyToSave)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Services can not be approved if the Quote has not have a state of Approved");
        }
        this.quoteRepository.setDatabaseConnection(databaseConnection);
        this.quoteRepository.create(historyToSave);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@RequestBody() Quote historyToUpdate, @PathVariable("id") int id) {
        if (statusIsCorrect(historyToUpdate)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Services can not be approved if the Quote has not have a state of Approved");
        }
        this.quoteRepository.setDatabaseConnection(databaseConnection);
        this.quoteRepository.update(id, historyToUpdate);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        this.quoteRepository.setDatabaseConnection(databaseConnection);
        this.quoteRepository.delete(id);
    }

    private boolean statusIsCorrect(Quote quote) {
        if (quote.getQuoteState().equals("Pending")) {
            for (ServiceQuote serviceQuote : quote.getServiceQuotes()) {
                if (serviceQuote.getServiceApproved()) {
                    return true;
                }
            }
        }
        if (quote.getQuoteState().equals("Rejected")) {
            for (ServiceQuote serviceQuote : quote.getServiceQuotes()) {
                if (serviceQuote.getServiceApproved()) {
                    return true;
                }
            }
        }
        return false;
    }

}
