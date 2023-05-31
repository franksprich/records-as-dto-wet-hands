package edu.spring.records.mapper;

import edu.spring.records.model.dto.Customer;
import edu.spring.records.model.entity.CustomerET;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

/**
 * {DESCRIPTION}
 *
 * @author Frank Sprich
 */
@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerET toEntity(Customer customer);
    @InheritInverseConfiguration
    Customer toDto(CustomerET customer);
}
