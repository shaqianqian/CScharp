package com.ifi.tp.bo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Trainer {

    @Id
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Pokemon> team;

    @Lob
    private String picture;

    private int gold;
    private int medecine;

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getMedecine() {
        return medecine;
    }

    public void setMedecine(int medecine) {
        this.medecine = medecine;
    }

    public Trainer() {
    }

    public Trainer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pokemon> getTeam() {
        return team;
    }

    public void setTeam(List<Pokemon> team) {
        this.team = team;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

}
