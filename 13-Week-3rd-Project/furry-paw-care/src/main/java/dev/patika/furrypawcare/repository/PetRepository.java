package dev.patika.furrypawcare.repository;

import dev.patika.furrypawcare.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {
    List<Pet> findAllByName(String name);

//    @Query(value = "SELECT * FROM pets")
//    List<Pet.GetPetWithoutOwner> findAllPetsWithoutOwners();
}
