package dev.patika.furrypawcare.repository;

import dev.patika.furrypawcare.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
    List<Vaccine> findByPetId(Long petId);

    @Query(value = "SELECT * FROM vaccines WHERE pet_id = ?1 AND code = ?2 AND protection_finish_date > ?3", nativeQuery = true)
    Optional<Vaccine> checkVaccineConflict(Long petId, String code, LocalDate startDate);

    @Query(value ="SELECT * FROM vaccines WHERE protection_finish_date BETWEEN ?1 AND ?2",nativeQuery = true)
    List<Vaccine> filterVaccinesByInputtedStartAndEndDates (LocalDate start,LocalDate end);
}
