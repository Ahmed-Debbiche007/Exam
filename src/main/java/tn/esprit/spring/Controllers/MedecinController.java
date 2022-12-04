package tn.esprit.spring.Controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Repositories.CliniqueRepository;
import tn.esprit.spring.Repositories.MedecinRepository;
import tn.esprit.spring.entities.Clinique;
import tn.esprit.spring.entities.Medecin;

import java.util.*;


@RestController
@Tag(name = "Gestion de Medecins")
@RequestMapping("/medecin")
@Slf4j
@Service
public class MedecinController {

    @Autowired
    MedecinRepository repo;
    @Autowired
    CliniqueRepository cliniqueRepository;

    @PostMapping("/add")
    @ResponseBody
    public void addMedecin(Medecin medecin) {
        repo.save(medecin);
    }

    @PostMapping("/addAndAssign")
    @ResponseBody
    public void addMedecinAndAssignToClinique(Medecin medecin, int cliniqueId) {
        Clinique clinique = cliniqueRepository.findById(cliniqueId).get();
        log.error(clinique.getNomClinique());
        Set<Clinique> set = new HashSet<Clinique>();
        log.error(String.valueOf(set.size()));
        set.add(clinique);
        log.error(String.valueOf(set.size()));
        medecin.setCliniques(set);
        log.warn("Done");
        repo.save(medecin);
    }

    @PutMapping(name = "/update")
    @ResponseBody
    public void updateMedecin(Medecin medecin) {
        repo.save(medecin);
    }

    @DeleteMapping(name = "/delete")
    @ResponseBody
    public void deleteMedecin(Medecin medecin) {
        repo.delete(medecin);
    }

    @GetMapping(value = "/getAll")
    @ResponseBody
    public List<Medecin> getAll() {
        return  (List<Medecin>) repo.findAll();
    }
}
