package Scorched_Room;

import A_Main.AudioPlayer;
import A_Main.Id;
import static A_Main.NameConstants.*;
import A_Main.Player;
import A_Super.Item;
import A_Super.Furniture;

public class Sear_Fssr extends Furniture {
    private boolean broken;
/*----------------------------------------------------------------------------*/    
    public Sear_Fssr() {
        super();
        this.searchable = false;
        this.broken = false;
        this.searchDialog = "It's just an empty hole.";
        this.description = "The north wall has been damaged, and a resulting\n"
                         + "fissure in it leads outside through the wall into the front\n"
                         + "courtyard. It looks like this was part of\n"
                         + "the escape plan.";
        this.useDialog = "The wall gives way from the swing of the heavy\n"
                       + "warhammer, but the warhammer snaps in half. You\n"
                       + "begin to think the wood axe is the only tool\n"
                       + "you know how to use without it breaking.";
        this.addNameKeys("fissure", "wall");
        this.addUseKeys(WARHAMMER, CROWBAR, HAMMER);
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        if (item.toString().equals(WARHAMMER)) {            
            Player.getPos().addAdjacent(Id.COU2);
            Player.getInv().remove(item);
            Player.getInv().add(new Item("broken warhammer", "It's snapped in half.", "Well, it's useless now."));
            this.broken = true;
            AudioPlayer.playEffect(30);
            return this.useDialog;
        }
        else if (! this.broken) {
            if (item.toString().equals(HAMMER)) {
                return "You give it a swing, but this hammer is too\n"
                     + "small to break this wall. They must've been\n"
                     + "using something else.";
            }
            else {
                return "You give the crowbar a swing, but it just\n"
                     + "rebounds with a loud *THWANG*. They must've\n"
                     + "been hitting with something else";
            }  
        }
        return "The fissure has been destroyed already!";
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getDescription() {
        if (this.broken)
            return "The hole leads outside. It's big enough to fit through.";
                   
        return this.description; 
    }
/*----------------------------------------------------------------------------*/
}
