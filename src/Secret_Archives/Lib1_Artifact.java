package Secret_Archives;

import A_Super.Item;
import A_Main.GUI;
import A_Main.Inventory;
import A_Main.Names;
import A_Main.Player;
import A_Super.MachineColor;
import Gallery.Gal_LightMachine;
/**
 * Contains the blue lens for the gallery light puzzle.
 * 
 * @see Gallery.Gal_LightMachine
 * @author Kevin Rapa
 */
public class Lib1_Artifact extends Gal_LightMachine {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib1_Artifact(Item... items) {
        super();
        
        this.beam = MachineColor.BLUE;
        
        this.description = 
                "The artifact is a stone head with a hollowed out "
             + "cranium. It's carved crudely. The face is eerily "
             + "expressionless and its eyes are blank. It seems "
             + "ancient. % shoots out a hole in "
             + "the top, reflecting off the ceiling mirror onto "
             + "the desk. You look around, but the head isn't "
             + "connected to anything. You can't determine the "
             + "light's source.";
        this.actDialog = "The large stone head is too heavy to pick up.";
        this.searchDialog = "You squint and peek inside the head.";
        
        this.inv = new Art_Inv(items);  
        
        this.addActKeys(GETPATTERN);
        this.addNameKeys("(?:strange )?artifact", "(?:stone )?head");
    }
//-----------------------------------------------------------------------------    
    @Override public String getDescription() {      
        return this.description.replaceFirst("%", beam.toString());
    }
//-----------------------------------------------------------------------------
    @Override public String useEvent(Item item) {
        this.useDialog = "You place the " + item + " in the hole.";
        Player.getInv().give(item, this.inv);
        
        return this.useDialog;
    }
//-----------------------------------------------------------------------------
    // These are unused here.
    @Override protected String turnOn() {return NOTHING;}
    @Override protected void resetStatue() {}
//-----------------------------------------------------------------------------
/******************************************************************************/
//-----------------------------------------------------------------------------
    private class Art_Inv extends Inventory {
        public Art_Inv(Item ... items) {
            super(items);
        }
    //-------------------------------------------------------------------------
        @Override public boolean add(Item item) {
            if (item.getType().equals(Names.FOCUS)) {
                this.CONTENTS.add(item);
                Lib1_Artifact.this.determineColor();
                GUI.out(beam + " emits from the top of the artifact.");
                return true;
            }
            GUI.out("The " + item + " doesn't fit in.");
            return false;
        }
    //-------------------------------------------------------------------------
        @Override public void remove(Item removeThis) {  
            this.CONTENTS.remove(removeThis);
            Lib1_Artifact.this.determineColor();
        }
    }
//-----------------------------------------------------------------------------
/******************************************************************************/
//-----------------------------------------------------------------------------
}

