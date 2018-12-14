package com.ifi.tp.trainers.bo;

import com.ifi.tp.entity.Pokemonentity;
import com.ifi.tp.pokemonTypes.bo.PokemonType;

public class Pokemon {

    private int pokemonNumber;

    private int level;

    private int hp;

//    private PokemonType type;
    private Pokemonentity type;

    public int getPokemonNumber() {
        return pokemonNumber;
    }

    public void setPokemonNumber(int pokemonNumber) {
        this.pokemonNumber = pokemonNumber;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Pokemonentity getType() {
        return type;
    }

    public void setType(Pokemonentity type) {
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHpPercent(){
        return 100 * this.hp / this.type.getHp();
    }
}
