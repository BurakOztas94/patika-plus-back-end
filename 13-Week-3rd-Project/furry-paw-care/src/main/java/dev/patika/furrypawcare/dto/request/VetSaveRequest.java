package dev.patika.furrypawcare.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VetSaveRequest {
    private String name;
    private String phone;
    private String email;
    private String address;
    private String city;
}
