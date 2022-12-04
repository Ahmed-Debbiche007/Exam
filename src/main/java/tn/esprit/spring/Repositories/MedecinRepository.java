package tn.esprit.spring.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.entities.Medecin;

public interface MedecinRepository extends CrudRepository<Medecin,Integer> {
}
