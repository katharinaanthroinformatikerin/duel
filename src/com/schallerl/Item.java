package com.schallerl;

import java.io.*;

/**
 * Created by Katharina on 13.03.2017.
 */
public abstract class Item implements Cloneable, Serializable {

    private String name;//eg Longsword
    private int cost;

    private int hitpoints;
    //private int length;
    private int weight;

    //private Point2D location;
    //private User owner;
    //private String color;

    public Item(String name, int cost, int hitpoints, int weight) {
        this.name = name;
        this.cost = cost;
        this.hitpoints = hitpoints;
        this.weight = weight;
    }

    public String getName(){
        return name;
    }

    public int getCost(){
        return cost;
    }

    //public int getHitpoints(){
        //return hitpoints;
    //}

    //public int getLength(){
       // return length;
    //}

    public int getWeight(){
        return weight;
    }



    public void setName(String name){
        this.name = name;
    }

    public void setCost(int cost){
        this.cost = cost;
    }

    public void setHitpoints(int hit){
        hitpoints = hit;
    }

    /*public void setLength(int len){
        length = len;
    }*/

    public void setWeight(int kilos){
        weight = kilos;
    }


   /*
    @Override
    public Object clone(){
        Item clone = null;

        try {
            clone = (Item) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }*/


    @Override
    public Item clone() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (Item)ois.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", hitpoints=" + hitpoints +
                ", weight=" + weight +
                '}';
    }
}
