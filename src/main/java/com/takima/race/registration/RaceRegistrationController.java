package com.takima.race.registration;

import com.takima.race.runner.Runner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/races/{id}/registrations")
public class RaceRegistrationController {
    private final RegistrationService registrationService;

    public RaceRegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public List<Runner> getRunnersByRaceId(@PathVariable Long id) {
        return registrationService.getRunnersByRaceId(id);
    }
}
