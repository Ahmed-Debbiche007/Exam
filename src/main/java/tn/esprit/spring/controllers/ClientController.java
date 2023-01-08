package tn.esprit.spring.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.Repositories.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@Tag(name = "Gestion des Clients")
@RequestMapping("/client")
@Service
@Slf4j
public class ClientController {
    @Autowired
    private ClientRepository repo;
    @PostMapping("/add")
    @ResponseBody
    public Client ajouterClient(Client client) {
        return repo.save(client);
    }

    @PutMapping(value = "/ModifierImc")
    @ResponseBody
    public void ModifierImc(int idClient) {
        Client client = repo.findById(idClient).get();
        float totalCalories=0;
        for (Plat p : client.getPlats()){
            totalCalories+= p.getCalories();
        }
        if (totalCalories<2000){
            client.setImc(Imc.FAIBLE);
        }else if (totalCalories ==2000){
            client.setImc(Imc.IDEAL);
        }
        else {
            client.setImc(Imc.FORT);
        }

        repo.save(client);
    }
}
