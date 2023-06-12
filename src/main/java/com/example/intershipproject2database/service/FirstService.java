package com.example.intershipproject2database.service;


import com.example.intershipproject2database.entity.dbone.Indicators;
import com.example.intershipproject2database.repositories.dbone.FirstIndicatorsRepository;
import com.example.intershipproject2database.repositories.dbtwo.SecondIndicators2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirstService {
    private final FirstIndicatorsRepository firstRepository;
    private static final String BASE_PACKAGE = "com.example.intershipproject2database";
    @Autowired
    public FirstService(FirstIndicatorsRepository firstRepository) {
        this.firstRepository = firstRepository;
    }
    public FirstService(){
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(BASE_PACKAGE);
        firstRepository = context.getBean(FirstIndicatorsRepository.class);
    }

    public List<Indicators> findAllIndicators(){
        return firstRepository.findAll();
    }
}
