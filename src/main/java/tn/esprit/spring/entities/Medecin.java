package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Medecin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idMEdecin")
    int idMedecin;
    @Column (name = "nomMedecin")
    String nommedecin;
    @Column (name="specialite")
    @Enumerated (EnumType.STRING)
    Specialite specialite;
    @Column(name = "telephone")
    int telephone;
    @Column(name = "prixConsultation")
    int prixConsultation;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Clinique> cliniques;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy="medecin")
    @JsonIgnore
    private Set<RendezVous> rdvs;
}
