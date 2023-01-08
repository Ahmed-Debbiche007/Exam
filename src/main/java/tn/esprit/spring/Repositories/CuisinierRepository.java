package tn.esprit.spring.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.entities.Cuisinier;

import java.util.List;

public interface CuisinierRepository extends CrudRepository<Cuisinier,Integer> {
    public List<Cuisinier> findAll();
    public Cuisinier findByIdCuisinier(int id);

}

