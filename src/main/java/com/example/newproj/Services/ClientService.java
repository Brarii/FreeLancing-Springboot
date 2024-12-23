package com.example.newproj.Services;


import com.example.newproj.Entities.Entities.Client;
import com.example.newproj.repositories.Repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    @Autowired
private ClientRepository cr;

public Client addClient(Client client) {
    return cr.save(client);
}

public void deleteClient(Long id) {
    cr.deleteById(id);
}

public Client updateClient(Client client) {

        return cr.save(client);
    }


public List<Client> getClients() {
    return cr.findAll();
}

public Client getClientById(Long id) {
    return cr.findById(id).get();
}
}
