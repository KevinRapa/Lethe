package Scorched_Room;

import A_Main.AudioPlayer;
import A_Main.Id;
import static A_Main.Names.*;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Item;
import A_Super.Furniture;
/**
 * Player must use the warhammer on this to escape the west wing.
 * 
 * @author Kevin Rapa
 */
public class Sear_Fissure extends Furniture {
//-----------------------------------------------------------------------------    
    public Sear_Fissure() {
        super();

        this.searchDialog = "It's just an empty hole.";
        this.description = "The north wall has been damaged, and a resulting "
                         + "fissure in it leads outside through the wall into the front "
                         + "courtyard. Seems this was part of an escape plan.";
        this.useDialog = "The wall gives way from the swing of the heavy "
                       + "warhammer, which snaps in half. You "
                       + "begin to think the wood ax is the only tool "
                       + "you know how to use without breaking.";
        this.actDialog = "You couldn't manage to do that with your bare hands.";
        
        this.addActKeys("break", JOSTLEPATTERN, "climb|go|walk");
        this.addNameKeys("fissure", "wall", "(?:empty )?hole");
        this.addUseKeys(WARHAMMER, CROWBAR, HAMMER);
    }
//-----------------------------------------------------------------------------
    @Override public String useEvent(Item item) {
        if (item.toString().equals(WARHAMMER)) {            
            Player.getPos().addAdjacent(Id.COU2);
            Player.getInv().remove(item);
            Player.getInv().add(new Item(BROKEN_WARHAMMER, "It's snapped in half.", "Well, it's useless now.", -30));
            AudioPlayer.playEffect(30);
            return this.useDialog;
        }
        else if (! Player.getPos().isAdjacent(Id.COU2)) {
            AudioPlayer.playEffect(35);
            if (item.toString().equals(HAMMER)) {
                return "You give it a swing, but this hammer is too "
                     + "small to break this wall. They must've been "
                     + "using something else.";
            }
            else {
                return "You give the crowbar a swing, but it just "
                     + "rebounds with a loud *THWANG*. They must've "
                     + "been hitting this with something else";
            }  
        }
        return "The fissure has been destroyed already!";
    }
//-----------------------------------------------------------------------------    
    @Override public String getDescription() {
        return (Player.getPos().isAdjacent(Id.COU2)) ?
            "The hole leads outside. It's big enough to fit through." :
            this.description; 
    }
//-----------------------------------------------------------------------------
    @Override public String interact(String key) {
        if (key.equals("break"))
            return this.actDialog;
        else if (key.matches(JOSTLEPATTERN))
            return "That's sufficiently infeasible to do without a tool.";
        else {
            Player.move(Direction.NORTH);
            return NOTHING;
        }
    }
//-----------------------------------------------------------------------------
}
