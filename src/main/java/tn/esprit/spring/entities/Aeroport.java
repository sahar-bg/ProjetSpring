package tn.esprit.spring.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Aeroport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idAeroport;
    String nom;
    String codeAITA;
    @Column(length=3)
    long telephone;


    @OneToMany (mappedBy = "aeroportDepart")
    List<Vol> volsDepart;

    @OneToMany (mappedBy = "aeroportArrive")
    List<Vol> volsArrive;
}
