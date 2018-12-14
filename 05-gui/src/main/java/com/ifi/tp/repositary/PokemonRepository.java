package com.ifi.tp.repositary;

import com.ifi.tp.entity.Pokemonentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemonentity,Integer> {


}