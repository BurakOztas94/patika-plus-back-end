package dev.patika.furrypawcare.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkdaySaveRequest {
    private LocalDate workday;
    private Long vetId;
}

