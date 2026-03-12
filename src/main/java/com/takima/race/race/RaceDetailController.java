package com.takima.race.race;

import org.springframework.http.HttpStatus;
import com.takima.race.registration.Registration;
import com.takima.race.registration.RegistrationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/races/{id}")
public class RaceDetailController {
    private final RaceService raceService;
    private final RegistrationService registrationService;

    public RaceDetailController(RaceService raceService, RegistrationService registrationService) {
        this.raceService = raceService;
        this.registrationService = registrationService;
    }

    @GetMapping()
    public Race getById(@PathVariable Long id) {
        return raceService.getById(id);
    }

    @PostMapping("/registrations")
    @ResponseStatus(HttpStatus.CREATED)
    public Registration register(@RequestBody Long runnerId, @PathVariable Long raceId) {
        return registrationService.create(new Registration(runnerId, raceId));
    }

    @DeleteMapping()
    public void deleteById(@PathVariable Long id) {
            raceService.deleteById(id);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public Race update(@PathVariable Long id, @RequestBody Race race) {
        return raceService.update(race);
    }
}
