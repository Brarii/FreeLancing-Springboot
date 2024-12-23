package com.example.newproj.controller.Controllers;


import com.example.newproj.Entities.Entities.FreeLancer;
import com.example.newproj.Entities.Entities.Job;
import com.example.newproj.Services.ClientService;
import com.example.newproj.Services.FreeLancerService;
import com.example.newproj.Services.JobService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("")
public class JobController {
    @Autowired
    private JobService js;
    private FreeLancerService fs;
    private ClientService cs;


    @PutMapping("client/job/update/{id}")
    public void updateJob(@RequestBody Job job) {
        js.updateJob(job);
    }


    @GetMapping("job/{id}")
    public Job getJobById(@PathVariable Long id) {
        return js.getJobById(id);
    }
}


//    @DeleteMapping("/client/{id}")
//    public void deleteJob(@PathVariable Long id) {
//        js.deleteJob(id);
//    }






