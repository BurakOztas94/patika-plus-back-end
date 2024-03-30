package dev.patika.furrypawcare.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pets")

@Getter
@Setter
@ToString

@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String species;
    private String breed;
    private String colour;
    private String gender;
    private LocalDate birthDate;

    @ToString.Exclude
    @ManyToOne
    @JsonIgnore
    private Owner owner;

    @ToString.Exclude
    @OneToMany(mappedBy = "pet", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Vaccine> vaccines;

    @ToString.Exclude
    @OneToMany(mappedBy = "pet", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Appointment> appointments;

//    public interface GetPetWithoutOwner {
//        Long getId();
//        String getName();
//        String getSpecies();
//        String getBreed();
//        String getColour();
//        String getGender();
//        LocalDate getBirthDate();
//    }

}
