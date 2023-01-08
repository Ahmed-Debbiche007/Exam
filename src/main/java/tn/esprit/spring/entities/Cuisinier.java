package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cuisinier")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@EqualsAndHashCode
public class Cuisinier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCuisinier;
    private String nom;
    private String prenom;
    @ManyToMany (cascade = CascadeType.ALL , mappedBy = "cuisiniers")
    @JsonIgnore
    private List<Plat> plat;
}
