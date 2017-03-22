package com.schallerl.singleton;

import com.schallerl.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;


/**
 * Created by Katharina on 14.03.2017.
 */
public class ItemRegistry {

    private static ItemRegistry ourInstance = new ItemRegistry();
    Map<String, Item> hm = null;

    public static synchronized ItemRegistry getInstance() {
        return ourInstance;
    }

    protected ItemRegistry() {
        this.hm = new HashMap<>();
        initialize();
    }

    public void createTreasureChests(){
        hm.put("treasureChest", new TreasureChest("Treasure", 1000, 100, 500));
    }

    //TODO this should read the config file
    private void initialize() {

        File propertiesFile = new File("C:/Users/Katharina/Documents/4_Semester/SWP/prototype/src/prototype.properties");
        Properties properties = new Properties();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(propertiesFile))) {
            properties.load(bis);
        } catch (Exception ex) {
            System.err.println();
        }

        // Sword genericLongsword = new Sword();

        for (Object okey : properties.keySet()) {
            final Item item;

            String key = (String) okey;
            String props = properties.getProperty(key);
            // System.out.println(props);
            String[] parts = props.split(",");

            String type = parts[0];

            if (type.equals("sword")) {
                // int cost, int hitpoints, int weight, String material, int length
                item = new Sword(key, Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]),
                        parts[4], Integer.parseInt(parts[5]));
            } else if (type.equals("axe")) {
                // int cost, int hitpoints, int weight, String material, int length
                item = new Axe(key, Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]),
                        parts[4], Integer.parseInt(parts[5]));
            //TODO implement case animal
            } else if (type.equals("animal")){
                //int cost, int hitpoints, int weight, int maxage
                item = new Animal(key, Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]),
                        Integer.parseInt(parts[4]));
            } else if (type.equals("accessory")){
                //int cost, int hitpoints, int weight, String material
                item = new Accessory(key, Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]),
                        parts[4]);
            } else {
                throw new RuntimeException("Unknown item " + key + " of type " + type);
            }

            hm.put(key, item);
        }

//        int count = 1;
//        String key = "Sword";
//        while (properties.getProperty(key + count) != null) {
//            String swordValue = properties.getProperty(key + count);
//
//            String[] swordConfig = swordValue.split(",");
//            genericLongsword.setAge(age);
//            genericLongsword.setCost(100);
//            genericLongsword.setName(swordConfig[0]);
//            genericLongsword.setHitpoints(-1);
//            genericLongsword.setLength(100);
//            genericLongsword.setMaterial("Steel");
//            genericLongsword.setType(LONGSWORD);
//            genericLongsword.setWeight(-1);
//
//            hm.put(LONGSWORD, genericLongsword);
//        }
    }

    public Item getItem(String itemType){
        return (Item) hm.get(itemType).clone();
    }



    public Item getRandomItem() {
        List<Item> allItems = new ArrayList<>(hm.values());
        int pos = new Random().nextInt(allItems.size());

        return allItems.get(pos).clone();
    }

    public Set<String> getRegisteredItemNames(){
        return hm.keySet();
    }
}
