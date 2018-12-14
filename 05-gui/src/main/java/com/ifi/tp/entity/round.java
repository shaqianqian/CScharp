package com.ifi.tp.entity;

import javax.persistence.*;

@Entity
@Table(name="round")
public class round {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private int id_attack;
    private int id_isattacked;
    private int losthp;
    private int debat_id;

    public int getDebat_id() {
        return debat_id;
    }

    public void setDebat_id(int debat_id) {
        this.debat_id = debat_id;
    }

    public round() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getId_attack() {
        return id_attack;
    }

    public void setId_attack(int id_attack) {
        this.id_attack = id_attack;
    }

    public int getId_isattacked() {
        return id_isattacked;
    }

    public void setId_isattacked(int id_isattacked) {
        this.id_isattacked = id_isattacked;
    }

    public int getLosthp() {
        return losthp;
    }

    public void setLosthp(int losthp) {
        this.losthp = losthp;
    }


}
