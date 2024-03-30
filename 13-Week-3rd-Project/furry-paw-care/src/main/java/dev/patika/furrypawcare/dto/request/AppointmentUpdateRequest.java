package dev.patika.furrypawcare.dto.request;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentUpdateRequest {
    @Positive(message = "ID Value must be positive")
    private Long id;


    private LocalDateTime startDateTime;

    private Long vetId;
    private Long petId;
}
