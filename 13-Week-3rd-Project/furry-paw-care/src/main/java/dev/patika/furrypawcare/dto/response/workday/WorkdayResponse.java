package dev.patika.furrypawcare.dto.response.workday;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkdayResponse {
    private Long id;
    private LocalDate workday;

}

