package com.ifi.tp.service;

import com.ifi.tp.entity.Pokemonentity;
import com.ifi.tp.pokemonTypes.bo.PokemonType;

import java.util.List;

public interface PokemonService {

    List<PokemonType> listPokemonsTypes() ;

    Pokemonentity getPokemonType(int id);

}
