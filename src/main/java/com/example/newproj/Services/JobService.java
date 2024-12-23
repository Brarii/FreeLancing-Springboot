package com.example.newproj.Services;
import com.example.newproj.Entities.Entities.Job;
import com.example.newproj.repositories.Repositories.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobService {
@Autowired
    private JobRepository jr;


    public void addJob(Job job) {
       Job newJob =Job.builder().budget(job.getBudget()).description(job.getDescription())
               .client(job.getClient()).freelancers(job.getFreelancers()).build();

       jr.save(newJob);

    }

    public void deleteJob(Long id) {
        jr.deleteById(id);
    }

    public void updateJob(Job job) {
        jr.save(job);
    }

    public List<Job> getJobs() {
        return jr.findAll();
    }

    public Job getJobById(Long id) {
        return jr.findById(id).get();
    }

}
