package com.schallerl;

import com.schallerl.Item;

/**
 * Created by Katharina on 14.03.2017.
 */
public class Sword extends Weapon {

    @Override
    public String toString() {
        return "Sword{} " + super.toString();
    }

    public Sword(String name, int cost, int hitpoints, int weight, String material, int length) {
        super(name, cost, hitpoints, weight, material, length);
    }

    @Override
    public void attack() {
        //TODO implement attack method
    }

}
