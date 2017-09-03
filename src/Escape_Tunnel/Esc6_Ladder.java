package Escape_Tunnel;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Climbable;
import A_Super.Direction;
import A_Super.Furniture;
import A_Super.Resetable;
/**
 * @author Kevin Rapa
 */
public class Esc6_Ladder extends Furniture implements Resetable, Climbable {
    private final int GRATE_ID;
    //-------------------------------------------------------------------------
    public Esc6_Ladder (Furniture sew6Grt) {
        super();
        this.searchable = false;
        
        this.GRATE_ID = sew6Grt.getID();
        
        this.description = "It's a metal ladder with rudimentary rungs attached "
                         + "directly to the stone wall.";
        this.actDialog = "You climb up the ladder.";

        this.addNameKeys("(?:metal )?ladder", "rungs?");
        this.addActKeys("use", CLIMBPATTERN);
    }
    //-------------------------------------------------------------------------   
    @Override public String getDescription() {
        Esc6_Grate g = (Esc6_Grate)Player.getRoomObj(Id.ESC6).getFurnRef(GRATE_ID);
                
        if (g.isMoved())
            return this.description;
        else
            return this.description.concat(" The way up is blocked by a grate.");
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {    
        Esc6_Grate g = (Esc6_Grate)Player.getRoomObj(Id.ESC6).getFurnRef(GRATE_ID);
        
        if (g.isMoved()) {
            Player.getRoomObj(Id.INTR).setLocked(true);
            Player.getRoomObj(Id.SEWP).setLocked(false);
            Player.setOccupies(Id.SEWP);
            AudioPlayer.playEffect(47);
            return this.actDialog;
        }
        else
            return "Your way up is blocked by a grate.";
    }
    //-------------------------------------------------------------------------     
    @Override public void reset() {
        Player.getRoomObj(Id.INTR).setLocked(false);
        Player.getRoomObj(Id.SEWP).setLocked(true);
    }
    //-------------------------------------------------------------------------  
    @Override public Direction getDir() {
       return Direction.UP;
    }
    //-------------------------------------------------------------------------     
}


