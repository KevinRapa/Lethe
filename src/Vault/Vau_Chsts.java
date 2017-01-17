package Vault;

import A_Super.Furniture;
import A_Super.Item;
import java.util.Random;
import A_Super.Openable;

public class Vau_Chsts extends Furniture implements Openable {
    private final Item[] POSSIBILITIES;
    // ========================================================================
    public Vau_Chsts(Item ... items) {
        super();
        
        Random generator = new Random();
        
        this.POSSIBILITIES = items;
        this.description = "Scattered around the room are several wooden chests.";
        this.searchDialog = "You pick a few chests and look inside them.";

        this.addNameKeys("(?:wooden )?chests?");
        
        for (int i = 1; i <= 15; i++) {
            int index = generator.nextInt(this.POSSIBILITIES.length);
            this.inv.add(POSSIBILITIES[index]);
        }
    }
    // ========================================================================       
}


