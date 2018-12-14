package com.ifi.tp.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ifi.tp.entity.Pokemonentity;

import com.ifi.tp.pokemonTypes.bo.PokemonType;
import com.ifi.tp.repositary.PokemonRepository;
import com.ifi.tp.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonServiceImpl implements PokemonService {

    private RestTemplate restTemplate;

    private String pokemonServiceUrl;

    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    public PokemonServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
//    public List<Pokemonentity> listPokemonsTypes() {
        public List<PokemonType> listPokemonsTypes() {
        var url = pokemonServiceUrl + "/pokemons";
        var pokemons = restTemplate.getForObject(url, PokemonType[].class);
        List<PokemonType> pokemonTypesList = new ArrayList<PokemonType>();
        pokemonTypesList = Arrays.asList(pokemons);
        return pokemonTypesList;
//        List<Pokemonentity> pokemonentityList = new ArrayList<Pokemonentity>();
////        return Arrays.asList(pokemons);
////        return pokemonRepository.findAll();
//        for (PokemonType pokemonType : pokemonTypesList) {
//            Pokemonentity pokemonEntity = new Pokemonentity();
//            pokemonEntity.setId(pokemonType.getId());
//            pokemonEntity.setId(pokemonType.getId());
//            pokemonEntity.setName(pokemonType.getName());
//            pokemonEntity.setWeight(pokemonType.getWeight());
//            pokemonEntity.setBaseExperience(pokemonType.getBaseExperience());
//            pokemonEntity.setHeight(pokemonType.getHeight());
//            pokemonEntity.setBack_default(pokemonType.getSprites().getBack_default());
//            pokemonEntity.setFront_default(pokemonType.getSprites().getFront_default());
//            pokemonEntity.setSpeed(pokemonType.getStats().getSpeed());
//            pokemonEntity.setSpecialAttack(pokemonEntity.getSpecialAttack());
//            pokemonEntity.setSpecialDefence(pokemonEntity.getSpecialDefence());
//
//
//            pokemonEntity.setDefense(pokemonType.getStats().getDefense());
//            pokemonEntity.setAttack(pokemonType.getStats().getAttack());
//            pokemonEntity.setHp(pokemonType.getStats().getHp());
//            pokemonentityList.add(pokemonEntity);
//
//        }
//        return pokemonentityList;
    }

    @Override
    public Pokemonentity getPokemonType(int id) {
        var url = pokemonServiceUrl + "/pokemons/{id}";
        PokemonType pokemonType = restTemplate.getForObject(url, PokemonType.class, id);
        Pokemonentity pokemonEntity = new Pokemonentity();
        pokemonEntity.setId(pokemonType.getId());
        pokemonEntity.setName(pokemonType.getName());
        pokemonEntity.setWeight(pokemonType.getWeight());
        pokemonEntity.setBaseExperience(pokemonType.getBaseExperience());
        pokemonEntity.setHeight(pokemonType.getHeight());
        pokemonEntity.setBack_default(pokemonType.getSprites().getBack_default());
        pokemonEntity.setFront_default(pokemonType.getSprites().getFront_default());
        pokemonEntity.setSpeed(pokemonType.getStats().getSpeed());
        pokemonEntity.setSpecialAttack(pokemonEntity.getSpecialAttack());
        pokemonEntity.setSpecialDefence(pokemonEntity.getSpecialDefence());
        pokemonEntity.setDefense(pokemonType.getStats().getDefense());
        pokemonEntity.setAttack(pokemonType.getStats().getAttack());
        pokemonEntity.setHp(pokemonType.getStats().getHp());
        return pokemonEntity;
//        return restTemplate.getForObject(url, PokemonType.class, id);
//        return pokemonRepository.getOne(id);
    }

    @Value("${pokemon.service.url}")
    void setPokemonServiceUrl(String pokemonServiceUrl) {
        this.pokemonServiceUrl = pokemonServiceUrl;
    }
}
