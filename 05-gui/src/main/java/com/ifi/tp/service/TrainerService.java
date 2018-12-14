package com.ifi.tp.service;

import java.util.List;

import com.ifi.tp.entity.Pokemandetrainerentity;
import com.ifi.tp.entity.Trainerentity;
import com.ifi.tp.trainers.bo.Trainer;

public interface TrainerService {

//    List<Trainer> getAllTrainers();
    List<Trainerentity> getAllTrainers();

    Trainerentity getTrainer(String name);

    Pokemandetrainerentity deuxPokemonsDebat(Pokemandetrainerentity pokemandetrainerentity1, Pokemandetrainerentity pokemandetrainerentity2,int debatId);

    List<Pokemandetrainerentity>  deuxListPokemonsDebat(List<Pokemandetrainerentity> pokemandetrainerentity1, List<Pokemandetrainerentity> pokemandetrainerentity2,int debatId);
}
