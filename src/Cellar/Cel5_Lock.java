package Cellar;

import A_Main.AudioPlayer;
import static A_Main.Names.WEAPON;
import A_Main.Player;
import A_Super.Furniture;
import A_Super.Gettable;
import A_Super.Item;
/**
 * @author Kevin Rapa
 */
public class Cel5_Lock extends Furniture implements Gettable {
    // ========================================================================
    public Cel5_Lock () {
        super();

        this.description = "The small padlock connects the grate to a metal "
                        + "reinforcment around its rim.";
        this.actDialog = "If only you had a fitting key for such a simple task.";
        this.searchDialog = "Searching it yields only tiny lock parts.";
        this.useDialog = "Smacking it with the % obliterates the lock. "
                + "It falls into the abyss down below before apparently smacking the ground.";

        this.addNameKeys("padlock|lock");
        this.addUseKeys(ANYTHING);
        this.addActKeys("pick", "unlock|lock", GETPATTERN, "break|destroy|hit|bang");
    }
    // ========================================================================   
    @Override public String interact(String key) {              
        if (key.equals("unlock"))
            return this.actDialog;
        else if (key.equals("lock"))
            return "Isn't that the opposite of what we're trying to accomplish?";
        else if (key.equals("pick"))
            return "Prepare for disappointment, for our protagonist "
                    + "is not skilled in that trade.";
        else if (key.matches(GETPATTERN))
            return getIt("An astute proposition. Interestingly, the padlock is... well... locked.");
        else
            return "That would be too painful and ineffective to do by hand.";
    }
    // ========================================================================     
    @Override public String useEvent(Item item) {
        if (item.getType().equals(WEAPON)) {
            AudioPlayer.playEffect(35);
            AudioPlayer.playEffect(31, 0.1);
            Player.getPos().removeFurniture(this);
            return this.useDialog.replaceFirst("%", item.toString());
        }
        else
            return "Do you intend to pick the lock with that? Prepare for "
                 + "disappointment, for our protagonist is not skilled in the trade.";
    }
    // ========================================================================         
}


