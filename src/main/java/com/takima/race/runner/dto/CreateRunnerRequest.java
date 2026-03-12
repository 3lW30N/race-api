package com.takima.race.runner.dto;

public record CreateRunnerRequest(
        String firstName,
        String lastName,
        String email,
        int age
) {
}
