package Secret_Archives;

import A_Main.Player;
import A_Super.Furniture;
import A_Super.Item;
import A_Super.Moveable;
import A_Super.Openable;
import A_Super.SearchableFurniture;
        
public class Lib1_Desk extends SearchableFurniture implements Openable, Moveable {
    private final int ART_ID;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib1_Desk(Furniture art, Item... items) {
        super(items);
        this.ART_ID = art.getID();
        this.searchDialog = "You fan through the boring papers on the surface. "
                          + "Here's what you find interesting: ";
        this.addNameKeys("desk", "unkept desk");
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {  
        Lib1_Artifact a = (Lib1_Artifact)Player.getPos().getFurnRef(ART_ID);
        
        return "The desk is unkept and covered in various pieces of paper "
             + "and other knick knacks. The beam from the artifact casts "
             + "its surface in " + a.getBeam().toString().toLowerCase() + '.';
    }
//-----------------------------------------------------------------------------
}

