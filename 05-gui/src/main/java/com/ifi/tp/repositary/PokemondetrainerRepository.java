package com.ifi.tp.repositary;

import com.ifi.tp.entity.Pokemandetrainerentity;
import com.ifi.tp.entity.Pokemonentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemondetrainerRepository extends JpaRepository<Pokemandetrainerentity,Integer> {


}