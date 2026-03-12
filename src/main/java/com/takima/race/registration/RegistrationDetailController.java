package com.takima.race.registration;

import com.takima.race.registration.dto.RegistrationResponse;
import com.takima.race.registration.dto.UpdateRegistrationRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationDetailController {
    RegistrationService registrationService;
    RegistrationMapper registrationMapper;

    public RegistrationDetailController(RegistrationService registrationService, RegistrationMapper registrationMapper) {
        this.registrationService = registrationService;
        this.registrationMapper = registrationMapper;
    }

    @GetMapping("/{id}")
    public RegistrationResponse getById(@PathVariable Long id) {
        Registration registration = registrationService.getById(id);
        return registrationMapper.toResponse(registration);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        registrationService.deleteById(id);
    }

    @PutMapping("/{id}")
    public RegistrationResponse update(@PathVariable Long id, @RequestBody UpdateRegistrationRequest updateRegistrationRequest) {
        Registration updatedRegistration = registrationService.update(id, updateRegistrationRequest);
        return registrationMapper.toResponse(updatedRegistration);
    }
}
