package dev.patika.furrypawcare.dto.response.vet;

import dev.patika.furrypawcare.dto.response.appointment.AppointmentResponse;
import dev.patika.furrypawcare.dto.response.workday.WorkdayResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VetResponse {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String city;
    private List<AppointmentResponse> appointments;
    private List<WorkdayResponse> workdays;
}
