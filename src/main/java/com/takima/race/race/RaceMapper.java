package com.takima.race.race;

import com.takima.race.race.dto.CreateRaceRequest;
import com.takima.race.race.dto.RaceResponse;
import com.takima.race.race.dto.RaceSummary;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RaceMapper {

    RaceResponse toResponse(Race race);

    @Mapping(target = "id", ignore = true)
    Race toEntity(CreateRaceRequest request);

}
