package com.takima.race.race.dto;

import java.time.LocalDate;

// PUT /races/{id}
public record UpdateRaceRequest (
        String name,
        LocalDate date,
        String location,
        int maxParticipants
) {}