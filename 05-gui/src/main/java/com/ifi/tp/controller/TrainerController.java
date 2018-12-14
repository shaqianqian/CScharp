package com.ifi.tp.controller;

import com.ifi.tp.entity.Pokemandetrainerentity;
import com.ifi.tp.entity.debat;
import com.ifi.tp.repositary.DebatRepository;
import com.ifi.tp.repositary.PokemonRepository;
import com.ifi.tp.repositary.TrainerRepository;
import com.ifi.tp.service.TrainerService;

import com.ifi.tp.trainers.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TrainerController {

    @Autowired
    private TrainerService trainerService;
    @Autowired
    PokemonRepository pokemonRepository;
    @Autowired
    TrainerRepository trainerRepository;
    @Autowired
    DebatRepository debatRepository;



    @GetMapping("/trainers")
    ModelAndView index() {
        var modelAndView = new ModelAndView("trainers");

        modelAndView.addObject("trainers", trainerService.getAllTrainers());

        return modelAndView;
    }

    @GetMapping("/trainers/{name}")
    ModelAndView index(@PathVariable String name) {
        var modelAndView = new ModelAndView("trainer");

        modelAndView.addObject("trainer", trainerService.getTrainer(name));

        return modelAndView;
    }

    @GetMapping("/debat")
    ModelAndView pokemanDebat(){


        var Trainer1=trainerRepository.findByName("sha").get();
        var Trainer2=trainerRepository.findByName("asa").get();

        List<Pokemandetrainerentity> pokemandetrainerentityList1=Trainer1.getTeam();
        List<Pokemandetrainerentity> pokemandetrainerentityList2=Trainer2.getTeam();
        debat debat=new debat();
        debatRepository.save(debat);
        int debatId=debat.getId();


        List<Pokemandetrainerentity> pokemandetrainerentityList=trainerService.deuxListPokemonsDebat(pokemandetrainerentityList1,pokemandetrainerentityList2,debatId);
//        for(Pokemandetrainerentity pokemandetrainerentity:pokemandetrainerentityList)
//        {
//            debat debat=new debat();
            debat=debatRepository.getOne(debatId);
            debat.setTrainerId(pokemandetrainerentityList.get(0).getId());

            debatRepository.save(debat);

     //  }



        var modelAndView = new ModelAndView("trainers");

        modelAndView.addObject("trainers", trainerService.getAllTrainers());

        return modelAndView;
    }
//



}
