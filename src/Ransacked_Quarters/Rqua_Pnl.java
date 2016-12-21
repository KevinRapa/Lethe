package Ransacked_Quarters;

import Main.Player;
import Super.Item;
import Super.Key;
import Super.Furniture;

public class Rqua_Pnl extends Furniture {
    private boolean lifted;
    private final Key REF2;
    private final Rqua_Bd REF4;
    
    public Rqua_Pnl(Key studKey, Furniture bed) {
            super();
            this.lifted = false;
            this.searchable = false;
            this.REF2 = studKey;
            this.REF4 = (Rqua_Bd)bed;
            this.description = "The tile underneath the bed looks loose.";
            this.searchDialog = "You'll have to lift this up first.";
            this.interactDialog = "It's too heavy and awkward to remove with your hands.\n"
                        + "You'll need to find something to pry this up.";
            this.useDialog = "The crowbar fits! You successfully remove the tile,\n"
                           + "revealing a small molded key.\n"
                           + "You put the molded key into your inventory.";
            this.addNameKeys("tile", "panel");
            this.addActKeys("pry", "move", "lift", "remove");
            this.addUseKeys("crowbar");
    }
    
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        String rep = "You have already removed the tile.";
        
        if (this.lifted == false && REF4.isMoved()) {
            rep = this.useDialog;
            this.lifted = true;
            Player.getINV().add(REF2);
            Player.getMapRef()[3][5][1].removeFurniture(this);
        }
        else if (! REF4.isMoved())
            rep = "You fully intend to do that, but there is a bed in the way.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {     
        String rep = "You will try that, but there is a bed in the way.";
        
        if (REF4.isMoved())
            rep = this.interactDialog;
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
}

