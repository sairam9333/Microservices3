package com.example.matchservice.repository;

import com.example.matchservice.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link Match} entities.  Extending
 * {@link JpaRepository} tells Spring Data to create an implementation at runtime
 * that includes common CRUD operations like save, findAll and delete【28841497750044†L227-L241】.
 */
@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    // Additional query methods can be defined here if needed
}
