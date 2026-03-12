package com.takima.race.race;

import com.takima.race.race.dto.CreateRaceRequest;
import com.takima.race.race.dto.RaceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RaceService {

    private final RaceRepository raceRepository;
    private final RaceMapper raceMapper;

    public RaceService(RaceRepository raceRepository, RaceMapper raceMapper) {
        this.raceRepository = raceRepository;
        this.raceMapper = raceMapper;
    }

    public List<Race> getAll() {
        return raceRepository.findAll();
    }

    public Race getById(Long id) {
        return raceRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Race %s not found", id)
                )
        );
    }

    public Race create(CreateRaceRequest createRaceRequest) {
        Race race = raceMapper.toEntity(createRaceRequest);
        return raceRepository.save(race);
    }

    public void deleteById(Long id) {
        if (!raceRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("Race %s not found", id)
            );
        }
        raceRepository.deleteById(id);
    }

    public Race update(Race race) {
        if (!raceRepository.existsById(race.getId())) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("Runner %s not found", race.getId())
            );
        }
        return raceRepository.save(race);
    }
}
