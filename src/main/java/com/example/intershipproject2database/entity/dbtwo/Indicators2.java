package com.example.intershipproject2database.entity.dbtwo;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "indicators2")
public class Indicators2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "salary")
    private float salary;

    @Column(name = "surname")
    private String surname;
}
