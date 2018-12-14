package com.ifi.tp.controller;

import com.ifi.tp.entity.Pokemandetrainerentity;
import com.ifi.tp.entity.Pokemonentity;
import com.ifi.tp.listener.Producter;
import com.ifi.tp.pokemonTypes.bo.PokemonType;
import com.ifi.tp.repositary.PokemonRepository;
import com.ifi.tp.repositary.PokemondetrainerRepository;
import com.ifi.tp.repositary.TrainerRepository;
import com.ifi.tp.service.TrainerService;
import com.ifi.tp.util.debat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.ifi.tp.util.debat.deuxPokemonsDebat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class TrainerControllerTest {
    @Autowired
    Producter producter;
    @Autowired
    PokemonRepository pokemonRepository;
    @Autowired
    TrainerRepository trainerRepository;
    @Autowired
    TrainerService trainerService;

    @Autowired
    PokemondetrainerRepository pokemondetrainerRepository;

    @Test
    void debat() {
      Pokemandetrainerentity p1=new Pokemandetrainerentity();
      p1.setLevel(0);
      p1.setHp(50);
      p1.setPokemonNumber(1);
      p1.setId(1);
      Pokemonentity type1=new Pokemonentity();

      type1.setAttack(30);
      type1.setDefense(30);
      type1.setHp(50);
      type1.setSpeed(10);
      p1.setType(type1);

        Pokemandetrainerentity p2=new Pokemandetrainerentity();
        p2.setLevel(0);
        p2.setHp(50);
        p2.setPokemonNumber(2);
        p2.setId(2);
        Pokemonentity type2=new Pokemonentity();
        type2.setAttack(50);
        type2.setDefense(30);
        type2.setHp(50);
        type2.setSpeed(50);

        p2.setType(type2);

        Pokemandetrainerentity gagne=trainerService.deuxPokemonsDebat(p1,p2,1);





    }

    @Test
    void deuxdebat() {
        List<Pokemandetrainerentity> pokemandetrainerentityList1=new ArrayList<Pokemandetrainerentity>();
        List<Pokemandetrainerentity> pokemandetrainerentityList2=new ArrayList<Pokemandetrainerentity>();
        Pokemandetrainerentity p1=new Pokemandetrainerentity();
        p1.setLevel(10);
        p1.setHp(50);
        p1.setPokemonNumber(1);
        p1.setId(1);
        Pokemonentity type1=new Pokemonentity();
        type1.setAttack(30);
        type1.setDefense(10);
        type1.setHp(50);
        type1.setSpeed(10);
        p1.setType(type1);

        Pokemandetrainerentity p2=new Pokemandetrainerentity();
        p2.setLevel(0);
        p2.setHp(50);
        p2.setPokemonNumber(2);
        p2.setId(2);
        Pokemonentity type2=new Pokemonentity();
        type2.setAttack(50);
        type2.setDefense(30);
        type2.setHp(50);
        type2.setSpeed(50);
        p2.setType(type2);
     pokemandetrainerentityList1.add(p1);
     pokemandetrainerentityList1.add(p2);


        Pokemandetrainerentity p3=new Pokemandetrainerentity();
        p3.setLevel(0);
        p3.setHp(60);
        p3.setPokemonNumber(3);
        p3.setId(3);
        Pokemonentity type3=new Pokemonentity();
        type3.setAttack(25);
        type3.setDefense(20);
        type3.setHp(60);
        type3.setSpeed(20);
        p3.setType(type3);


        Pokemandetrainerentity p4=new Pokemandetrainerentity();
        p4.setLevel(0);
        p4.setHp(50);
        p4.setPokemonNumber(4);
        p4.setId(4);
        Pokemonentity type4=new Pokemonentity();
        type4.setAttack(40);
        type4.setDefense(20);
        type4.setHp(50);
        type4.setSpeed(20);
        p4.setType(type4);
        pokemandetrainerentityList2.add(p3);
        pokemandetrainerentityList2.add(p4);
        Logger log = LoggerFactory.getLogger(debat.class);

        List<Pokemandetrainerentity> gagne=trainerService.deuxListPokemonsDebat(pokemandetrainerentityList1,pokemandetrainerentityList2,1);



    }
}