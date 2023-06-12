package com.example.intershipproject2database.service;

import com.example.intershipproject2database.entity.dbtwo.Indicators2;
import com.example.intershipproject2database.repositories.dbone.FirstIndicatorsRepository;
import com.example.intershipproject2database.repositories.dbtwo.SecondIndicators2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecondService {
    private final SecondIndicators2Repository secondRepository;
    private static final String BASE_PACKAGE = "com.example.intershipproject2database";
    @Autowired
    public SecondService(SecondIndicators2Repository secondRepository) {
        this.secondRepository = secondRepository;
    }
    public SecondService(){
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(BASE_PACKAGE);
        secondRepository = context.getBean(SecondIndicators2Repository.class);
    }

    public List<Indicators2> findAllEmployee(){
        return secondRepository.findAll();
    }
}
