package edu.spring.records.model.dto;

import edu.spring.records.model.Gender;

import java.util.List;

/**
 * {DESCRIPTION}
 *
 * @author Frank Sprich
 */
public record Customer(
        Long id,
        String name,
        String email,
        Gender gender,
        Integer age,
        List<String> roles,
        String username
) {
}
