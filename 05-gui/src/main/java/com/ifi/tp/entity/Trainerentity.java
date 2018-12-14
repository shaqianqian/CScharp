package com.ifi.tp.entity;

import com.ifi.tp.trainers.bo.Pokemon;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Trainerentity")
public class Trainerentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String name;
    private int gold;
    private int medicine;

//    @OneToMany(fetch= FetchType.LAZY,cascade={CascadeType.ALL})
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="trainerentityId")
    private List<Pokemandetrainerentity> team;

    @Lob
    private String picture;

    public Trainerentity() {
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getMedicine() {
        return medicine;
    }

    public void setMedicine(int medicine) {
        this.medicine = medicine;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pokemandetrainerentity> getTeam() {
        return team;
    }

    public void setTeam(List<Pokemandetrainerentity> team) {
        this.team = team;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
