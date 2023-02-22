package techmaster.vn.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.web.bind.annotation.*;
import techmaster.vn.homework.entity.Job;
import techmaster.vn.homework.request.UpSertJobRequest;
import techmaster.vn.homework.service.JobService;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/v1")
public class JobController {
    @Autowired
    private JobService jobService;

    //find all
    @GetMapping("/jobs")
    public List<Job> getAllJob() {
        return jobService.findAll();
    }

    //find by id
    @GetMapping("/jobs/{id}")
    public Job findJobById(@PathVariable("id") String id) {
        return jobService.findJobById(id);
    }

    // find random
    @GetMapping("/jobs/random")
    public Job findRandomJob() {
        return jobService.findRandomJob();
    }

    // find with sorting
    @GetMapping("/sort")
    public List<Job> findWithSort(
            @RequestParam(value = "field", defaultValue = "maxSalary") String field,
            @RequestParam(value = "direction", defaultValue = "DESC") String direction) {

        return jobService.findAllOrderingByMaxSalaryDesc(field, direction);

    }

    @PostMapping("job")
    public Job createJob (@RequestBody UpSertJobRequest request) {
        return jobService.create(request);
    }

    @PutMapping("job/{id}")
    public Job updateJob(@PathVariable("id") String id, @RequestBody UpSertJobRequest request) {
        return jobService.updateBook(id, request);
    }

    @DeleteMapping("job/{id}")
    public void deleteJob(@PathVariable("id") String id) {
        jobService.deleteJob(id);
    }

}
