package Lookout;

import A_Main.AudioPlayer;
import A_Main.Player;
import Rotunda.Rotu_Fntn;
import Rotunda.Rotu_Whl;
import A_Super.Furniture;

public class Look_Vlv extends Furniture{
    private final Rotu_Fntn FNTN_REF;
    private final Rotu_Whl WHL_REF;
    private boolean loosened;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Look_Vlv(Furniture fntn, Furniture whl) {
        super();
        this.searchable = false;
        this.searchDialog = "There's nothing here. Honestly, you never expected\n"
                          + "to find anything.";
        this.description = "A big rusty valve. There's a small pipe sticking out\n"
                         + "of the wall next to it.";
        this.loosened = false;
        this.actDialog = "As you turn the valve, you hear rushing water. Immediately,\n"
                    + "a gush of water flows from the nearby pipe and off of the\n"
                    + "balcony.";
        this.FNTN_REF = (Rotu_Fntn) fntn;
        this.WHL_REF = (Rotu_Whl) whl;
        this.addNameKeys("valve");
        this.addActKeys("turn", "rotate", "spin", "twist");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String interact(String key) {
        String rep = this.actDialog;
        if (! FNTN_REF.isDrained()) {
            FNTN_REF.drain();
            AudioPlayer.playEffect(20);
            Player.getRoomRef("ROTU").addFurniture(WHL_REF);
            loosened = true; 
        }
        else {
            if (loosened) 
                rep = "You tighten back up the valve";
            else 
                rep = "You loosen the valve, but nothing happens.";
            
            loosened = ! loosened;           
        }       
        return rep;
    }
/*----------------------------------------------------------------------------*/
    
}