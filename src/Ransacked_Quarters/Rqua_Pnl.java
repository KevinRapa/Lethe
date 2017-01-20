package Ransacked_Quarters;

import A_Main.AudioPlayer;
import static A_Main.NameConstants.CROWBAR;
import A_Main.Player;
import A_Super.Item;
import A_Super.Key;
import A_Super.Furniture;

public class Rqua_Pnl extends Furniture {
    private boolean lifted;
    private final Key STUDKEY_REF;
    private final Rqua_Bd BED_REF;
/*----------------------------------------------------------------------------*/    
    public Rqua_Pnl(Key studKey, Furniture bed) {
            super();
            this.lifted = false;
            this.searchable = false;
            this.STUDKEY_REF = studKey;
            this.BED_REF = (Rqua_Bd)bed;
            this.description = "The tile underneath the bed looks loose.";
            this.searchDialog = "You'll have to lift this up first.";
            this.actDialog = "It's too heavy and awkward to remove with your hands.\n"
                                + "You'll need to find something to pry this up.";
            this.useDialog = "The crowbar fits! You successfully remove the tile,\n"
                           + "revealing a small molded key.\n"
                           + "You put the molded key into your inventory.";
            this.addNameKeys("tile", "panel");
            this.addActKeys("pry", "move", "lift", "remove");
            this.addUseKeys(CROWBAR);
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        String rep = "You have already removed the tile.";
        
        if (! this.lifted && BED_REF.isMoved()) {
            rep = this.useDialog;
            this.lifted = true;
            Player.getKeys().add(STUDKEY_REF);
            AudioPlayer.playEffect(3);
        }
        else if (! BED_REF.isMoved())
            rep = "You fully intend to do that, but there is a bed in the way.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {     
        if (BED_REF.isMoved() && ! this.lifted)
            return this.actDialog;
        else if (BED_REF.isMoved() && this.lifted)
            return "You have already lifted the tile.";
        
        return "You will try that, but there is a bed in the way.";
    }
/*----------------------------------------------------------------------------*/
}

