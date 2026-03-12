package com.takima.race.race;

import com.takima.race.race.dto.CreateRaceRequest;
import com.takima.race.race.dto.RaceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/races")
public class RaceController {
    private final RaceService raceService;
    private final RaceMapper raceMapper;

    public RaceController(RaceService raceService, RaceMapper raceMapper) {
        this.raceService = raceService;
        this.raceMapper = raceMapper;
    }

    @GetMapping
    public List<Race> getAll() {
        return raceService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RaceResponse create(@RequestBody CreateRaceRequest createRaceRequest) {
        Race createdRace = raceService.create(createRaceRequest);
        return raceMapper.toResponse(createdRace);
    }
}
