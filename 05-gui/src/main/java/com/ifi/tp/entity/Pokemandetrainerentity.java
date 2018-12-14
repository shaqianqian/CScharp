package com.ifi.tp.entity;

import com.ifi.tp.trainers.bo.Pokemon;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Pokemandetrainerentity ")
public class Pokemandetrainerentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    private int pokemonNumber;

    private int level;



    public Pokemonentity getType() {
        return type;
    }

    public void setType(Pokemonentity type) {
        this.type = type;
    }

    private int hp;

//   @Column(name="trainerentityId")
//    private Integer trainerentityId;

//    public Integer getTrainerentityId() {
//        return trainerentityId;
//    }
//
//    public void setTrainerentityId(Integer trainerentityId) {
//        this.trainerentityId = trainerentityId;
//    }

    @ManyToOne
    @JoinColumn(name="typeId")//
    private Pokemonentity type;

//    @ManyToOne
//    @JoinColumn(name="trainerentityId",insertable = false,updatable = false)//
//    private Trainerentity trainerentity;


    public Pokemandetrainerentity() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getHpPercent(){
        return 100 * this.hp / (this.type.getHp()+this.level);
    }
    public int getFullHp(){
        return this.level+this.getType().getHp();
    }
    public int getDefenseCurrent(){
        return this.level+this.getType().getDefense();

    }

    public int getSpeedCurrent(){
        return this.level+this.getType().getSpeed();

    }
    public int getAttackCurrent(){
        return this.level+this.getType().getAttack();

    }


//    public Trainerentity getTrainerentity() {
//        return trainerentity;
//    }
//
//    public void setTrainerentity(Trainerentity trainerentity) {
//        this.trainerentity = trainerentity;
//    }
}
