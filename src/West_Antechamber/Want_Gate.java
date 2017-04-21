package West_Antechamber;

/**
 * @author Kevin Rapa
 */
import A_Main.Id;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Door;

public class Want_Gate extends Door {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Want_Gate (Direction dir) {
        super(dir);
        this.actDialog = "You wouldn't be able to lift it with your hands.";
        this.description = "The open gateway leads back into the foyer.";
        this.addNameKeys(dir + " gate", "gate");
    }
//-----------------------------------------------------------------------------  
    @Override public String interact(String key) {
        if (key.equals("close"))
            return "Now why would you try to do that??";
        else
            return this.actDialog;
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        return (Player.getPos().isAdjacent(Id.FOY1) || Player.getPos().isAdjacent(Id.FOY2)) ? 
                this.description :
                "The closed gate bars your way into the foyer.";
    }
//-----------------------------------------------------------------------------
}
