package com.takima.race.race;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "race", schema = "public")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "race_id_gen")
    @SequenceGenerator(name = "race_id_gen", sequenceName = "race_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "max_participants", nullable = false)
    private Integer maxParticipants;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(Integer maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

}