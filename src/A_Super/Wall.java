package A_Super;

import A_Main.AudioPlayer;
import static A_Main.Names.METAL_LADDER;
import static A_Main.Names.WEAPON;
/**
 * Represents a wall. 
 * Superficial only. Would not make sense for game to say "there is no wall here"
 * 
 * @author Kevin Rapa
 */
public class Wall extends Furniture implements Unmoveable {
//-----------------------------------------------------------------------------    
    public Wall(String dsc) {
        super();
        this.description = dsc;
        this.actDialog = "What do expect to find? A pork chop?";
        this.searchDialog = "The walls here are solid and couldn't hide anything.";
        this.useDialog = "You whack the wall and jolt backwards. Well, that was productive.";
        this.addActKeys("break", CLIMBPATTERN, "push", "press", "lean");
        this.addUseKeys(ANYTHING);
        this.addNameKeys("walls?");
    }
//-----------------------------------------------------------------------------
    @Override public String useEvent(Item item) {
        if (item.getType().equals(WEAPON)) {
            AudioPlayer.playEffect(35);
            return this.actDialog;
        }
        else if (item.toString().equals(METAL_LADDER))
            return item.useEvent();
        else
            return DEFAULT_USE;
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {
        if (key.equals("break"))
            return this.actDialog;
        else if (key.equals("push") || key.equals("press"))
            return "The player makes an unsuccessful but commendable attempt at discovering a hidden door or panel.";
        else if (key.equals("lean"))
            return "Your player leans on the wall, hoping to activate a camoflaged button, but to no avail.";
        else
            return "Suction cups would be pretty convenient right about now...";
    }
//-----------------------------------------------------------------------------
}
