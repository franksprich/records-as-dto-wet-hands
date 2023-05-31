package edu.spring.records.model.entity;

import edu.spring.records.model.Gender;
import jakarta.persistence.*;
import lombok.Data;

/**
 * {DESCRIPTION}
 *
 * @author Frank Sprich
 */
@Data
@Entity
@Table(name = "Customer")
public class CustomerET {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Integer age;
    private String username;

}
