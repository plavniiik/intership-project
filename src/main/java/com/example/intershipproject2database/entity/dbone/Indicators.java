package com.example.intershipproject2database.entity.dbone;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "indicators")
public class Indicators {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "year")
    private int year;
    @Column(name = "output")
    private float output; //выпуск продукции
    @Column(name = "sales_of_products")
    private float sales_of_products;//реализация товарной продукции
    @Column(name = "release_costs")
    private float release_costs;//затраты на выпуск продукции
    @Column(name = "gross_profit")
    private float gross_profit;//валовая прибыль
    @Column(name = "return_on_sales")
    private float return_on_sales;//рентабельность от реализации товарной продукции
    @Column(name = "stuff")
    private float stuff; //численность персонала
    @Column(name = "average_salary")
    private float average_salary;//среднемесячная зарплата
}
