package com.takima.race.runner.dto;

public record UpdateRunnerRequest(
        String firstName,
        String lastName,
        String email,
        int age
) {
}
