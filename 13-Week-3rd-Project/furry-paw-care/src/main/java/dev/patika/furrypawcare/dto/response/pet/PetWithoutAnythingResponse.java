package dev.patika.furrypawcare.dto.response.pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetWithoutAnythingResponse {
    private Long id;
    private String name;
    private String species;
    private String breed;
    private String gender;
    private String colour;
    private LocalDate dateOfBirth;
}
