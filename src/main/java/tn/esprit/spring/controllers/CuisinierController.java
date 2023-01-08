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

@RestController
@Tag(name = "Gestion des Cuisiniers")
@RequestMapping("/cuisinier")
@Service
@Slf4j
public class CuisinierController {
    @Autowired
    private PlatRepository platRepository;
    @Autowired
    private CuisinierRepository repo;

    @PostMapping("/add")
    @ResponseBody
    public Cuisinier ajouterClient(Cuisinier cuisinier) {
        return repo.save(cuisinier);
    }

    @Scheduled(fixedDelay = 15000)
    public void afficherListeCuisiniers() {


       int id =2;
        Cuisinier c = repo.findByIdCuisinier(id);
        String msg = "Cuisinier:"+c.getNom() + " Prenom: "+c.getPrenom();
        log.info(msg);
    }
}
