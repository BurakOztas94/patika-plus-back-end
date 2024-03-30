package dev.patika.furrypawcare.dto.response.appointment;

import dev.patika.furrypawcare.dto.response.pet.PetWithoutAnythingResponse;
import dev.patika.furrypawcare.dto.response.vet.VetWithoutAnythingResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {
    private Long id;
    private LocalDateTime startDateTime;
    private VetWithoutAnythingResponse vet;
    private PetWithoutAnythingResponse pet;
}
