package dev.patika.furrypawcare.repository;

import dev.patika.furrypawcare.entity.Workday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface WorkdayRepository extends JpaRepository<Workday, Long> {
    List<Workday> findByVetId(Long vetId);
    Optional<Workday> findByVetIdAndWorkday(Long vetId, LocalDate workday);
}
