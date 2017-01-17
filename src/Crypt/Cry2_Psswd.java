package Crypt;

import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Resetable;
/**
 * The player must speak this furniture's name before the coffin in the crypt
 * in order to access the catacombs.
 * Serves as a dummy furniture.
 * 
 * @author Kevin Rapa
 */
public class Cry2_Psswd extends Furniture implements Resetable {
    private final Cry1_Stat CRY1_STAT;
    private boolean coffinMoved;
    // ========================================================================
    public Cry2_Psswd (Furniture stat) {
        super();
        
        this.CRY1_STAT = (Cry1_Stat)stat;
        this.searchable = false;
        this.coffinMoved = false;
        
        this.actDialog = "As you speak the phrase before the stone coffin, it\n"
                       + "slides to the side with a rumble, revealing a metal\n"
                       + "door.";
        this.searchDialog = this.description = this.useDialog = 
                "There is nothing with that name here.";

        this.addNameKeys("it is i,? friend,? welcome me\\.?");
        this.addUseKeys(".+");
        this.addActKeys("talk", "speak", "say", "announce", "whisper");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (this.CRY1_STAT.isSolved() && ! Player.getPos().isAdjacent(Id.CAS1)) {
            Player.getPos().addAdjacent(Id.CAS1);
            Player.getRoomObj(Id.CAS1).addAdjacent(Id.CRY2);
            this.coffinMoved = true;
            return this.actDialog;
        }
        else
            return "You speak before the coffin with no effect.";
    }
    // ========================================================================      
    @Override public void reset() {
        this.coffinMoved = false;
    }
    // ========================================================================  
    public boolean coffinMoved() {
        return this.coffinMoved;
    }
    // ========================================================================  
}

