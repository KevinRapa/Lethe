package Back_Balcony;

import A_Super.Furniture;
/**
 * @author Kevin Rapa
 */
public class Bba_Cliff extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Bba_Cliff() {
        super();
        this.description = "The cliff has a steep incline. To your discomfort, "
                         + "you spot an eerie body in a pocket of rocks on it.";
        this.actDialog = "You haven't reached that point yet. Hang in there!";
        this.searchDialog = "You aren't jumping down there like that last person "
                          + "did.";
        
        this.addActKeys("jump", "climb", "vault");
        this.addNameKeys("cliff", "drop");
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {
        if (key.equals("jump"))
            return this.actDialog;
        else
            return "You're too heavy for that, and the cliff is too vertical. Good idea though.";
    }
//-----------------------------------------------------------------------------
}