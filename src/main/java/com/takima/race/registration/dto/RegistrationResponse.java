package com.takima.race.registration.dto;

import java.time.LocalDate;

public record RegistrationResponse(
    Long id,
    Long runnerId,
    Long raceId,
    LocalDate registrationDate
) { }
