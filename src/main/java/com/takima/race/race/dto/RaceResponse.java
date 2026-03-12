package com.takima.race.race.dto;

import java.util.Date;

public record RaceResponse (
    Long id,
    String name,
    Date date,
    String location,
    int maxParticipants
) { }
