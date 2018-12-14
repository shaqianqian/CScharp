package com.ifi.tp.util;

import com.ifi.tp.entity.Pokemandetrainerentity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class debat {

    public static Pokemandetrainerentity deuxPokemonsDebat(Pokemandetrainerentity pokemandetrainerentity1, Pokemandetrainerentity pokemandetrainerentity2) {
        Logger log = LoggerFactory.getLogger(debat.class);
        Pokemandetrainerentity first = new Pokemandetrainerentity();
        Pokemandetrainerentity second = new Pokemandetrainerentity();
        if (pokemandetrainerentity1.getSpeedCurrent() >= pokemandetrainerentity2.getSpeedCurrent()) {

            first = pokemandetrainerentity1;
            second = pokemandetrainerentity2;


        } else {
            first = pokemandetrainerentity2;
            second = pokemandetrainerentity1;

        }
        while (first.getHp() >= 0) {

            second.setHp(second.getHp() + second.getDefenseCurrent() - first.getAttackCurrent());
            log.info(first.getId()+"attack"+second.getId()+" hp reste "+second.getHp());
            if (second.getHp() >= 0) {
                first.setHp(first.getHp() + first.getDefenseCurrent() - second.getAttackCurrent());
                log.info(second.getId()+"attack"+first.getId()+" hp reste "+first.getHp());
            } else {
                return first;
            }
        }

        return second;
}

}
