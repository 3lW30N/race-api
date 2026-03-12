package com.takima.race.registration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public List<Registration> getAll() {
        return registrationService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Registration create(@RequestBody Registration registration) {
        return registrationService.create(registration);
    }
}
