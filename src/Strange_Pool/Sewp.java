package Strange_Pool;

import A_Main.Id;
import A_Main.Inventory;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Resetable;
import Cistern.Cis1;
import Tunnels.Dungeon_Tunnel;
/**
 * Player emerges into this room from the ladder in escape tunnel
 * Connects to Dkch and Sew3
 * 
 * @see Tunnels.Sew3
 * @see Keeper_Chamber.Dkch
 * @see Escape_Tunnel.Esc6_Ladder
 * @author Kevin Rapa
 */
public class Sewp extends Dungeon_Tunnel {
    private final Furniture[] RESETABLES;
    private final Inventory PRIS_CBNT_INV;
// ============================================================================    
    public Sewp(String name, String ID, Inventory cbntInv, Furniture ... resetables) {
        super(name, ID);
        this.RESETABLES = resetables;
        this.PRIS_CBNT_INV = cbntInv;
        this.description= "You are on the other side of your cell door in a room\n" +
                          "with a large pool in the center. A vortex of water\n" +
                          "flowing from a tunnel to the north spins in the pool\n" +
                          "and drives a large submerged wheel attached to a driveshaft\n" +
                          "protruding from the ceiling. Several torches light the\n" +
                          "room. To your east is a second metal door leading\n"
                        + "somewhere else.";
    }
// ============================================================================
    public void resetAllObjects() {
        for (Furniture r : this.RESETABLES)
            ((Resetable)r).reset();
        
        ((Cis1)Player.getRoomObj(Id.CIS1)).reset();
        
        for (Item i : Player.getInv()) 
            if (! i.toString().matches("hand torch|metal bar"))
                this.PRIS_CBNT_INV.add(i);
        
        Player.getInv().contents().clear();
        Player.setShoes("");
        
        Player.printInv();
    }
// ============================================================================
}           