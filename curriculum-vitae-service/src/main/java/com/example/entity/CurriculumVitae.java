package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "cvs")
@Data
public class CurriculumVitae {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private UUID uuid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    @JsonIgnore
    private Country country;

    @Column(nullable = true)
    private String city;

    @Column(name = "is_ready_to_relocate")
    private boolean isReadyToRelocate;

    @Column(name = "is_ready_for_remote_work")
    private boolean isReadyForRemoteWork;

    private String status;

}