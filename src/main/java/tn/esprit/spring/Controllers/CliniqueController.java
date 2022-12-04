package tn.esprit.spring.Controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Repositories.CliniqueRepository;
import tn.esprit.spring.entities.Clinique;

import java.util.List;

@RestController
@Tag(name = "Gestion de Cliniques")
@RequestMapping("/clinique")
@Service
public class CliniqueController {

    @Autowired
    CliniqueRepository repo;

    @PostMapping("/add")
    @ResponseBody
    public void addClinique(Clinique clinique) {
        repo.save(clinique);
    }

    @PutMapping(name = "/update")
    @ResponseBody
    public void updateClinique(Clinique clinique) {
        repo.save(clinique);
    }

    @DeleteMapping(name = "/delete")
    @ResponseBody
    public void deleteClinique(Clinique clinique) {
        repo.delete(clinique);
    }

    @GetMapping(value = "/getAll")
    @ResponseBody
    public List<Clinique> getAll() {
        List<Clinique> list = (List<Clinique>) repo.findAll();
        if (list.isEmpty()) {
            return null;
        } else {
            return list;
        }

    }

    @GetMapping(value = "/getById")
    @ResponseBody
    public String getTel(int id) {
        Clinique c = repo.findById(id).get();
        return c.getNomClinique();
    }
}
