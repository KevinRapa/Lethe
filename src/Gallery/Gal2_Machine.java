package Gallery;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Inventory;
import static A_Main.Names.*;
import A_Main.Player;
import A_Super.Item;
import A_Super.Openable;
import A_Super.SearchableFurniture;
/**
 *
 * @author Kevin Rapa
 */
public class Gal2_Machine extends SearchableFurniture implements Openable {
    private final String NOT_MOVED;
    private boolean pluggedIn, moved;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal2_Machine(Item ... items) {
        super();

        this.inv = new Machine_Inventory(items);
        
        this.pluggedIn = true;
        this.moved = false;
        
        this.NOT_MOVED = "The machine rests flush against the wall and hides any existing outlet.";
        this.useDialog = "Hitting the machine only sends a sharp current of electricity through your body.";
        this.searchDialog = "As you touch the front handle, a strong electrical "
                        + "current propels up your arm. You yank your hand back.";
        this.description = 
                "The small machine rests % and appears to be a "
              + "short black metal box, waist-high, with a front door "
              + "and handle. The front and top are metal, but the sides are rubber. &";
        this.actDialog = "With bear-like strength, you push against the heavy "
                       + "machine and succeed in moving it a small amount. "
                       + "A plugged-in outlet reveals itself behind the machine.";
        
        this.addUseKeys(ANYTHING);
        this.addActKeys(MOVEPATTERN, HOLDPATTERN,"(?:un)?plug", "turn", "fix|repair");
        this.addNameKeys("(black )?(?:metal )?(?:box|machine|handle)");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String result = this.description;
        
        result = result.replaceFirst("%", moved ? 
                "to the side revealing an outlet on the wall." : 
                "flush against the wall.");
        
        return result.replaceFirst("&", pluggedIn ? 
                "Many lights blink on its surface, and electrical arcs "
              + "jump between two metal rods protruding from the top." : 
                "The lights and electrical arcs have stopped.");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        switch (key) {
            
        case "unplug":
            if (moved) {
                String result = pluggedIn ? 
                        "You pull the cord and cease the machine's shenanigans." : 
                        "The machine is already unplugged!" ;
                this.pluggedIn = false;
                return result;
            }
            else
                return this.NOT_MOVED;
        case "plug":
            if (moved) {
                String result = pluggedIn ? 
                        "The machine is already plugged in!" : 
                        "You plug back in the machine.";
                this.pluggedIn = true;
                return result;
            }
            else
                return this.NOT_MOVED;
        case "fix": case "repair":
            return "You are by no means a mechanic.";
        case "turn":
            return "There is no visible off switch on this thing.";
        default:
            if (moved)
                return "You have already moved the machine as far as you can.";
            else {
                this.moved = true;
                AudioPlayer.playEffect(41);
                this.addNameKeys("outlet");
                return this.actDialog;
            }
        }
    }
/*----------------------------------------------------------------------------*/
    @Override public String getSearchDialog() {
        this.searchable = 
                Player.hasItem(WORK_BOOTS)
               || Player.hasItem(RUBBER_GLOVES) 
               || ! pluggedIn;
        
        if (! pluggedIn)
            return "With the machine unplugged, you succeed in opening the machine door.";
        else
            return searchable ? 
                    "With the provided insulation, you succeed in opening the machine door." :
                    this.searchDialog;
    }
/*----------------------------------------------------------------------------*/  
    @Override public String useEvent(Item i) {
        String name = i.toString();
        
        if (name.equals(HAND_DRILL) || name.equals(SCREWDRIVER))
            return "So you're a mechanic now?";
        else if (i.getType().equals(WEAPON)) {
            return (Player.hasItem(WORK_BOOTS) || Player.hasItem(RUBBER_GLOVES) 
                 || ! pluggedIn) ? 
                    "Attempts to savagely smash the machine yield no progress forward." :
                    this.useDialog;
        }
        else if (name.equals(BUCKET_OF_WATER)) {
            return (pluggedIn) ? 
                    "Whoa there... do you have a death wish?" : 
                    DEFAULT_USE;
        }
        else
            return DEFAULT_USE;
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/
/*----------------------------------------------------------------------------*/
    private class Machine_Inventory extends Inventory {
        public Machine_Inventory(Item ... items) {
            super(items);
        }
        @Override public boolean add(Item item) {
            Gal2_Machine.this.searchable = 
                Player.hasItem(WORK_BOOTS)
               || Player.hasItem(RUBBER_GLOVES) 
               || ! pluggedIn;
            
            if (Gal2_Machine.this.searchable) {
                this.CONTENTS.add(item);
                return true;
            }
            else {
                GUI.out(Gal2_Machine.this.searchDialog);
                return false;
            }
        }
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/
/*----------------------------------------------------------------------------*/
}
