package Torture_Chamber;

import A_Main.Id;
import A_Main.Names;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Resetable;
import A_Super.Weapon;
/**
 * Gives player the scythe for the crypt puzzle.
 * 
 * @see Crypt.Cry1_Statue
 * @author Kevin Rapa
 */
public class Torc_ScytheFurniture extends Furniture implements Resetable {
    // SEWP needs to access this, so this cannot be removed from the room when
    // player takes it. Instead, all names from this object are deleted. This
    // therefore needs to remember its name.
    private final String NAME_KEY = "(?:large )?scythe";
    private final Item SCYTHE = new Weapon(Names.SCYTHE, 
            "It's a large black scythe. The edge is quite sharp.", 80);;
    //-------------------------------------------------------------------------
    public Torc_ScytheFurniture () {
        super();

        this.searchDialog = "It's just a big scythe on the wall.";
        this.description = "It's a sharp black scythe hanging sideways on the wall. "
                         + "Decoration... perhaps?";
        this.actDialog = "You reach up and take the scythe off the wall.";

        this.addNameKeys(this.NAME_KEY);
        this.addActKeys(GETPATTERN);
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {
        if (Player.getInv().add(SCYTHE)) {
            this.NAMEKEYS.clear(); // Furniture 'disappears' from room.
            return this.actDialog;
        }
        else
            return NOTHING;
    }
    //-------------------------------------------------------------------------  
    /**
     * Replaces scythe if player has it. 
     */
    @Override public void reset() {
        if (Player.hasItem(Names.SCYTHE)) {
            Player.getInv().remove(SCYTHE);
            this.addNameKeys(this.NAME_KEY); // This 're-appears' in room.
        }
    }
     //-------------------------------------------------------------------------     
}


