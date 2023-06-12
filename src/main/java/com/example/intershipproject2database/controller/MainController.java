package com.example.intershipproject2database.controller;

import com.example.intershipproject2database.entity.dbone.Indicators;
import com.example.intershipproject2database.entity.dbtwo.Indicators2;
import com.example.intershipproject2database.service.FirstService;
import com.example.intershipproject2database.service.SecondService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Controller
public class MainController {
   private final FirstService firstService;
   private final SecondService secondService;

    public MainController(FirstService firstService, SecondService secondService) {
        this.firstService = firstService;
        this.secondService = secondService;
    }

    @GetMapping("/indMain")
    public String printAllIndicators(Model model)
    {
        List<Indicators> indicatorsList = firstService.findAllIndicators();
        if(indicatorsList.size()==0){
            indicatorsList=null;
        }
        model.addAttribute("inds",indicatorsList);

        List<Indicators2> indicators2List = secondService.findAllEmployee();
        if(indicators2List.size()==0){
            indicators2List=null;
        }
        model.addAttribute("employee", indicators2List);
        return "main.html";
    }

    @GetMapping("/indicatorsFindByYear")
    public String findIndicatorsByYear(String inds, Model model) throws IOException {
        System.out.println("Год "+inds);
        int year = Integer.parseInt(inds);
        List<Indicators> allIndicators = firstService.findAllIndicators();
        Indicators indicators = new Indicators();
        int flag=0;
        for (int i=0; i<allIndicators.size();i++){
            if(allIndicators.get(i).getYear()==year){
                indicators = allIndicators.get(i);
                flag++;
            }
        }
        if (flag==0){
            indicators=null;
        }
        model.addAttribute("indicators",indicators);

        Gson gson = (new GsonBuilder()).setPrettyPrinting().create();
        FileWriter writer = new FileWriter("info.json");
        gson.toJson(indicators, writer);
        writer.close();
        return "indicators_year.html";
    }

    @GetMapping("/indicatorsFindBySurname")
    public String findEmployee(@RequestParam(name = "surname") String surname, Model model) throws IOException {
        System.out.println("Фамилия "+surname);

        List<Indicators2> allIndicators = secondService.findAllEmployee();
        Indicators2 indicators2 = new Indicators2();
        int flag=0;
        for (int i=0; i<allIndicators.size();i++){
            if(allIndicators.get(i).getSurname().equals(surname)){
                indicators2 = allIndicators.get(i);
                flag++;
            }
        }
        if (flag==0){
            indicators2=null;
        }
        model.addAttribute("employee",indicators2);
        Gson gson = (new GsonBuilder()).setPrettyPrinting().create();
        FileWriter writer = new FileWriter("info2.json");
        gson.toJson(indicators2, writer);
        writer.close();
        return "employee_surname.html";
    }


}
