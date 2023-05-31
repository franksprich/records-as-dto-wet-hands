package edu.spring.records.repo;

import edu.spring.records.model.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * {DESCRIPTION}
 *
 * @author Frank Sprich
 */
public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {
}
