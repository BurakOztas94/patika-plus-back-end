package dev.patika.furrypawcare.repository;

import dev.patika.furrypawcare.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByPetIdAndVetId (Long petId, Long vetId);
    Optional<Appointment> findByVetIdAndStartDateTime(Long vetId, LocalDateTime startDateTime);
}
