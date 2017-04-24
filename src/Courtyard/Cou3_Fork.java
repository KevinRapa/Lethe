package Courtyard;

import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;

public class Cou3_Fork extends Furniture {
    private final Item FORK;
    //---------------------------------------------------------------------
    public Cou3_Fork (Item fork) {
        super();

        this.FORK = fork;

        this.actDialog = "A clever decision by the player is rewarded with a "
                + "breathtaking treasure of artisanal mastery.";
        this.description = "The fork in the path leads to both the left "
                + "and right halves of the courtyard.";

        this.addNameKeys("fork");
        this.addActKeys(GETPATTERN, "pick");
    }
    //---------------------------------------------------------------------   
    @Override public String interact(String key) {  
        if (Player.getInv().add(FORK)) {
            Player.getPos().removeFurniture(this);
            return this.actDialog;
        }
        else
            return NOTHING;
    }
    //---------------------------------------------------------------------      
}

