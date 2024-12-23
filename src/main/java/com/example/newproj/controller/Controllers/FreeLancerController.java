package com.example.newproj.controller.Controllers;


import com.example.newproj.Entities.Entities.FreeLancer;
import com.example.newproj.Entities.Entities.Job;
import com.example.newproj.Entities.Entities.Portfolio;
import com.example.newproj.Services.FreeLancerService;
import com.example.newproj.Services.JobService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/freelancer")
public class FreeLancerController {

    private FreeLancerService fs;
    private JobService js;

    private static final String UPLOAD_DIR = "uploads/";

    @GetMapping("/freelancer/hello")
    public String getGaith() {
        return "hello freelancerrrrr";
    }



    @GetMapping("job/{id}")
    public Job getJobById(@PathVariable Long id) {
        return js.getJobById(id);
    }

    @PostMapping("/add")
    public void addFreeLancer(@RequestBody FreeLancer freeLancer) {
        fs.addFreeLancer(freeLancer);
    }

    @DeleteMapping("/{id}")
    public void deleteFreeLancer(@PathVariable Long id) {
        fs.deleteFreeLancer(id);
    }

    @PutMapping("/freelancer/update/{id}")
    public void updateFreeLancer(@RequestBody FreeLancer freeLancer) {
        fs.updateFreeLancer(freeLancer);
    }

    @PutMapping("/{freelancerId}/portfolio")
    public ResponseEntity<Portfolio> updatePortfolio(@PathVariable Long freelancerId, @RequestBody Portfolio updatedPortfolio) {
        try {
            Portfolio portfolio = fs.updatePortfolio(freelancerId, updatedPortfolio);
            return ResponseEntity.ok(portfolio);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }





    @PostMapping("/{id}/portfolio/uploadFile")
    public String uploadFileToPortfolio(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file) throws IOException {

        // Step 1: Upload the file and get the new file name
        String fileName = fs.uploadFile(file);

        // Step 2: Fetch the Freelancer by ID
        FreeLancer freelancer = fs.getFreeLancertById(id);


        // Step 3: Get or create the Portfolio
        Portfolio portfolio = freelancer.getPortfolio();
        if (portfolio == null) {
            portfolio = new Portfolio(); // Create a new Portfolio if it doesn't exist
            portfolio.setFreelancer(freelancer);
            freelancer.setPortfolio(portfolio);
        }

        // Step 4: Update the Portfolio with the file name
        portfolio.setFileName(fileName);

        // Step 5: Save the updated Freelancer (cascading will persist the Portfolio)
        fs.addFreeLancer(freelancer);

        return "File uploaded and Portfolio updated successfully!";
    }


    @GetMapping(path = "/freelancer/getFile/{id}" ,produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getFile(@PathVariable("id") int id) throws IOException {
        return fs.getFile(id);
    }


    @GetMapping("/job")
    public List<Job> getAllJobs() {
        return js.getJobs();
    }

}
