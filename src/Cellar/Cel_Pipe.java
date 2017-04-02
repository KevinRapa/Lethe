package Cellar;

import static A_Main.Names.WEAPON;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Cel_Pipe extends Furniture implements Unmoveable {

    // ========================================================================
    public Cel_Pipe () {
        super();
        
        this.description = 
                "The metal pipe is about 6 inches wide. It does not "
                + "sound as though anything is running through it.";
        this.actDialog = "For shame. That pipe did no harm unto you.";

        this.addNameKeys("(?:metal )?pipe");
        this.addUseKeys(ANYTHING);
        this.addActKeys("bust", "break");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        return this.actDialog;
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        return (item.getType().equals(WEAPON)) ? 
                this.actDialog : DEFAULT_USE;
    }
    // ========================================================================     
}


