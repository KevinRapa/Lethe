package East_Outer_Wall;

import Super.Furniture;
import Super.Item;
import Main.Player;

public class Water extends Furniture {
    private final Item REF2;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Water(Item bckt) {
        super();
        this.REF2 = bckt;
        this.searchable = false;
        this.description = "Clean, sparkling water.";
        this.searchDialog = "Just clean H2O here.";
        this.useDialog = "You dip the bucket in and fill it with water.";
        this.addActKeys("drink", "swim");
        this.addNameKeys("water", "clear water");
        this.addUseKeys("metal bucket");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        Player.getINV().remove(item);
        Player.getINV().add(REF2);
        
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) { 
        String rep = "You take a sip of water and feel refreshed. Carrying\n"
                   + "all that stuff around has tired you.";
        
        if (key.matches("swim"))
            rep = "Now is NOT the time for a swim, though it's tempting. You\n"
                + "don't even have a change of clothes, and you aren't wearing\n"
                + "servant's garb.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}
