package tn.esprit.spring.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.entities.Medecin;
import tn.esprit.spring.entities.RendezVous;
import tn.esprit.spring.entities.Specialite;

import java.util.Date;
import java.util.List;

public interface RendezVousRepository extends CrudRepository<RendezVous,Integer> {
    public List<RendezVous> findByMedecin_Specialite(Specialite specialite);
    public List<RendezVous> findByMedecin_IdMedecinAndDateRDVBeforeAndDateRDVAfter(int medecinId, Date startDate, Date endDate);
}
