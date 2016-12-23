package Secret_Archives;

import A_Super.Container;
import A_Super.Furniture;
import A_Super.Item;
        
public class Lib1_Dsk extends Furniture implements Container {
    private final Lib1_Art REF;

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib1_Dsk(Furniture art, Item... items) {
        super(items);
        this.REF = (Lib1_Art)art;
        this.searchDialog = "You fan through the boring papers on the surface.\n"
                          + "Here's what you find interesting: ";
        this.addNameKeys("desk", "unkept desk");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {  
        
        return "The desk is unkept and covered in various pieces of paper\n"
             + "and other knick knacks. The beam from the artifact casts\n"
             + "its surface in " + this.getColor() + " light.";
    }
/*----------------------------------------------------------------------------*/
    private String getColor() {
        String clr;
        
        switch (REF.getBeam()) {
            case 'r': clr = "a red"; break;
            case 'b': clr = "a blue"; break;
            case 'y': clr = "a yellow"; break;
            case 'p': clr = "a purple"; break;
            case 'g': clr = "a green"; break;
            case 'o': clr = "an orange"; break;
            case 'w': clr = "a bright"; break;
            case 'c': clr = "a white scattered"; break;
            case 'R': clr = "a dark red"; break;
            case 'B': clr = "a dark blue"; break;
            case 'Y': clr = "a dark yellow"; break;
            case 'P': clr = "a deep purple"; break;
            case 'G': clr = "a dark green"; break;
            case 'O': clr = "a dark orange"; break;
            case 'D': clr = "an iridescent"; break;
            default:  clr = "a faint";
        }
        
        return clr;
    }
/*----------------------------------------------------------------------------*/
}

