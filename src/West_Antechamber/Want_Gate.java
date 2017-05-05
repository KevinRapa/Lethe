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
        boolean open = Player.getPos().isAdjacent(Id.FOY1) || Player.getPos().isAdjacent(Id.FOY2);
        
        if (key.equals("close"))
            if (open)
                return "That would only impede your progress.";
            else
                return "The gate is closed already!";
        else if (open)
            return "It's just empty space. Maybe you should go through it?";
        else if (key.equals("open") || key.equals("lift"))
            return this.actDialog;
        else
            return super.interact(key);
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        return (Player.getPos().isAdjacent(Id.FOY1) || Player.getPos().isAdjacent(Id.FOY2)) ? 
                this.description :
                "The closed gate bars your way into the foyer.";
    }
//-----------------------------------------------------------------------------
}
