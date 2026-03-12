package com.takima.race.registration;

import com.takima.race.race.Race;
import com.takima.race.race.RaceRepository;
import com.takima.race.registration.dto.UpdateRegistrationRequest;
import com.takima.race.runner.Runner;
import com.takima.race.runner.RunnerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final RunnerRepository runnerRepository;
    private final RaceRepository raceRepository;
    private final RegistrationMapper registrationMapper;

    public RegistrationService(RegistrationRepository registrationRepository, RunnerRepository runnerRepository, RaceRepository raceRepository, RegistrationMapper registrationMapper) {
        this.registrationRepository = registrationRepository;
        this.runnerRepository = runnerRepository;
        this.raceRepository = raceRepository;
        this.registrationMapper = registrationMapper;
    }

    public List<Registration> getAll() {
        return registrationRepository.findAll();
    }

    public Registration getById(Long id) {
        return registrationRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Registration %s not found", id)
                )
        );
    }

    public Registration create(Registration registration) {
        if (registration.getRunnerId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "runnerId is required"
            );
        }
        if (registration.getRaceId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "raceId is required"
            );
        }
        if (!runnerRepository.existsById(registration.getRunnerId())) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("Runner %s not found", registration.getRunnerId())
            );
        }
        if (!raceRepository.existsById(registration.getRaceId())) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("Race %s not found", registration.getRaceId())
            );
        }
        return registrationRepository.save(registration);
    }

    public void deleteById(Long id) {
        if (!registrationRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("Registration %s not found", id)
            );
        }
        registrationRepository.deleteById(id);
    }

    public Registration update(Long id, UpdateRegistrationRequest request) {
        Registration registration = registrationRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Registration %s not found", id)
                )
        );
        registrationMapper.updateEntity(request, registration);
        return registrationRepository.save(registration);
    }

    public List<Race> getRacesByRunnerId(Long runnerId) {
        Runner runner = runnerRepository.findById(runnerId).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Runner %s not found", runnerId)
                ));
        return registrationRepository.findRacesByRunnerId(runnerId);
    }

    public List<Runner> getRunnersByRaceId(Long raceId) {
        Race race = raceRepository.findById(raceId).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Runner %s not found", raceId)
                ));
        return registrationRepository.findRunnersByRaceId(raceId);
    }
}
