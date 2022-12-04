package tn.esprit.spring.Controllers;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Repositories.PatientRepository;
import tn.esprit.spring.entities.Clinique;
import tn.esprit.spring.entities.Patient;

import java.util.List;

@RestController
@Tag(name = "Gestion de Patients")
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientRepository repo;

    @PostMapping("/add")
    @ResponseBody
    public void addPatient(Patient patient) {
        repo.save(patient);
    }

    @PutMapping(name = "/update")
    @ResponseBody
    public void updatePatient(Patient patient) {
        repo.save(patient);
    }

    @DeleteMapping(name = "/delete")
    @ResponseBody
    public void deletePatient(Patient patient) {
        repo.delete(patient);
    }

    @GetMapping(name = "/getAll")
    @ResponseBody
    public List<Patient> getAll() {
        List<Patient> list = (List<Patient>) repo.findAll();
        if (list.isEmpty()){
            return null;
        }else {
            return list;
        }

    }
}
