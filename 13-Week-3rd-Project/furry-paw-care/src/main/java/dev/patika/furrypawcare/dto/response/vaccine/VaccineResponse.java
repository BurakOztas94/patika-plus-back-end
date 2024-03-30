package dev.patika.furrypawcare.dto.response.vaccine;



import dev.patika.furrypawcare.dto.response.pet.PetWithoutAnythingResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineResponse {

    private Long id;
    private String name;
    private String code;
    private LocalDate protectionStartDate;
    private LocalDate protectionFinishDate;
    private PetWithoutAnythingResponse pet;

}
