package dev.patika.furrypawcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "owners")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String city ;
    
    @OneToMany(mappedBy = "owner",cascade = CascadeType.REMOVE)
    private List<Pet> pets;

}
