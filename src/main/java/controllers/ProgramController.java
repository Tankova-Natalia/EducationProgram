package controllers;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import repositories.ProgramRepository;
import services.ProgramService;
import services.SubjectService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/programs")
public class ProgramController {


    @Autowired
    ProgramService service;

    @GetMapping(produces = "application/json")
    public @ResponseBody
    ResponseJSON findAll(){
        Filter filters = new Filter();
        List<String> subjects = service.findSubjectNames();
        List<String> chairs = service.findChairNames();
        List<Integer> years = service.findYears();
        List<String> specialties = service.findSpecialtyNames();
        List<String> degrees = service.findDegrees();
        filters.setChair(chairs);
        filters.setDegree(degrees);
        filters.setSpecialty(specialties);
        filters.setYear(years);
        filters.setSubject(subjects);
        List<Program> programs = service.findAll();
        ResponseJSON response = new ResponseJSON(programs, filters);
        return response;
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public @ResponseBody
    Program findById(@PathVariable("id") int id, Model model){
        Program program = service.findById(id);
        System.out.println(program);
        model.addAttribute("program", program);
        return program;
    }
}