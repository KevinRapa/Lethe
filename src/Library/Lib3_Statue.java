package Library;

import A_Main.AudioPlayer;
import A_Main.Inventory;
import A_Super.Item;
import A_Super.Statue;

public class Lib3_Statue extends Statue {
    private boolean leftEye, rightEye;
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Lib3_Statue(Item... items) {
        super();
        this.inv = new Inventory(items);
        this.leftEye = false;
        this.rightEye = false;
        this.description = "The towering statue reaches a bit over a story tall. "
                         + "On its boxy rectangular base stands a prancing horse. "
                         + "A small square seam on the statue's base piques your interest.";
        this.searchDialog = "A small square seam on the statue's base piques "
                          + "your interest.";
        this.actDialog = "Such an impressive work of artistry deserves not to be "
                       + "tainted by your touch.";
        this.addNameKeys("(?:impressive )?(?:horse )?statue", "horse");
    }
//-----------------------------------------------------------------------------
    @Override public String getDescription() {
        if (! this.leftEye && ! this.rightEye)
            return this.description;
        else if (this.leftEye && ! this.rightEye)
            return this.description.concat(" Its left eye glows eerily.");
        else if (! this.leftEye && this.rightEye)
            return this.description.concat(" Its right eye glows eerily.");
        else
            return this.description.concat(" Both of its eyes glow eerily.")
                    .replaceAll(" small square seam", "n open compartment");
    }
//-----------------------------------------------------------------------------
     @Override public String getSearchDialog() {
        String rep = this.searchDialog;
        
        if (this.searchable)
            rep = "You look into the compartment inside the statue's base";
        
        return rep;
    }
//-----------------------------------------------------------------------------
    private String makeSearchable() {
            AudioPlayer.playEffect(44);
            this.addNameKeys("compartment");
            this.searchable = true;
            
            return " Both of the horse's eyes now glow. You hear a faint "
                   + "grinding noise.";
    }
//-----------------------------------------------------------------------------
    public String lightRight() {
        String rep = "You push the button. As soon as you turn around, you "
                   + "notice the horse's right eye glowing.";       
        this.rightEye = true;
        
        if (this.rightEye && this.leftEye && ! this.searchable) {
            rep += this.makeSearchable();
        }
        
        return rep;
    }
//-----------------------------------------------------------------------------
    public String lightLeft() {
        String rep = "You push the button. As soon as you turn around, you "
                   + "notice the horse's left eye glowing.";       
        this.leftEye = true;
        
        if (this.rightEye && this.leftEye && ! this.searchable) {
            rep += this.makeSearchable();
        }
        return rep;
    }
//-----------------------------------------------------------------------------
}