package com.takima.race.registration.dto;

import java.time.LocalDate;

public record UpdateRegistrationResponse(
        Long id,
        Long runnerId,
        Long raceId,
        LocalDate date
) {
}
