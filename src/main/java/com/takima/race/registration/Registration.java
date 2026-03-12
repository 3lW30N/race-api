package com.takima.race.registration;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "registration", schema = "public", uniqueConstraints = {
        @UniqueConstraint(name = "unique_registration", columnNames = {"runner_id", "race_id"})
})
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "runner_id", nullable = false)
    private Long runnerId;

    @Column(name = "race_id", nullable = false)
    private Long raceId;

    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    public Registration(Long runnerId, Long raceId) {
        this.runnerId = runnerId;
        this.raceId = raceId;
        this.registrationDate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(Long runnerId) {
        this.runnerId = runnerId;
    }

    public Long getRaceId() {
        return raceId;
    }

    public void setRaceId(Long raceId) {
        this.raceId = raceId;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

}