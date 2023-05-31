package edu.spring.records.mapper;

import edu.spring.records.model.dto.Customer;
import edu.spring.records.model.entity.CustomerEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

/**
 * {DESCRIPTION}
 *
 * @author Frank Sprich
 */
@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerEntity toEntity(Customer customer);
    @InheritInverseConfiguration
    Customer toDto(CustomerEntity customer);
}
