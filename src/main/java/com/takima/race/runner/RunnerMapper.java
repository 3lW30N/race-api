package com.takima.race.runner;

import com.takima.race.runner.dto.CreateRunnerRequest;
import com.takima.race.runner.dto.RunnerResponse;
import com.takima.race.runner.dto.UpdateRunnerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RunnerMapper {
    RunnerResponse toResponse(Runner runner);

    @Mapping(target = "id", ignore = true)
    Runner toEntity(CreateRunnerRequest request);

    @Mapping(target = "id", ignore = true)
    Runner toEntity(UpdateRunnerRequest request);

}
