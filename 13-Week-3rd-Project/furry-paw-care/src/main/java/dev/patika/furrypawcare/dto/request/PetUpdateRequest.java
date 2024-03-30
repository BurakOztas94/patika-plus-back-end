package dev.patika.furrypawcare.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetUpdateRequest {
    @Positive(message = "ID Values must be positive!")
    private Long id;
    @NotNull(message = "Pet name cannot be empty!")
    private String species;
    private String breed;
    private String gender;
    private String colour;
    private LocalDate dateOfBirth;
    private Long ownerId;
}
