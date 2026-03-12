package com.takima.race.runner;

import com.takima.race.race.Race;
import com.takima.race.registration.RegistrationService;
import com.takima.race.runner.dto.CreateRunnerRequest;
import com.takima.race.runner.dto.UpdateRunnerRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/runners")
public class RunnerController {
    private final RunnerService runnerService;
    private final RegistrationService registrationService;
    private final RunnerMapper runnerMapper;

    public RunnerController(RunnerService runnerService, RegistrationService registrationService, RunnerMapper runnerMapper) {
        this.runnerService = runnerService;
        this.registrationService = registrationService;
        this.runnerMapper = runnerMapper;
    }

    @GetMapping
    public List<Runner> getAll() {
        return runnerService.getAll();
    }

    @GetMapping("/{id}")
    public Runner getById(@PathVariable Long id) {
        return runnerService.getById(id);
    }

    @GetMapping("/{id}/races")
    public List<Race> getRaces(@PathVariable Long id) {
        return registrationService.getRacesByRunnerId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Runner post(@RequestBody CreateRunnerRequest request) {
        Runner runner = runnerMapper.toEntity(request);
        return runnerService.create(runner);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        runnerService.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Runner update(@PathVariable Long id, @RequestBody UpdateRunnerRequest request) {
        Runner runner = runnerMapper.toEntity(request);
        return runnerService.update(id, runner);
    }
}
