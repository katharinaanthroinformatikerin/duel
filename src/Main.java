import com.schallerl.Item;
import com.schallerl.TreasureChest;
import com.schallerl.singleton.ItemRegistry;

/**
 * Created by Katharina on 14.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        ItemRegistry registry = ItemRegistry.getInstance();
        registry.createTreasureChests();

        Item longsword= registry.getItem("longsword");
        longsword.setName("Excalibur");

        Item otherlongsword = registry.getItem("longsword");
        otherlongsword.setName("Needle");

        Item anotherlongsword = registry.getItem("longsword");



        //Item dc = registry.getDeepClone(otherlongsword);
        //System.out.println(dc);

        System.out.println(longsword);//Beweis, geklont (immer anderes objekt)
        System.out.println(otherlongsword);//Beweis, geklont (immer anderes objekt)
        System.out.println(anotherlongsword);

        Item loot = registry.getRandomItem();
        System.out.println(loot.toString());

        Item firstanimal = registry.getItem("horse");
        System.out.println(firstanimal);

        Item accessory = registry.getItem("leathersaddle");
        System.out.println(accessory);

        System.out.println(registry.getRegisteredItemNames());



        TreasureChest treasureChest1 = (TreasureChest) registry.getItem("treasureChest");
        TreasureChest treasureChest2 = (TreasureChest) registry.getItem("treasureChest");

        treasureChest2.takeItem();

        System.out.println("Meine volle Schatzkiste: " + treasureChest1.getNumberOfItems());
        System.out.println("tja, Pech, Donald! " + treasureChest2.getNumberOfItems());

//        excalibur.setName("Excalibur");
//        System.out.println(excalibur);
//        Item test = registry.getItem(LONGSWORD);
//        System.out.println(test);
    }
}
