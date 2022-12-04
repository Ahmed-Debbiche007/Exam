package tn.esprit.spring.entities;
import javax.persistence.*;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "RendezVous")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRDV;
    @Temporal(TemporalType.DATE )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateRDV;
    private String remarque;
    @ManyToOne (cascade = CascadeType.ALL)
    private Patient patient;

    @ManyToOne (cascade = CascadeType.ALL)
    private Medecin medecin;

    @Override
    public String toString() {
        return "La liste des RendezVous :" + dateRDV +
                " : Patient : " + patient.getNomPatient() +
                " : Medecin : " + medecin.getNommedecin()
                ;
    }
}
