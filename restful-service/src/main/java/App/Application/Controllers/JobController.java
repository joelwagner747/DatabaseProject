package App.Application.Controllers;

import App.Domain.Job;
import App.Infrastructure.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/Job")
public class JobController {

    @Autowired
    private JdbcTemplate databaseConnection;

    private JobRepository jobRepository;

    public JobController() {
        this.jobRepository = new JobRepository();
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Job> get() {
        this.jobRepository.setDatabaseConnection(databaseConnection);
        return this.jobRepository.get();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Job> get(@PathVariable("id") int id) {
        this.jobRepository.setDatabaseConnection(databaseConnection);
        return this.jobRepository.get(id);
    }

    @GetMapping("/{year}/{month}/{day}")
    @ResponseStatus(HttpStatus.OK)
    public List<Job> get(@PathVariable("year") String year, @PathVariable("month") String month,
            @PathVariable("day") String day) {
        this.jobRepository.setDatabaseConnection(databaseConnection);
        return this.jobRepository.get(year, month, day);
    }

    @GetMapping("/{firstName}/{lastName}")
    @ResponseStatus(HttpStatus.OK)
    public List<Job> get(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        this.jobRepository.setDatabaseConnection(databaseConnection);
        return this.jobRepository.get(firstName, lastName);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody() Job historyToSave) {
        this.jobRepository.setDatabaseConnection(databaseConnection);
        this.jobRepository.create(historyToSave);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void put(@RequestBody() Job historyToUpdate, @PathVariable("id") int id) {
        this.jobRepository.setDatabaseConnection(databaseConnection);
        this.jobRepository.update(id, historyToUpdate);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        this.jobRepository.setDatabaseConnection(databaseConnection);
        this.jobRepository.delete(id);
    }

}
