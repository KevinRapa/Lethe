package Courtyard;

import A_Super.Furniture;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Cou_Castle extends Furniture implements Unmoveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Cou_Castle() {
        super();

        this.description = "The monstrous castle appears ghastly standing in the "
                         + "night. Scanning it thoroughly, you figure it to be "
                         + "about four or five stories tall. The castle looks to "
                         + "be composed of a central area and a wing on each side.";
        this.searchDialog = "Maybe you should go inside to do that.";
        this.actDialog = "Perhaps you should find the front door and go through that.";
        
        this.addActKeys("go", "climb", "escape");
        this.addNameKeys("(?:monstrous )?castle", "portico");
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {
        if (key.equals("go"))
            return this.actDialog;
        else if (key.equals("climb"))
            return "This is not a skill you possess.";
        else
            return "Ah! That's it, you win! You now rest comfortably at your "
                    + "home, sipping fine Islay scotch, reflecting on your "
                    + "triumphant victory. And then, your focus returns to reality.";
    }
//-----------------------------------------------------------------------------
}

