package com.ifi.tp.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ifi.tp.entity.Pokemandetrainerentity;
import com.ifi.tp.entity.Pokemonentity;
import com.ifi.tp.entity.Trainerentity;
import com.ifi.tp.entity.round;
import com.ifi.tp.repositary.PokemonRepository;
import com.ifi.tp.repositary.PokemondetrainerRepository;
import com.ifi.tp.repositary.RoundRepository;
import com.ifi.tp.repositary.TrainerRepository;

import com.ifi.tp.service.PokemonService;
import com.ifi.tp.service.TrainerService;
import com.ifi.tp.util.debat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TrainerServiceImpl implements TrainerService {

    private PokemonService pokemonService;

    private RestTemplate restTemplate;

    private String trainerServiceUrl;
    @Autowired
    TrainerRepository trainerRepository;
    @Autowired
    PokemonRepository pokemonRepository;
    @Autowired
    PokemondetrainerRepository pokemondetrainerRepository;
    @Autowired
    RoundRepository roundRepository;


    @Autowired
    TrainerServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Trainerentity> getAllTrainers() {
//        var url = trainerServiceUrl + "/trainers";
//         var trainers = restTemplate.getForObject(url, Trainer[].class);
        var trainers = trainerRepository.findAll();


//        for(int i=0; i<trainers.length;i++){
//            Trainerentity trainersEntity=new Trainerentity();
//
//            trainersEntity.setName(trainers[i].getName());
//            trainersEntity.setPicture("https://2.bp.blogspot.com/-ugYJLXU38Jk/V8rVR2J0tbI/AAAAAAAAAAs/ptBL-ZqUtgsBDY8cdlSQ-fBPO5HHxO8ngCLcB/s1600/pokemon-misty22.gif");
//            List<Pokemandetrainerentity> pokemandetrainerentityList=new ArrayList<Pokemandetrainerentity>();
//            for(Pokemon pokemon:trainers[i].getTeam()){
//                Pokemandetrainerentity pokemandetrainerentity=new Pokemandetrainerentity();
//                pokemandetrainerentity.setType(pokemonRepository.findById(pokemon.getPokemonNumber()).get());
//                pokemandetrainerentity.setHp(pokemon.getHp());
//                pokemandetrainerentity.setLevel(pokemon.getLevel());
//                pokemandetrainerentity.setPokemonNumber(pokemon.getPokemonNumber());
//                pokemandetrainerentityList.add(pokemandetrainerentity);
//
//            }
//            trainersEntity.setTeam(pokemandetrainerentityList);
//            trainerRepository.save(trainersEntity);
//        }
//
//         return Arrays.asList(trainers);
        return trainers;
    }

    @Override
    public Trainerentity getTrainer(String name) {
//        var url = trainerServiceUrl + "/trainers/{name}";
////        var trainer = restTemplate.getForObject(url, Trainer.class, name);
        var trainer = trainerRepository.findByName(name);
        return this.enrich(trainer.get());
    }


    private Trainerentity enrich(Trainerentity trainer) {
        trainer.getTeam()
                .stream()
                .forEach(pokemon -> pokemon.setType(pokemonService.getPokemonType(pokemon.getPokemonNumber())));
        return trainer;
    }

    @Value("${trainer.service.url}")
    void setTrainerServiceUrl(String pokemonServiceUrl) {
        this.trainerServiceUrl = pokemonServiceUrl;
    }

    @Autowired
    void setPokemonService(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @Override
    public Pokemandetrainerentity deuxPokemonsDebat(Pokemandetrainerentity pokemandetrainerentity1, Pokemandetrainerentity pokemandetrainerentity2,int debatId) {
        Logger log = LoggerFactory.getLogger(debat.class);
        Pokemandetrainerentity first = new Pokemandetrainerentity();
        Pokemandetrainerentity second = new Pokemandetrainerentity();
        if (pokemandetrainerentity1.getSpeedCurrent() >= pokemandetrainerentity2.getSpeedCurrent()) {

            first = pokemandetrainerentity1;
            second = pokemandetrainerentity2;


        } else {
            first = pokemandetrainerentity2;
            second = pokemandetrainerentity1;

        }
        while (first.getHp() >0) {
            if (second.getDefenseCurrent() < first.getAttackCurrent()) {
                if(second.getHp()<(first.getAttackCurrent() - second.getDefenseCurrent()))
                {second.setHp(0);}
                else{second.setHp(second.getHp() - (first.getAttackCurrent() - second.getDefenseCurrent()));}
                round round=new round();
                round.setId_attack(first.getId());
                round.setId_isattacked(second.getId());
                round.setLosthp(first.getAttackCurrent() - second.getDefenseCurrent());
                round.setDebat_id(debatId);
                roundRepository.save(round);

            }
            else{
                round round=new round();
                round.setId_attack(first.getId());
                round.setId_isattacked(second.getId());
                round.setLosthp(0);
                round.setDebat_id(debatId);
                roundRepository.save(round);

            }

            //else defense>attack le resulat change pas
            log.info(first.getId() + "attack" + second.getId() + " hp reste " + second.getHp());
            if (second.getHp() >0) {
                if (first.getDefenseCurrent() < second.getAttackCurrent()) {
                    if(first.getHp()<(second.getAttackCurrent() - first.getDefenseCurrent())){first.setHp(0);}
                    else{first.setHp(first.getHp() - (second.getAttackCurrent() - first.getDefenseCurrent()));}

                    round round=new round();
                    round.setId_attack(second.getId());
                    round.setId_isattacked(first.getId());
                    round.setLosthp(second.getAttackCurrent() - first.getDefenseCurrent());
                    round.setDebat_id(debatId);
                    roundRepository.save(round);
                }//else defense>attack le resulat change pas
                else{
                    round round=new round();
                    round.setId_attack(second.getId());
                    round.setId_isattacked(first.getId());
                    round.setLosthp(0);
                    round.setDebat_id(debatId);
                    roundRepository.save(round);

                }

                log.info(second.getId() + "attack" + first.getId() + " hp reste " + first.getHp());
            } else {


                log.info(first.getId() + " a gagne");
                return first;
            }
        }
        log.info(second.getId() + " a gagne");
        return second;
    }

    @Override
    public List<Pokemandetrainerentity> deuxListPokemonsDebat(List<Pokemandetrainerentity> pokemandetrainerentity1, List<Pokemandetrainerentity> pokemandetrainerentity2,int debatId) {
        Logger log = LoggerFactory.getLogger(debat.class);
        List<Pokemandetrainerentity> pokemandetrainerentityListTrash1=new ArrayList<Pokemandetrainerentity>();
        List<Pokemandetrainerentity> pokemandetrainerentityListTrash2=new ArrayList<Pokemandetrainerentity>();
        while (!pokemandetrainerentity1.isEmpty() && !pokemandetrainerentity2.isEmpty()) {
            Pokemandetrainerentity pokemandetrainerentity_winner = this.deuxPokemonsDebat(pokemandetrainerentity1.get(0), pokemandetrainerentity2.get(0),debatId);
            if (pokemandetrainerentity_winner.getId() == pokemandetrainerentity1.get(0).getId()) {
//             log.info("trainer2 est "+  pokemandetrainerentity2.get(0).getTrainerentity().getId());
                pokemandetrainerentityListTrash2.add(pokemandetrainerentity2.get(0));

                pokemandetrainerentity2.remove(pokemandetrainerentity2.get(0));

            } else if(pokemandetrainerentity_winner.getId() == pokemandetrainerentity2.get(0).getId())
            {
                pokemandetrainerentityListTrash1.add(pokemandetrainerentity1.get(0));
               // log.info("trainer gagne est "+  pokemandetrainerentity1.get(0).getTrainerentity().getId());
                pokemandetrainerentity1.remove(pokemandetrainerentity1.get(0));
            }

        }
//        if (!pokemandetrainerentity1.isEmpty() && !pokemandetrainerentity2.isEmpty()) {
//             return deuxListPokemonsDebat(pokemandetrainerentity1, pokemandetrainerentity2);
//
//
//
//
//        } else
//
            if (pokemandetrainerentity1.isEmpty() && !pokemandetrainerentity2.isEmpty()) {
            log.info("liste2 est gagant");

            for(Pokemandetrainerentity pokemandetrainerentity:pokemandetrainerentity2){
                log.info("les vivants sont"+pokemandetrainerentity.getId());

            }
            pokemandetrainerentity1.addAll(pokemandetrainerentityListTrash1);
            pokemandetrainerentity2.addAll(pokemandetrainerentityListTrash2);

                log.info("WARNING RETURN");
            return pokemandetrainerentity2;

        } else if (!pokemandetrainerentity1.isEmpty() && pokemandetrainerentity2.isEmpty()) {
            log.info("liste1 est gagant");
            for(Pokemandetrainerentity pokemandetrainerentity:pokemandetrainerentity1){
                log.info("les vivants sont"+pokemandetrainerentity.getId());

            }
                pokemandetrainerentity1.addAll(pokemandetrainerentityListTrash1);
                pokemandetrainerentity2.addAll(pokemandetrainerentityListTrash2);

                //TODO  UPDATE LE DONNEE EN MICRO SERvice

                log.info("WARNING RETURN");
            return pokemandetrainerentity1;
        }
        else return null;


    }

}
