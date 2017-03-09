package Vault;

import A_Main.AudioPlayer;
import A_Super.Item;
import A_Super.Moveable;
import java.util.Random;
import A_Super.Openable;
import A_Super.SearchableFurniture;

public class Vau_Chsts extends SearchableFurniture implements Openable, Moveable {
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
    @Override public String moveIt() {
        AudioPlayer.playEffect(44);
        return "You move the chest over a bit... Nope, just more treasure underneath.";
    }
    // ========================================================================  
}


