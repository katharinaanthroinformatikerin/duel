package com.schallerl;

import com.schallerl.singleton.ItemRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katharina on 22.03.2017.
 */
public class TreasureChest extends Item {

    private List<Item> contents;

    public TreasureChest(String name, int cost, int hitpoints, int weight) {
        super(name, cost, hitpoints, weight);
        contents = new ArrayList<>();
        ItemRegistry ir = ItemRegistry.getInstance();
        Item sword = ItemRegistry.getInstance().getItem("longsword");
        contents.add(sword);
        contents.add(ItemRegistry.getInstance().getItem("stoneaxe"));
    }

    public Item takeItem(){
        return contents.remove(0);
    }

    public int getNumberOfItems(){
        return this.contents.size();
    }
}
