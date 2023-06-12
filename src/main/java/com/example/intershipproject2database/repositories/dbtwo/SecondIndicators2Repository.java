package com.example.intershipproject2database.repositories.dbtwo;

import com.example.intershipproject2database.entity.dbtwo.Indicators2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondIndicators2Repository extends JpaRepository<Indicators2,Long> {
}
