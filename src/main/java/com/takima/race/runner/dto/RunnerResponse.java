package com.takima.race.runner.dto;

public record RunnerResponse (
    Long id,
    String firstName,
    String lastName,
    String email,
    int age
) {}
