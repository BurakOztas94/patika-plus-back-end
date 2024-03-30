package dev.patika.furrypawcare.dto.response.pet;

import dev.patika.furrypawcare.dto.response.appointment.AppointmentResponse;
import dev.patika.furrypawcare.dto.response.owner.OwnerWithoutPetResponse;
import dev.patika.furrypawcare.dto.response.vaccine.VaccineResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetResponse {
    private Long id;
    private String name;
    private String species;
    private String breed;
    private String gender;
    private String colour;
    private LocalDate dateOfBirth;
    private OwnerWithoutPetResponse owner;
    private List<VaccineResponse> vaccines;
    private List<AppointmentResponse> appointmentResponses;

}
