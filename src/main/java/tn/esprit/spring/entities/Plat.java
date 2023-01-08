package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Plat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@EqualsAndHashCode
public class Plat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlat;
    private String label;
    private float prix;
    private float calories;
    @Enumerated(EnumType.STRING)
    private Categorie categorie;

    @ManyToOne (cascade = CascadeType.ALL)
    @JsonIgnore
    private Client client;

    @ManyToMany (cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cuisinier> cuisiniers;
}
