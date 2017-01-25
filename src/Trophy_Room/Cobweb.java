package Trophy_Room;

import A_Main.Player;
import A_Super.Furniture;
import A_Super.Gettable;
import A_Super.Item;

/**
 * @author Kevin Rapa
 */
public class Cobweb extends Furniture implements Gettable {
    private final Item COBWEB;
    // ========================================================================
    public Cobweb () {
        super();

        this.COBWEB = new Item("ball of cobweb", "It's now just a white sticky ball.", "What good would a balled-up cobweb serve?");
        
        this.description = "It's a sticky mess of cobwebs, thankfully without the spiders.";
        this.actDialog = "You grab some of the sticky matter.";
        this.searchDialog = "The cobwebs aren't hiding anything...";
        this.useDialog = "You ball up some of the cobwebs with it, but their are still a lot in this room.";

        this.addNameKeys("cobwebs?");
        this.addUseKeys(WEAPONS);
        this.addActKeys(GETKEYS);
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        return this.getIt();
    }
    // ========================================================================     
    @Override public String getIt() {
        if (Player.getInv().add(COBWEB))
            return this.actDialog;
        else
            return "You already have all the cobweb you will ever need.";
    }
    // ========================================================================     
}


