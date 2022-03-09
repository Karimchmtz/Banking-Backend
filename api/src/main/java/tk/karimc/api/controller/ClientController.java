package tk.karimc.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.karimc.api.data.Client;
import tk.karimc.api.service.ClientService;

import java.util.List;

@RestController
@RequestMapping(path = "api/clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(path = ("/all"))
    public List<Client> getClients() {
        return this.clientService.getClients();
    }

    @PostMapping(path = "/add")
    public void registerClient(@RequestBody Client client) throws Exception {
        try {
            this.clientService.registerClient(client);
        } catch (Exception e) {
            throw e;
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteClient(@PathVariable("id") long id) {
        this.clientService.deleteClient(id);
    }

    @PutMapping(path = "/withdraw/{id}/{amount}")
    public void withdrawAmount(@PathVariable("id") long id,
                               @PathVariable("amount") int amount) {
        this.clientService.withdrawAmount(id, amount);
    }
    @PutMapping(path = "/deposit/{id}/{amount}")
    public void DepositAmount(@PathVariable("id") long id,
                               @PathVariable("amount") int amount) {
        this.clientService.depositAmount(id, amount);
    }

}
