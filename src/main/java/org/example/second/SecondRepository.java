package org.example.second;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondRepository extends JpaRepository<SecondEntity, Long> {
}
