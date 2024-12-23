package com.example.newproj.controller.Controllers;

import com.example.newproj.Entities.Entities.Client;
import com.example.newproj.Entities.Entities.FreeLancer;
import com.example.newproj.Entities.Entities.Job;
import com.example.newproj.Services.ClientService;
import com.example.newproj.Services.FreeLancerService;
import com.example.newproj.Services.JobService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService cs;
    private JobService js;
    private FreeLancerService fs;


    @GetMapping("/hello")
    public String geting() {
        return "hello clientttttttttt";
    }


@GetMapping
public List<Client> getAllClients() {
    return cs.getClients();
}

@GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
    return cs.getClientById(id);
}

@PostMapping("/add")
    public Client addClient(@RequestBody Client client) {
    return cs.addClient(client);

}

@DeleteMapping("/{id}")
   public void deleteClient(@PathVariable Long id) {
        cs.deleteClient(id);
}


    @PutMapping("/update/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {


        Client updatedClient = cs.updateClient(client);

        if (updatedClient == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedClient);
    }


    @GetMapping("/profile")
    public String clientProfile() {
        return "This is the client profile";
    }


    @PostMapping("job/add")
    public void addJob(@RequestBody Job job) {
        js.addJob(job);
    }

    @GetMapping("freelancer/all")
    public List<FreeLancer> getAllFreeLancers() {
        return fs.getFreeLancers();
    }





    @GetMapping("freelancer/{id}")
    public FreeLancer getFreeLancerById(@PathVariable Long id) {
        return fs.getFreeLancertById(id);
    }

}

