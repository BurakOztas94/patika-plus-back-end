package dev.patika.furrypawcare.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime startDateTime;

    @ManyToOne
    private Pet pet;

    @ToString.Exclude
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnore
    private Vet vet;
}
