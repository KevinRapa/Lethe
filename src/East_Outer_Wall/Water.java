package East_Outer_Wall;

import A_Main.AudioPlayer;
import A_Super.Furniture;
import A_Super.Item;
import A_Main.Player;
import static A_Main.Names.METAL_BUCKET;
import A_Super.Gettable;

public class Water extends Furniture implements Gettable {
    private final Item BUCKET_REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Water(Item bckt) {
        super();
        
        this.BUCKET_REF = bckt;

        this.description = "Clean, sparkling water.";
        this.searchDialog = "Just clean H2O here.";
        this.actDialog = "Now is NOT the time for a swim, though it's tempting. You "
                       + "don't even have a change of clothes, and you aren't wearing "
                       + "servant's garb.";
        this.useDialog = "You dip the bucket in and fill it with water.";
        
        this.addActKeys(GETPATTERN);
        this.addActKeys("drink", "swim", "jump", "dive");
        this.addNameKeys("water", "clear water", "H20");
        this.addUseKeys(METAL_BUCKET);
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        AudioPlayer.playEffect(42);
        Player.getInv().remove(item);
        Player.getInv().add(BUCKET_REF);
        
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) { 
        if (key.equals("swim") || key.equals("jump") || key.equals("dive"))
            return this.actDialog;
        else if (key.equals("drink"))
            return "You take a sip of water and feel refreshed. Carrying "
                 + "all that stuff around has tired you.";
        else
            return getIt();
    }
/*----------------------------------------------------------------------------*/
    @Override public String getIt() {
        if (Player.hasItem(METAL_BUCKET))
            return this.useEvent(Player.getInv().get(METAL_BUCKET));
        else
            return "You'll need an empty bucket...";
    }
/*----------------------------------------------------------------------------*/
}
