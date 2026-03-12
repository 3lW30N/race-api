package com.takima.race.registration;

import com.takima.race.registration.dto.CreateRegistrationRequest;
import com.takima.race.registration.dto.RegistrationResponse;
import com.takima.race.registration.dto.UpdateRegistrationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RegistrationMapper {
    RegistrationResponse toResponse(Registration Registration);

    @Mapping(target = "id", ignore = true)
    Registration toEntity(CreateRegistrationRequest request);

    @Mapping(target = "id", ignore = true)
    Registration toEntity(UpdateRegistrationRequest request);

    @Mapping(target = "id", ignore = true)
    void updateEntity(UpdateRegistrationRequest request, @MappingTarget Registration registration);
}
