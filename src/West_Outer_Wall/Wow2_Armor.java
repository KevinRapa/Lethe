package West_Outer_Wall;

import A_Main.Names;
import A_Super.Furniture;
import A_Super.Item;

public class Wow2_Armor extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Wow2_Armor() {
        super();

        this.description = "It's a suit of armor with its gauntlets pried open.";
        this.searchDialog = "It's not holding anything anymore.";
        this.actDialog = "You will probably get hurt trying to do that.";
        this.useDialog = "The suit of armor must be tired of holding things.";
        this.addNameKeys("(?:suit (?:of )?|plate )?armor", "(?:armor )?suit|gauntlet|hand");
        this.addUseKeys(ANYTHING);
        this.addActKeys("wear", "equip");
    }    
//-----------------------------------------------------------------------------
    @Override public String useEvent(Item item) {
        if (item.getType().equals(Names.WEAPON))
            return this.useDialog;
        else if (item.toString().equals(Names.BROKEN_WARHAMMER))
            return "The suit of armor is quite angry that you broke its warhammer.";
        else
            return DEFAULT_USE;
    }
//-----------------------------------------------------------------------------
}