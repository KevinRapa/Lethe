package Strange_Pool;

import A_Main.GUI;
import A_Main.Id;
import A_Main.Inventory;
import static A_Main.Names.HAND_TORCH;
import static A_Main.Names.METAL_BAR;
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
//-----------------------------------------------------------------------------    
    public Sewp(String name, String ID, Inventory cbntInv, Furniture ... resetables) {
        super(name, ID);
        this.RESETABLES = resetables;
        this.PRIS_CBNT_INV = cbntInv;
    }
//-----------------------------------------------------------------------------
    public void resetAllObjects() {
        for (Furniture r : this.RESETABLES)
            ((Resetable)r).reset();
        
        ((Cis1)Player.getRoomObj(Id.CIS1)).reset();
        
        for (Item i : Player.getInv()) 
            if (! i.toString().equals(HAND_TORCH) && ! i.toString().equals(METAL_BAR))
                this.PRIS_CBNT_INV.add(i);
        
        Player.getInv().clear();
        Player.setShoes("");
        
        Player.printInv();
    }
//-----------------------------------------------------------------------------
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(ID))
            GUI.out("You climb up the ladder into the room outside your cell. "
                  + "Looking north, you peer down a short thin tunnel into "
                  + "a larger area which you believe to be the source of the "
                  + "unsettling noise.");
            
        return STD_RM_OUT;
    }
}           