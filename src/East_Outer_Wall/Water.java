package East_Outer_Wall;

import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;

public class Water extends Furniture {
    private final Item REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Water(Item bckt) {
        super();
        this.REF = bckt;
        this.searchable = false;
        this.description = "Clean, sparkling water.";
        this.searchDialog = "Just clean H2O here.";
        this.actDialog = "Now is NOT the time for a swim, though it's tempting. You\n"
                       + "don't even have a change of clothes, and you aren't wearing\n"
                       + "servant's garb.";
        this.useDialog = "You dip the bucket in and fill it with water.";
        this.addActKeys("drink", "swim");
        this.addNameKeys("water", "clear water");
        this.addUseKeys("metal bucket");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        Player.getInv().remove(item);
        Player.getInv().add(REF);
        
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) { 
        if (key.matches("swim"))
            return this.actDialog;
        
        return "You take a sip of water and feel refreshed. Carrying\n"
             + "all that stuff around has tired you.";
    }
/*----------------------------------------------------------------------------*/
}
