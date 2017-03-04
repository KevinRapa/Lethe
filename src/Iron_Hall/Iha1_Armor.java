package Iron_Hall;

import static A_Main.NameConstants.POLEARM;
import A_Super.Furniture;
import A_Super.Gettable;

public class Iha1_Armor extends Furniture implements Gettable {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Iha1_Armor() {
        super();

        this.description = "It's plate armor holding a polearm. It stands\n"
                         + "gazing out the window.";
        this.actDialog = "You will probably get hurt trying to do that.";
        this.searchDialog = "You find a long polearm, but the gauntlet is\n"
                          + "gripping it too tightly to be pryed open.";
        this.addActKeys(GETPATTERN);
        this.addActKeys("equip", "wear", "pry", "open");
        this.addNameKeys("(suit of |plate )?armor", POLEARM, "(?:armor )?suit|gauntlet|hand");
    }    
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (key.equals("equip") || key.equals("wear"))
            return this.actDialog;
        else if (key.equals("pry") || key.equals("open"))
            return "The suit's grip is too firm to do that.";
        else
            return getIt();
    }
/*----------------------------------------------------------------------------*/
}
