package A_Super;

import A_Main.AudioPlayer;
import static A_Main.NameConstants.WEAPON;
/**
 * Represents a wall. 
 * Superficial only. Would not make sense for game to say "there is no wall here"
 * 
 * @author Kevin Rapa
 */
public class Wall extends Furniture {
/*----------------------------------------------------------------------------*/    
    public Wall(String dsc) {
        super();
        this.description = dsc;
        this.actDialog = "What do expect to find? A porkchop?";
        this.searchDialog = "The walls here are solid and couldn't hide anything.";
        this.useDialog = "You whack the wall and jolt backwards. Well, that was productive.";
        this.addActKeys("break", "climb", "scale");
        this.addUseKeys(ANYTHING);
        this.addNameKeys("walls?");
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        if (item.getType().equals(WEAPON)) {
            AudioPlayer.playEffect(35);
            return this.actDialog;
        }
        else
            return DEFAULT_USE;
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (key.equals("break"))
            return this.actDialog;
        else
            return "Suction cups would be pretty convenient right about now...";
    }
/*----------------------------------------------------------------------------*/
}