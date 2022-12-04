package tn.esprit.spring.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.entities.Patient;

public interface PatientRepository extends CrudRepository<Patient,Integer> {
}
