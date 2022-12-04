package tn.esprit.spring.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.entities.Clinique;

public interface CliniqueRepository extends CrudRepository<Clinique,Integer> {
}
