package com.schallerl;

import java.io.Serializable;

/**
 * Created by Katharina on 16.03.2017.
 */
public class Accessory extends Item implements Serializable {

    private String material;

    public Accessory(String name, int cost, int hitpoints, int weight, String material) {
        super(name, cost, hitpoints, weight);
        this.material = material;
    }

    @Override
    public String toString() {
        return "Accessory{" +
                "material='" + material + '\'' +
                "} " + super.toString();
    }
}
