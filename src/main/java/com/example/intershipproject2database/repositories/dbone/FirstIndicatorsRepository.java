package com.example.intershipproject2database.repositories.dbone;

import com.example.intershipproject2database.entity.dbone.Indicators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstIndicatorsRepository extends JpaRepository<Indicators,Long> {
}
