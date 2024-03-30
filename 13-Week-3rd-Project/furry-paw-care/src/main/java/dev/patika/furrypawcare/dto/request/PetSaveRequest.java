package dev.patika.furrypawcare.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetSaveRequest {
    private String name;
    private String species;
    private String breed;
    private String gender;
    private String colour;
    private LocalDate dateOfBirth;
    private Long ownerId;
}
