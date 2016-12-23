package Library;

import A_Super.Item;
import A_Super.Statue;

public class Lib3_Stat extends Statue {
    private boolean leftEye, rightEye;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Lib3_Stat(Item... items) {
        super(items);
        this.leftEye = false;
        this.rightEye = false;
        this.description = "The towering statue reaches a bit over a story tall.\n"
                         + "On its blocky rectangular base stands a prancing horse.";
        this.searchDialog = "A small square seam on the statue's base piques\n"
                          + "your interest.";
        this.actDialog = "Such an impressive work of artistry deserves not to be\n"
                       + "tainted by your touch.";
        this.addNameKeys("impressive statue");
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        
        if (this.leftEye && ! this.rightEye)
            rep += "\nIts left eye glows eerily.";
        else if (! this.leftEye && this.rightEye)
            rep += "\nIts right eye glows eerily.";
        else if (this.rightEye && this.leftEye)
            rep += "\nBoth of its eyes glow eerily.";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
     @Override public String getSearchDialog() {
        String rep = this.searchDialog;
        
        if (this.searchable)
            rep = "You look into the compartment inside the statue's base";
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    private String makeSearchable() {
            this.searchable = true;
            
            return "\nBoth of the horse's eyes now glow. You hear a faint\n"
                   + "grinding noise.";
    }
/*----------------------------------------------------------------------------*/
    public String lightRight() {
        String rep = "You push the button. As soon as you turn around, you\n"
                   + "notice the horse's right eye glowing.";       
        this.rightEye = true;
        
        if (this.rightEye && this.leftEye && ! this.searchable) {
            rep += this.makeSearchable();
        }
        
        return rep;
    }
/*----------------------------------------------------------------------------*/
    public String lightLeft() {
        String rep = "You push the button. As soon as you turn around, you\n"
                   + "notice the horse's left eye glowing.";       
        this.leftEye = true;
        
        if (this.rightEye && this.leftEye && ! this.searchable) {
            rep += this.makeSearchable();
        }
        return rep;
    }
/*----------------------------------------------------------------------------*/
}