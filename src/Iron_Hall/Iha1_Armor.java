package Iron_Hall;

import static A_Main.Names.POLEARM;
import A_Super.Furniture;
import A_Super.Moveable;

public class Iha1_Armor extends Furniture implements Moveable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Iha1_Armor() {
        super();

        this.description = "It's plate armor holding a polearm. It stands "
                         + "gazing out the window.";
        this.actDialog = "You will probably get hurt trying to do that.";
        this.searchDialog = "You find a long polearm, but the gauntlet is "
                          + "gripping it too tightly to be pried open.";
        this.addActKeys("equip|wear", "pry|open", GETPATTERN);
        this.addNameKeys("(?:suit (?:of )?|plate )?armor", POLEARM, 
                "(?:armor )?suit|gauntlet|hand");
    }    
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {
        if (key.equals("equip") || key.equals("wear"))
            return this.actDialog;
        else
            return "The suit's grip is too firm to do that.";
    }
//-----------------------------------------------------------------------------
}
