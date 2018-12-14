package com.ifi.tp.controller;

import com.ifi.tp.entity.Pokemandetrainerentity;
import com.ifi.tp.entity.Pokemonentity;
import com.ifi.tp.entity.Trainerentity;
import com.ifi.tp.listener.Producter;
import com.ifi.tp.pokemonTypes.bo.PokemonType;
import com.ifi.tp.repositary.PokemonRepository;
import com.ifi.tp.repositary.TrainerRepository;
import com.ifi.tp.service.PokemonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class PokemonController {

    private PokemonService pokemonService;
    @Autowired
    Producter producter;
    @Autowired
    PokemonRepository pokemonRepository;
    @Autowired
    TrainerRepository trainerRepository;

    @Autowired
    PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemons")
    public ModelAndView pokemons(@RequestParam(defaultValue = "front") String view){
        var modelAndView = new ModelAndView("pokemons");

        modelAndView.addObject("pokemons", pokemonService.listPokemonsTypes());

        if("front".equals(view)){
            modelAndView.addObject("view_front", true);
        }
        else{
            modelAndView.addObject("view_back", true);
        }


        return modelAndView;
    }

    @GetMapping("/shopping/{name}")
    public ModelAndView shoppings(@RequestParam(defaultValue = "front") String view, @PathVariable String name){
        var modelAndView = new ModelAndView("shopping");
        modelAndView.addObject("username", name);
        modelAndView.addObject("pokemons", pokemonService.listPokemonsTypes());

        if("front".equals(view)){
            modelAndView.addObject("view_front", true);
        }
        else{
            modelAndView.addObject("view_back", true);
        }


        return modelAndView;
    }

    @PostMapping(value = "/buy")
    public ModelAndView buy( @RequestParam("id")  int id,@RequestParam("name") String name){
        Trainerentity trainerentity=trainerRepository.findByName(name).get();
        List<Pokemandetrainerentity> pokemandetrainerentityList=trainerentity.getTeam();
        Pokemonentity pokemonentity=pokemonRepository.getOne(id);
        Pokemandetrainerentity pokemandetrainerentity=new Pokemandetrainerentity();
        pokemandetrainerentity.setHp(pokemonentity.getHp());
        pokemandetrainerentity.setType(pokemonentity);
        pokemandetrainerentity.setPokemonNumber(id);
        pokemandetrainerentity.setLevel(0);
        pokemandetrainerentityList.add(pokemandetrainerentity);
        trainerentity.setTeam(pokemandetrainerentityList);
        trainerRepository.save(trainerentity);



        var modelAndView = new ModelAndView("index");
//        modelAndView.addObject("name", name);
//        modelAndView.addObject("pokemons", pokemonService.listPokemonsTypes());
//
//        if("front".equals(view)){
//            modelAndView.addObject("view_front", true);
//        }
//        else{
//            modelAndView.addObject("view_back", true);
//        }


        return modelAndView;
    }

}
