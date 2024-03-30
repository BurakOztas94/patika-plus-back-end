package dev.patika.furrypawcare.repository;

import dev.patika.furrypawcare.entity.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository extends JpaRepository<Vet, Long> {
}
