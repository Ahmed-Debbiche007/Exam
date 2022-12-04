package tn.esprit.spring.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Clinique")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Clinique {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name= "idClinique")
    int idClinique;
    @Column (name = "nomClinique")
    String nomClinique;
    @Column (name="addresse")
    String addresse;
    @Column(name = "telephone")
    int telephone;


}
