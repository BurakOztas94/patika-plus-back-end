package dev.patika.furrypawcare.dto.request;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkdayUpdateRequest {
    @Positive(message = "ID value must be positive!")
    private Long id;
    private LocalDate workday;
    private Long vetId;
}
