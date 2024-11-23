package com.lab6.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "medical_histories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    @JsonIgnoreProperties("medicalHistory") // Добавлено
    private Pet pet;


    @ManyToOne
    @JoinColumn(name = "specialist_id")
    @JsonIgnoreProperties("medicalHistories") // Добавлено
    private Specialist specialist;

    private String diagnosis;
    private String treatment;
    private LocalDateTime visitDate;

}