package techmaster.vn.homework.service;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import techmaster.vn.homework.entity.Job;
import techmaster.vn.homework.exception.EntityNotFoundException;
import techmaster.vn.homework.request.UpSertJobRequest;

import javax.annotation.ManagedBean;
import java.util.*;

@Service

public class JobService {
    private List<Job> jobs;

    /*
    private String title;
    private String description;
    private String location;
    private int minSalaray;
    private int maxSalary;
    private String emailTo;
     */
    public JobService() {
        jobs = new ArrayList<>();
        jobs.add(new Job(String.valueOf(UUID.randomUUID()), "engineer", "job1", "HN", 2000, 5000, "engineer@gmail.com"));
        jobs.add(new Job(String.valueOf(UUID.randomUUID()), "pilot", "job2", "HCM", 10000, 50000, "pilot@gmail.com"));
        jobs.add(new Job(String.valueOf(UUID.randomUUID()), "teacher", "job3", "DN", 1000, 3500, "teacher@gmail.com"));
        jobs.add(new Job(String.valueOf(UUID.randomUUID()), "bartender", "job4", "VINH", 2150, 5650, "bartender@gmail.com"));
        jobs.add(new Job(String.valueOf(UUID.randomUUID()), "farmer", "job5", "HP", 1000, 6570, "engineer@gmail.com"));
    }


    public List<Job> findAll() {
        return jobs;
    }

    public Job findJobById(String id) {
        return jobs.stream()
                .filter(n -> n.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("id is not existed id=" + id));
    }

    public Job findRandomJob() {
        int index = new Random().nextInt(jobs.size());
        return jobs.get(index);
    }


    public List<Job> findAllOrderingByMaxSalaryDesc(String field, String direction) {
        if (field.equalsIgnoreCase("maxSalary")) {
            if (direction.equalsIgnoreCase("ASC"))
                return jobs.stream().sorted(Comparator.comparing(Job::getMaxSalary)).toList();
            else
                return jobs.stream().sorted(Comparator.comparing(Job::getMaxSalary).reversed()).toList();
        } else return null;

    }


    public Job create(UpSertJobRequest request) {
        String id = String.valueOf(UUID.randomUUID());
        Job job = new Job(
                id
                , request.getTitle()
                , request.getDescription()
                , request.getLocation()
                , request.getMinSalaray()
                , request.getMaxSalary()
                , request.getEmailTo());

        jobs.add(job);
        return job;
    }

    public Job updateBook(String id, UpSertJobRequest request) {
        Job job = jobs.stream().filter(
                        n -> n.getId()
                                .equals(id))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Can not fount the id=" + id));
        if (request.getTitle() != null) job.setTitle(request.getTitle());
        if (request.getDescription() != null) job.setDescription(request.getDescription());
        if (request.getLocation() != null) job.setLocation(request.getLocation());
        if (request.getEmailTo() != null) job.setEmailTo(request.getEmailTo());
        if (request.getMaxSalary() != 0) job.setMaxSalary(request.getMaxSalary());
        if (request.getMinSalaray() != 0) job.setMinSalaray(request.getMinSalaray());
        return job;
    }


    public void deleteJob(String id) {
        jobs.remove(findJobById(id));
    }
}
