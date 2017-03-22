package com.schallerl;

import java.io.Serializable;

/**
 * Created by Katharina on 14.03.2017.
 */
public class Animal extends Item implements Serializable {

    private int maxage;

    public Animal(String name, int cost, int hitpoints, int weight, int maxage){
        super(name, cost, hitpoints, weight);
        this.maxage = maxage;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "maxage='" + maxage + '\'' +
                "} " + super.toString();
    }

}
