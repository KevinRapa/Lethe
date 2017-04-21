package Lookout;

import A_Main.AudioPlayer;
import A_Main.Id;
import A_Main.Player;
import A_Super.Climbable;
import A_Super.Direction;
import A_Super.Door;
import java.util.regex.Pattern;
/**
 * @author Kevin Rapa
 */
public class Look_TrapDoor extends Door implements Climbable {
    private boolean open;
    private final Pattern LADDER_NAME;
    //-------------------------------------------------------------------------
    public Look_TrapDoor () {
        super(Direction.DOWN);
        
        this.LADDER_NAME = Pattern.compile("(?:metal )?ladder");
        this.open = false;
        
        this.description = "The wooden trap door is %.";
        this.actDialog = "You descend down the ladder for about 20 feet.";

        this.NAMEKEYS.clear();
        this.addNameKeys("(?:wooden )?trap door");
        this.addActKeys(CLIMBPATTERN);
    }
    //------------------------------------------------------------------------- 
    @Override public String getDescription() {
        return this.description.replaceFirst("%", open ? 
                "open, revealing a metal ladder leading down" : "closed");
    }
    //-------------------------------------------------------------------------   
    @Override public String interact(String key) {              
        if (key.matches("open|use|walk|go")) {
            if (open)
                return "The trap door is open already!";
            else {
                this.open = true;
                this.NAMEKEYS.add(LADDER_NAME);
                return "You open the trap door";
            }
        }
        else if (key.matches(CLIMBPATTERN)) {
            if (open) {
                AudioPlayer.playEffect(47);
                Player.setOccupies(Id.CEL1);
                return this.actDialog;
            }
            else 
                return "The trap door is closed. There's nothing to take you there.";
        }
        else if (key.equals("close")) {
            if (open) {
                this.open = false;
                this.NAMEKEYS.remove(LADDER_NAME);
                return "You close the trap door.";
            }
            else
                return "The trap door is closed already!";
        }
        else
            return super.interact(key);
    }
    //------------------------------------------------------------------------- 
    @Override public Direction getDir() {
       return Direction.DOWN;
    }
    //-------------------------------------------------------------------------     
}


