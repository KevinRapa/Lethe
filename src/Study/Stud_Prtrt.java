package Study;

import Super.Furniture;
import Super.Room;
        
public class Stud_Prtrt extends Furniture {
    private boolean lifted;
    private final Furniture REF;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Stud_Prtrt (Furniture safe) {
        super();
        this.searchable = false;
        this.lifted = false;
        this.REF = safe;
        this.description = "The portrait depicts a bald male with round glasses,\n"
                         + "maybe fifty years old. He looks a bit like an angry\n"
                         + "Bob Gunton. 'Could this be a picture of Erik?' you say\n"
                         + "to yourself. 'Wait, who's Bob Gunton?' you ask, but\n"
                         + "you hear no answer. With the light cast from the\n"
                         + "fireplace, it seems like this picture is not resting\n"
                         + "flush on the wall.";
        this.searchDialog = "There's nothing on this picture. Interestingly, the\n"
                          + "portrait does not rest flush on the wall.";
        this.interactDialog = "You lift up the portrait resembling Bob Gunton,\n"
                    + "appropriately revealing a safe.";
        this.addActKeys("move", "lift", "take", "slide", "remove");
        this.addNameKeys("portrait", "picture", "painting");
    }
/*----------------------------------------------------------------------------*/
        @Override public String interact(Room[][][] map, String key) {     
            Room stud = map[3][2][3];
            String rep = "You have already discovered the safe.";
            
            if (! this.lifted) {
                rep = this.interactDialog;
                this.lifted = true;
                stud.addFurniture(REF);
            }            
            return rep;
    }
/*----------------------------------------------------------------------------*/
        public boolean isMoved() {
            return this.lifted;
        }
}

