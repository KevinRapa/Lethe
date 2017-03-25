package Cistern;

import A_Main.GUI;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Resetable;
import Tunnels.Dungeon_Tunnel;
/**
 * Initially contains toxic gas preventing the player from entering this room.
 * Player must solve a valve puzzle to disperse the gas.
 * 
 * @see Tunnels.Sew2_Vlvs
 * @see Tunnels.Sew5_Vlv
 * @author Kevin Rapa
 */
public class Cis1 extends Dungeon_Tunnel implements Resetable {
    private boolean hasToxicGas;
// ============================================================================    
    public Cis1(String name, String ID) {
        super(name, ID);
        this.hasToxicGas = true;
    }
// ============================================================================
    @Override public String triggeredEvent() {
        if (this.hasToxicGas) {
            Player.move(Direction.EAST);
            GUI.out("You walk into the room passed the door and are greeted by a thick\n"
                  + "green smog. It burns your eyes and nose. You cannot bear it and\n"
                  + "retreat back into the tunnel.");
        }
        
        return "You are " + Player.getPos() + ".";
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        if (dir == Direction.NORTH)
            return WATER_THAT_WAY;
        else
            return bumpIntoWall();
    }
// ============================================================================
    public void turnOffGas() {
        this.hasToxicGas = false;
    }
// ============================================================================
    @Override public void reset() {
        this.hasToxicGas = true;
    }
// ============================================================================
}