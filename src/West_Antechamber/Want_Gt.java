package West_Antechamber;

/**
 * @author Kevin Rapa
 */
import A_Super.Direction;
import A_Super.Door;

public class Want_Gt extends Door {
/* CONSTRUCTOR ---------------------------------------------------------------*/        
    public Want_Gt (Direction dir) {
        super(dir);
        this.actDialog = "It's just an open gate...";
        this.description = "The open gate leads back into the foyer.";
        this.addNameKeys(dir + " gate", "gate");
    }
/*----------------------------------------------------------------------------*/  
    @Override public String interact(String key) {
        if (key.matches("close"))
            return "Now why would you try to do that??";
        else
            return this.actDialog;
    }
/*----------------------------------------------------------------------------*/
}
