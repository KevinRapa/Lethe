package Lookout;

import Main.AudioPlayer;
import Main.Player;
import Rotunda.Rotu_Fntn;
import Rotunda.Rotu_Whl;
import Super.Furniture;

public class Look_Vlv extends Furniture{
    private final Rotu_Fntn REF;
    private final Rotu_Whl REF3;
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
        this.interactDialog = "As you turn the valve, you hear rushing water. Immediately,\n"
                    + "a gush of water flows from the nearby pipe and off of the\n"
                    + "balcony.";
        this.REF = (Rotu_Fntn) fntn;
        this.REF3 = (Rotu_Whl) whl;
        this.addNameKeys("valve");
        this.addActKeys("turn", "rotate", "spin", "twist");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String interact(String key) {
        String rep = this.interactDialog;
        if (! REF.isDrained()) {
            REF.drain();
            AudioPlayer.playEffect(20);
            Player.getMapRef()[3][3][3].addFurniture(REF3);
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