package com.schallerl;

import java.io.Serializable;

/**
 * Created by Katharina on 15.03.2017.
 */
public abstract class Weapon extends Item implements Serializable {


    private String material;
    private int lenght;

    public Weapon(String name, int cost, int hitpoints, int weight, String material, int length){
        super(name, cost, hitpoints, weight);
        this.material = material;
        this.lenght = length;
    }

    public int getLenght() {
        return lenght;
    }

    public String getMaterial(){
        return material;
    }

    public abstract void attack();

    @Override
    public String toString() {
        return "Weapon{" +
                "material='" + material + '\'' +
                ", length=" + lenght +
                "} " + super.toString();
    }
}
