package dev.patika.furrypawcare.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "workdays")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Workday {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate workday;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Vet vet;

}





