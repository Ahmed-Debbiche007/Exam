package tn.esprit.spring.entities;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Patient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPatient;
    private String nomPatient;
    private int telephone;
    @Temporal(TemporalType.DATE )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy="patient")
    @JsonIgnore
    private Set<RendezVous> rdvs;


}
