package com.example.scoreservice.repository;

import com.example.scoreservice.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for {@link Score} entities. By extending {@link JpaRepository},
 * Spring Data automatically provides CRUD methods and query derivation as explained in
 * the Spring Data JPA documentation.
 */
public interface ScoreRepository extends JpaRepository<Score, Long> {
}
