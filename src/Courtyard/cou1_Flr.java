package Courtyard;

import Super.Furniture;
import Super.Item;
import Main.Player;

public class cou1_Flr extends Furniture {
    private final Furniture REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public cou1_Flr(Furniture hole) {
            super();
            this.REF = hole;
            this.description = "The ground is a mixture of grass, weeds, and clover.\n"
                             + "The ground is roughened, as if someone had dug it up recently.";
            this.searchDialog = "You crouch down and scan the ground.";
            this.interactDialog = "You have nothing to dig the ground with.";
            this.useDialog = "You dig about a foot-deep hole in the ground. In the hole,\n"
                           + "you uncover something.";
            this.addActKeys("dig", "shovel");
            this.addUseKeys("shovel");
            this.addNameKeys("floor", "ground");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (Player.getMapRef()[3][4][4].hasFurniture("hole"))
            return "The ground is a mixture of grass, weeds, and clover, interrupted\n"
                 + "by the small hole you dug.";
        else
            return this.description;
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        if (Player.getMapRef()[3][4][4].hasFurniture("hole"))
            return "You have already dug up the ground here.";
        else {
            Player.getMapRef()[3][4][4].addFurniture(REF);
            return this.useDialog;
        }
    }
/*----------------------------------------------------------------------------*/ 
    @Override public String interact(String key) {              
        if (Player.doYouHaveIt(key))
            return this.useEvent(Player.getItem(key));
        else
            return this.useDialog;
    }
/*----------------------------------------------------------------------------*/ 
}
