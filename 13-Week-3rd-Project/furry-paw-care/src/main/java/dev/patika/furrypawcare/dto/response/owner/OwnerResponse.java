package dev.patika.furrypawcare.dto.response.owner;

import dev.patika.furrypawcare.dto.response.pet.PetWithoutOwnerResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnerResponse {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String city;
    private List<PetWithoutOwnerResponse> pets;
}

