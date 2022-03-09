package tk.karimc.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.karimc.api.data.Client;
import tk.karimc.api.data.ClientRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepo clientRepo;

    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public List<Client> getClients() {
        return clientRepo.findAll();
    }

    public void registerClient(Client client) throws Exception {
        Optional<Client> c = this.clientRepo.findClientByEmail(client.getEmail());
        if (c.isEmpty()) {
            this.clientRepo.save(client);
            return;
        }
        throw new Exception("Email already registered");
    }

    public void deleteClient(long id) {
        boolean exists = this.clientRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("student with this id does not exist");
        } else {
            clientRepo.deleteById(id);
        }
    }

    @Transactional
    public void withdrawAmount(long id, int amount) {
        if (amount < 0) {
            throw new IllegalStateException("amount is invalid");
        }
        boolean exist = this.clientRepo.existsById(id);
        if (!exist) {
            throw new IllegalStateException("student with this id does not work");
        }
        Client c = this.clientRepo.findById(id).get();
        if (amount > c.getAccountBalance()) {
            throw new IllegalStateException("Insufficient balance");
        }
        c.setAccountBalance(c.getAccountBalance() - amount);
    }

    @Transactional
    public void depositAmount(long id, int amount) {
        if (amount < 0) {
            throw new IllegalStateException("amount is invalid");
        }
        boolean exist = this.clientRepo.existsById(id);
        if (!exist) {
            throw new IllegalStateException("student with this id does not work");
        }
        Client c = this.clientRepo.findById(id).get();
        c.setAccountBalance(c.getAccountBalance() + amount);
    }
}
