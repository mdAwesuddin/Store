package com.awes.store.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "employees") //for table name
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {
    @Id //we have mark id as primary key in table
    @GeneratedValue(strategy = GenerationType.AUTO) // we have to tell how to generate id it is like auto increment
    private Long id;
    private String name;
    private LocalDate dateOfJoining;
    private boolean isActive;
}
