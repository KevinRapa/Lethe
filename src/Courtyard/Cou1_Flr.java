package Courtyard;

import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;

public class Cou1_Flr extends Furniture {
    private final Furniture REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Cou1_Flr(Furniture hole, Item ... items) {
            super(items);
            this.REF = hole;
            this.description = "The ground is a mixture of grass, weeds, and clover.\n"
                             + "The ground is roughened, as if someone had dug it up recently.";
            this.searchDialog = "You crouch down and scan the ground.";
            this.actDialog = "You have nothing to dig the ground with.";
            this.useDialog = "You dig about a foot-deep hole in the ground. In the hole,\n"
                           + "you uncover something.";
            this.addActKeys("dig", "shovel");
            this.addUseKeys("shovel", "trowel");
            this.addNameKeys("floor", "ground");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (Player.getRoomRef("COU1").hasFurniture("hole"))
            return "The ground is a mixture of grass, weeds, and clover, interrupted\n"
                 + "by the small hole you dug.";
        else
            return this.description;
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        if (Player.getRoomRef("COU1").hasFurniture("hole"))
            return "You have already dug up the ground here.";
        else {
            Player.getRoomRef("COU1").addFurniture(REF);
            return this.useDialog;
        }
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String interact(String key) {              
        if (Player.doYouHaveIt("shovel") || Player.doYouHaveIt("trowel"))
            return this.useEvent(Player.getItem(""));
        else
            return "You have nothing suitable to dig the ground with.";
    }
/*----------------------------------------------------------------------------*/ 
}
