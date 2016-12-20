package Lookout;

import Rotunda.Rotu_Fntn;
import Rotunda.Rotu_Whl;
import Rotunda.Rotu;
import Super.Furniture;
import Super.Room;

public class Look_Vlv extends Furniture{
    private final Rotu_Fntn REF;
    private final Rotu REF2;
    private final Rotu_Whl REF3;
    private String state;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Look_Vlv(Furniture fntn, Room rotu, Furniture whl) {
        super();
        this.searchable = false;
        this.searchDialog = "There's nothing here. Honestly, you never expected\n"
                          + "to find anything.";
        this.description = "A big rusty valve. There's a small pipe sticking out\n"
                         + "of the wall next to it.";
        this.state = "tight";
        this.interactDialog = "As you turn the valve, you hear rushing water. Immediately,\n"
                    + "a gush of water flows from the nearby pipe and off of the\n"
                    + "balcony.";
        this.REF = (Rotu_Fntn) fntn;
        this.REF2 = (Rotu) rotu;
        this.REF3 = (Rotu_Whl) whl;
        this.addNameKeys("valve");
        this.addActKeys("turn", "rotate", "spin", "twist");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String interact(Room[][][] map, String key) {
        String rep = this.interactDialog;
        if (! REF.isDrained()) {
            REF.drain();
            REF2.addFurniture(REF3);
            this.state = "loose"; }
        else {
            if (this.state.matches("loose")) {
                rep = "You tighten back up the valve";
                this.state = "tight"; }
            else if (this.state.matches("tight")) {
                rep = "You loosen the valve, but nothing happens.";
                this.state = "loose"; }            
        }       
        return rep;
    }
/*----------------------------------------------------------------------------*/
    
}