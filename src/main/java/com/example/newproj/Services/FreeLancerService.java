package com.example.newproj.Services;


import com.example.newproj.Entities.Entities.FreeLancer;
import com.example.newproj.Entities.Entities.Portfolio;
import com.example.newproj.repositories.Repositories.FreeLancerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class FreeLancerService {

    private FreeLancerRepository fr;


    public void addFreeLancer(FreeLancer freeLancer) {

        FreeLancer newfreeLancer=FreeLancer.builder().email(freeLancer.getEmail()).name(freeLancer.
                getEmail()).skills(freeLancer.getSkills()).portfolio(freeLancer.getPortfolio()).jobs(freeLancer.getJobs()).build();

        fr.save(newfreeLancer);
    }

    public void deleteFreeLancer(Long id) {
        fr.deleteById(id);
    }

    public void updateFreeLancer(FreeLancer freeLancer) {
        fr.save(freeLancer);
    }

    public List<FreeLancer> getFreeLancers() {
        return fr.findAll();
    }

    public FreeLancer getFreeLancertById(Long id) {
        return fr.findById(id).get();
    }


    public Portfolio updatePortfolio(Long freelancerId, Portfolio updatedPortfolio) {
        FreeLancer freelancer = fr.findById(freelancerId)
                .orElseThrow(() -> new RuntimeException("Freelancer not found"));

        Portfolio existingPortfolio = freelancer.getPortfolio();
        if (existingPortfolio == null) {
            throw new RuntimeException("No portfolio associated with the freelancer");
        }

        existingPortfolio.setLink(updatedPortfolio.getLink());
        existingPortfolio.setDescription(updatedPortfolio.getDescription());

        fr.save(freelancer);

        return existingPortfolio;
    }


    private String newname(String oldname) {
        String firstname = oldname.substring(0, oldname.lastIndexOf("."));
        String secondname = oldname.substring(oldname.lastIndexOf(".") + 1);
        String newname = firstname + LocalDateTime.now().toString().replace(":", "-") + "." + secondname;
        return newname;
    }

    public String uploadFile(MultipartFile mf) throws IOException {
        String oldName = mf.getOriginalFilename();
        String newName = newname(oldName);
        Path p= Paths.get("src/main/resources/static/image/"+ newName );
      /*  if (!Files.exists(p.getParent())) {
            Files.createDirectories(p.getParent()); // Create parent directory if it doesn't exist
        }

        Path filePath = p.resolve(newName);*/

        Files.write(p, mf.getBytes());


        return newName;
    }

    public byte[] getFile(int id) throws IOException {
        String nomImage=fr.findById((long) id).get().getPortfolio().getFileName();
        Path p= Paths.get(System.getProperty("user.dir") +"/src/main/resources/static/image/",nomImage);
        return Files.readAllBytes(p);

    }

}
