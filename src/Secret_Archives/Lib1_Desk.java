package Secret_Archives;

import A_Super.Furniture;
import A_Super.Item;
import A_Super.Moveable;
import A_Super.Openable;
import A_Super.SearchableFurniture;
        
public class Lib1_Desk extends SearchableFurniture implements Openable, Moveable {
    private final Lib1_Artifact REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib1_Desk(Furniture art, Item... items) {
        super(items);
        this.REF = (Lib1_Artifact)art;
        this.searchDialog = "You fan through the boring papers on the surface. "
                          + "Here's what you find interesting: ";
        this.addNameKeys("desk", "unkept desk");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {  
        return "The desk is unkept and covered in various pieces of paper "
             + "and other knick knacks. The beam from the artifact casts "
             + "its surface in " + this.getColor() + " light.";
    }
/*----------------------------------------------------------------------------*/
    private String getColor() {
        switch (REF.getBeam()) {
            case 'r': return "a red";
            case 'b': return "a blue";
            case 'y': return "a yellow";
            case 'p': return "a purple";
            case 'g': return "a green";
            case 'o': return "an orange";
            case 'w': return "a bright";
            case 'c': return "a white scattered";
            case 'R': return "a dark red";
            case 'B': return "a dark blue";
            case 'Y': return "a dark yellow";
            case 'P': return "a deep purple";
            case 'G': return "a dark green";
            case 'O': return "a dark orange";
            case 'D': return "an iridescent";
            default:  return "a faint";
        }
    }
/*----------------------------------------------------------------------------*/
}

