package dev.patika.furrypawcare.repository;

import dev.patika.furrypawcare.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

        List<Owner> findAllByName(String name);



}
