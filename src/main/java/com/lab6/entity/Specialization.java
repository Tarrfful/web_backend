package com.lab6.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "specializations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @ManyToMany(mappedBy = "specializations")
    @JsonIgnore //можно использовать @JsonIgnoreProperties("specializations")
    private Set<Specialist> specialists; //Лучше использовать @JsonIgnore, так как мы игнорируем всю коллекцию
}