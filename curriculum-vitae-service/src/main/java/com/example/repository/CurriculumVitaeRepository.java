package com.example.repository;

import com.example.entity.CurriculumVitae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CurriculumVitaeRepository extends JpaRepository<CurriculumVitae, Long> {
    Optional<CurriculumVitae> findByUuid(UUID uuid);
}
