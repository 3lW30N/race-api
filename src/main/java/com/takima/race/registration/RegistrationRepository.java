package com.takima.race.registration;

import com.takima.race.race.Race;
import com.takima.race.runner.Runner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    public List<Race> findRacesByRunnerId(Long runnerId);
    public List<Runner> findRunnersByRaceId(Long raceId);
}