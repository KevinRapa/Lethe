package Escape_Tunnel;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Climbable;
import A_Super.Furniture;
import A_Super.Resetable;
/**
 * @author Kevin Rapa
 */
public class Esc6_Ladder extends Furniture implements Resetable, Climbable {
    private final Esc6_Grate GRATE_REF;
    // ========================================================================
    public Esc6_Ladder (Furniture sew6Grt) {
        super();
        this.searchable = false;
        
        this.GRATE_REF = (Esc6_Grate)sew6Grt;
        
        this.description = "It's a metal ladder with rudimentary rungs attached\n"
                         + "directly to the stone wall.";
        this.actDialog = "You climb up the ladder.";

        this.addNameKeys("(?:metal )?ladder", "rungs?");
        this.addActKeys("use", "climb", "ascend");
    }
    // ========================================================================   
    @Override public String getDescription() {
        if (this.GRATE_REF.isMoved())
            return this.description;
        else
            return this.description.concat(" The way up is blocked by a grate.");
    }
    // ========================================================================   
    @Override public String interact(String key) {    
        if (this.GRATE_REF.isMoved()) {
            Player.getRoomObj(Id.INTR).lock();
            Player.getRoomObj(Id.SEWP).unlock();
            Player.setOccupies(Id.SEWP);
            AudioPlayer.playEffect(47);
            return this.actDialog;
        }
        else
            return "Your way up is blocked by a grate.";
    }
    // ========================================================================     
    @Override public void reset() {
        Player.getRoomObj(Id.INTR).unlock();
        Player.getRoomObj(Id.SEWP).lock();
    }
    // ========================================================================  
}


