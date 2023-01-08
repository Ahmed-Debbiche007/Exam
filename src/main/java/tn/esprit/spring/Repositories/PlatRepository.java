package tn.esprit.spring.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.entities.Categorie;
import tn.esprit.spring.entities.Cuisinier;
import tn.esprit.spring.entities.Plat;

import java.util.List;

public interface PlatRepository extends CrudRepository<Plat,Integer> {
    public List<Plat> findByClient_NomAndClient_Prenom(String nom, String prenom);
    public List<Plat> findByCategorie(Categorie categorie);
}
