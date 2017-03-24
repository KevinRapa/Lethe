package Laboratory;

import A_Main.AudioPlayer;
import static A_Main.Names.*;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Unmoveable;
/**
 * @author Kevin Rapa
 */
public class Labo_GasPipe extends Furniture implements Unmoveable {
    private boolean gasIsOn;
    // ========================================================================
    public Labo_GasPipe () {
        super();

        this.gasIsOn = false;
        
        this.description = "The metal pipe runs from the floor to ceiling in "
                + "the room's corner. In the middle is a valve and an uncovered nozzle.";
        this.actDialog = "You turn the valve.";
        this.useDialog = "You fit the rubber tube over the nozzle tightly and connect the other end to the bunsen burner.";

        this.addNameKeys("(?:metal )?(?:gas )?(?:pipe|valve|nozzle)");
        this.addUseKeys(RUBBER_HOSE);
        this.addActKeys("turn", "rotate", "twist", "spin");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        if (Player.getPos().hasFurniture("hose"))
            return "The metal pipe runs from the floor to ceiling. In the middle is a valve and nozzle connected to a rubber tube.";
        else
            return this.description;
    }
    // ========================================================================   
    @Override public String interact(String key) {          
        boolean hoseConnected = Player.getPos().hasFurniture("hose");

        if (this.toggleGas()) 
            return hoseConnected ? actDialog.concat(" You start to hear a hissing noise.") :
                                   actDialog.concat(" You turn the valve and begin to smell gas.");
        else 
            return hoseConnected ? actDialog.concat(" The hissing noise stops.") :
                                   actDialog.concat(" Slowly, the gas odor fades away.");
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        Player.getInv().remove(item);
        Player.getPos().addFurniture(new Labo_Hose());
        return this.useDialog;
    }
    // ========================================================================  
    public boolean isOn() {
        return this.gasIsOn;
    }
    // ======================================================================== 
    private boolean toggleGas() {
        AudioPlayer.playEffect(17);
        this.gasIsOn = ! gasIsOn;
        return gasIsOn;
    }
    // ======================================================================== 
}


