package com.lab6.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties; // Добавлено
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "specialists")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Specialist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "specialist_specialization",
            joinColumns = @JoinColumn(name = "specialist_id"),
            inverseJoinColumns = @JoinColumn(name = "specialization_id")
    )
    @JsonIgnoreProperties("specialists") // Перемещено сюда
    private Set<Specialization> specializations;


    @OneToMany(mappedBy = "specialist", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("specialist") // Добавлено
    private Set<MedicalHistory> medicalHistories;
}
