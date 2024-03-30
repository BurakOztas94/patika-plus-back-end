package dev.patika.furrypawcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "vaccines")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String code;
    private LocalDate protectionStartDate;
    private LocalDate protectionFinishDate;

    @ManyToOne
    private Pet pet;
}
