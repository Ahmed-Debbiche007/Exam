package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@EqualsAndHashCode
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;

    private String nom;
    private String prenom;
    @Enumerated(EnumType.STRING)
    private Imc imc;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "client")
    @JsonIgnore
    private List<Plat> Plats;
}
