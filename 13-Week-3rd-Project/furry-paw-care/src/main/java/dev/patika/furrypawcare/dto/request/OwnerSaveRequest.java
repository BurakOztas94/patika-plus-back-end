package dev.patika.furrypawcare.dto.request;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnerSaveRequest {

    private String name;
    private String phone;
    @Email
    private String email;
    private String address;
    private String city;
}

