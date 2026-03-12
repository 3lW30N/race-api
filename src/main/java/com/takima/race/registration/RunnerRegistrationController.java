package com.takima.race.registration;

import com.takima.race.race.Race;
import com.takima.race.runner.RunnerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/runners/{id}/registrations")
public class RunnerRegistrationController {
    private final RegistrationService registrationService;

    public RunnerRegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public List<Race> getRacesByRunnerId(@PathVariable Long id) {
        return registrationService.getRacesByRunnerId(id);
    }
}
