package Ransacked_Quarters;

import A_Main.AudioPlayer;
import static A_Main.Names.CROWBAR;
import A_Main.Player;
import A_Super.Item;
import A_Super.Key;
import A_Super.Furniture;
/**
 * Pried using a crowbar to give the player a key.
 * 
 * @author Kevin Rapa.
 */
public class Rqua_Panel extends Furniture {
    private boolean lifted;
    private final Key STUDKEY_REF;
    private final int BED_ID;
//-----------------------------------------------------------------------------    
    public Rqua_Panel(Key studKey, Furniture bed) {
            super();
            
            this.lifted = false;
            
            this.STUDKEY_REF = studKey;
            this.BED_ID = bed.getID();
            this.description = "The tile underneath the bed looks loose.";
            this.searchDialog = "You'll have to lift this up first.";
            this.actDialog = "It's too heavy and awkward to remove with your hands. "
                                + "You'll need to find something to pry this up.";
            this.useDialog = "The crowbar fits! You successfully remove the tile, "
                           + "revealing a small molded key which you take. The "
                           + "woman speaks: \"Now you will know his secret!!\"";
            this.addNameKeys("tile", "panel");
            this.addActKeys("pry", "move", "lift", "remove");
            this.addUseKeys(CROWBAR);
    }
//-----------------------------------------------------------------------------
    @Override public String useEvent(Item item) {
        String rep = "You have already removed the tile.";
        Rqua_Bed b = (Rqua_Bed)Player.getPos().getFurnRef(BED_ID);
        
        if (! this.lifted && b.isMoved()) {
            rep = this.useDialog;
            this.lifted = true;
            Player.addKey(STUDKEY_REF);
            AudioPlayer.playEffect(3);
        }
        else if (! b.isMoved())
            rep = "You fully intend to do that, but there is a bed in the way.";
        
        return rep;
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {     
        Rqua_Bed b = (Rqua_Bed)Player.getPos().getFurnRef(BED_ID);
        
        if (b.isMoved()) {
            return this.lifted ? 
                    "You have already lifted the tile." : this.actDialog;
        }
        
        return "You will try that, but there is a bed in the way.";
    }
//-----------------------------------------------------------------------------
}

