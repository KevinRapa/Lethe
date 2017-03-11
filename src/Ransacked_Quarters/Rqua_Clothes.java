package Ransacked_Quarters;

import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Rqua_Clothes extends Furniture {
    private final Item LINENS = new Item("wrinkled up sheet", "A carelessly thrown about bed linen that you found in the servant's wing.");
    // ========================================================================
    public Rqua_Clothes () {
        super();
        
        this.description = "Wrinkled sheets and clothes lie on the floor, tossed\n"
                         + "from the now emptied dresser.";
        this.actDialog = "It is not an appropriate time for dress-up.";
        this.searchDialog = "There isn't anything hidden inside the clothes.";

        this.addNameKeys("(?:scattered )?(?:clothes|linens?)");
        this.addActKeys(GETPATTERN);
        this.addActKeys("wear");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.equals("wear"))
            return this.actDialog;
        else if (Player.getInv().add(LINENS))
            return "You pick up one of the large scattered linens";
        else
            return "You already carry enough useless sundries.";
    }
    // ========================================================================       
}


