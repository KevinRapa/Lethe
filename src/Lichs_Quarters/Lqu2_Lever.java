package Lichs_Quarters;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Names;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Lever;
/**
 * Unlocks the front gate.
 * @author Kevin Rapa
 */
public class Lqu2_Lever extends Lever {
    private final int GATE_ID;
    private final Furniture OPEN_GATE;
    //-------------------------------------------------------------------------
    public Lqu2_Lever (Furniture cou3Gt) {
        super();
        
        this.GATE_ID = cou3Gt.getID();
        this.OPEN_GATE = new Cou3_OpenedGate();
        
        this.description = "A plain lever on the wall.";
        this.actDialog = "With the last of your energy, you pull the lever. You hear a gate open.";

        this.addNameKeys("lever");
    }
    //-------------------------------------------------------------------------
    @Override public String interact(String key) {
        if (! this.isOn) {
            this.swtch();
            AudioPlayer.playEffect(12);
            return this.event(key);
        }
        else
            return "You best leave now...";
    } 
    //-------------------------------------------------------------------------   
    @Override protected String event(String key) {
        Player.getRoomObj(Id.COU4).setLocked(false);
        Player.getRoomObj(Id.COU3).removeFurniture(GATE_ID);
        Player.getRoomObj(Id.COU3).addFurniture(OPEN_GATE);
        AudioPlayer.playEffect(7, 0.25);
        return this.actDialog;
    }
    //-------------------------------------------------------------------------
    // ************************************************************************
    //-------------------------------------------------------------------------
    private class Cou3_OpenedGate extends Furniture {
        public Cou3_OpenedGate () {
            super();
            this.searchable = false;
            this.description = "The gate is open!";
            this.searchDialog = "Did you find yourself at home here? Are wishing "
                              + "to stay busy?";
            this.useDialog = this.actDialog = this.description;
            
            this.addUseKeys(Names.HAND_DRILL);
            this.addActKeys("open", "use");
            this.addNameKeys("(?:monstrous )?(?:two-story )?(?:solid )?(?:oak )?(?:main |front )?gate");
        }
    }
    //-------------------------------------------------------------------------
    // ************************************************************************
    //-------------------------------------------------------------------------
}


