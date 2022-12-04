package tn.esprit.spring.Controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;
import tn.esprit.spring.Repositories.CliniqueRepository;
import tn.esprit.spring.Repositories.MedecinRepository;
import tn.esprit.spring.Repositories.PatientRepository;
import tn.esprit.spring.Repositories.RendezVousRepository;
import tn.esprit.spring.entities.Clinique;
import tn.esprit.spring.entities.Medecin;
import tn.esprit.spring.entities.RendezVous;
import tn.esprit.spring.entities.Specialite;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@Tag(name = "Gestion de Rendez Vous")
@RequestMapping("/rendezVous")
@Slf4j
@Service
public class RendezVousController {
    @Autowired
    RendezVousRepository repo;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    MedecinRepository medecinRepository;

    @Autowired
    CliniqueRepository cliniqueRepository;

    @PostMapping("/add")
    @ResponseBody
    public void addRDV(RendezVous rdv) {
        repo.save(rdv);
    }

    @PostMapping(value = "/addAndAssign")
    @ResponseBody
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, int idMedecin, int idPatient) {
        rdv.setMedecin(medecinRepository.findById(idMedecin).get());
        rdv.setPatient(patientRepository.findById(idPatient).get());
        repo.save(rdv);
    }

    @PutMapping(name = "/update")
    @ResponseBody
    public void updateRDV(RendezVous rdv) {
        repo.save(rdv);
    }

    @DeleteMapping(name = "/delete")
    @ResponseBody
    public void deleteRDV(RendezVous rdv) {
        repo.delete(rdv);
    }

    @GetMapping(value = "/getAll")
    @ResponseBody
    public List<RendezVous> getAll() {
        return (List<RendezVous>) repo.findAll();
    }

    @GetMapping(value = "/getByClinicAndSpecialty")
    @ResponseBody
    public int getRendezVousByCliniqueAndSpecialite(int idClinique, Specialite specialite) {
        List<RendezVous> list = (List<RendezVous>) repo.findAll();
        List<RendezVous> finalList = new ArrayList<RendezVous>();
        Clinique clinique = cliniqueRepository.findById(idClinique).get();
        for (RendezVous rdv : list) {
            Medecin med = rdv.getMedecin();
            if (med.getCliniques().contains(clinique) && med.getSpecialite().equals(specialite)) {
                finalList.add(rdv);
            }
        }
        return finalList.size();
    }


    @GetMapping(value = "/getCount")
    @ResponseBody
    public int getNbrRendezVousMedecin(int idMedecin){
        List<RendezVous> list = (List<RendezVous>) repo.findAll();
        List<RendezVous> finalList = new ArrayList<RendezVous>();
        for (RendezVous rdv : list) {
            if (rdv.getMedecin().getIdMedecin()==idMedecin) {
                finalList.add(rdv);
            }
        }
        return finalList.size();
    }
    @Scheduled(fixedDelay = 30000)
    public void retrieveRendezVous() {
        List<RendezVous> list = (List<RendezVous>) repo.findAll();
        for (RendezVous rdv:list){
            log.info(rdv.toString());
        }
    }
    @GetMapping(value = "/getRevnue/{idMedecin}/{startDate}/{endDate}")
    @ResponseBody
    public int getRevenuMedecin (@PathVariable("idMedecin") int idMedecin,
            @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")Date endDate
    ){
        List<RendezVous> list = (List<RendezVous>) repo.findByMedecin_IdMedecinAndDateRDVBeforeAndDateRDVAfter(idMedecin,endDate,startDate);
        int r=0;
        for (RendezVous rdv:list){
            log.info(rdv.getRemarque());
            r=r+rdv.getMedecin().getPrixConsultation();
        }
        return r;
    }


}