package com.ifi.tp.repositary;

import com.ifi.tp.entity.Pokemonentity;
import com.ifi.tp.entity.Trainerentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainerRepository extends JpaRepository<Trainerentity,Integer> {

//    Trainerentity findByName(String name);
    Optional<Trainerentity> findByName(String name);

}