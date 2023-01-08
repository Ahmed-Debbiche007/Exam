package tn.esprit.spring.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Configuration.LoggingAspect;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.Repositories.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@Tag(name = "Gestion des Plats")
@RequestMapping("/plat")
@Service
@Slf4j
public class PlatsController {
    @Autowired
    private PlatRepository repo;
    @Autowired
    private CuisinierRepository cuisinierRepository;
    @Autowired
    private ClientRepository clientRepository;
    private static final Logger logger =
            LogManager.getLogger(LoggingAspect.class);
    @PostMapping("/add")
    @ResponseBody
    public Plat AjouterPlatetAffecterClientEtCuisinier(Plat plat, int idClient, int idCuisinier) {

        Client client = clientRepository.findById(idClient).get();
        plat.setClient(client);
        List<Cuisinier> cuisinierSet = new ArrayList<Cuisinier>();
        Cuisinier cuisinier = cuisinierRepository.findByIdCuisinier(idCuisinier);
        cuisinierSet.add(cuisinier);
        plat.setCuisiniers(cuisinierSet);
        return repo.save(plat);
    }

    @GetMapping(value = "/getByClient")
    @ResponseBody
    public List<Plat> afficherListePlatsParClient(String nom, String prenom) {
        return repo.findByClient_NomAndClient_Prenom(nom, prenom);
    }

    @GetMapping(value = "/calculMontant")
    @ResponseBody
    public float MontantApayerParClient(int idClient) {
        Client client = clientRepository.findById(idClient).get();
        List<Plat> plats = client.getPlats();
        float montant = 0;
        for (Plat p: plats){
            montant+= p.getPrix();
        }
        return montant;
    }




}