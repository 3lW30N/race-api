package com.takima.race.race.dto;

import java.time.LocalDate;

// POST /races
public record CreateRaceRequest (
        String name,
        LocalDate date,
        String location,
        int maxParticipants) {
}