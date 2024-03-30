package dev.patika.furrypawcare.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineSaveRequest {

    private String name;
    private String code;
    private LocalDate protectionStartDate;
    private LocalDate protectionFinishDate;
    private Long petId;
}

