package Secret_Archives;

import A_Super.Furniture;
import A_Super.Item;
import A_Main.GUI;
import A_Main.Inventory;
import A_Main.NameConstants;
import static A_Main.NameConstants.*;
import A_Main.Player;
/**
 * Contains the blue lens for the gallery light puzzle.
 * 
 * @see Gallery.Gal_LightMachine
 * @author Kevin Rapa
 */
public class Lib1_Artifact extends Furniture {
    private char beam;
    private String mode;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Lib1_Artifact(Item... items) {
        super();
        this.searchDialog = "You squint and peek inside the head.";
        this.beam = 'b';
        this.mode = "A blue beam";
        this.inv = new Art_Inv(items);   
        this.addNameKeys("artifact", "strange artifact");
        this.addUseKeys(RED_FOCUS, BLUE_FOCUS, YELLOW_FOCUS, DARK_FOCUS);
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getDescription() {      
        return "The artifact is a stone head with a hollowed out\n"
             + "cranium. It's carved crudely. The face is eerily\n"
             + "expressionless and its eyes are blank. It seems\n"
             + "ancient. " + this.mode + " shoots out a hole in\n"
             + "the top, reflecting off the ceiling mirror onto\n"
             + "the desk. You look around, but the head isn't\n"
             + "connected to anything. You can't determine the\n"
             + "light's source.";
    }
/*----------------------------------------------------------------------------*/
    public void triggerEvent() {
        boolean red = false; boolean blue = false; 
        boolean yellow = false; boolean dark = false;      
        
        for (Item i : this.inv) {
            String j = i.toString();
            
            if(j.equals(RED_FOCUS))
                red = true;
            else if(j.equals(BLUE_FOCUS))
                blue = true;
            else if(j.equals(YELLOW_FOCUS))    
                yellow = true;
            else if(j.equals(DARK_FOCUS))    
                dark = true;
        }        
        this.determineColor(red, blue, yellow, dark);
    }
/*----------------------------------------------------------------------------*/
    private void determineColor(boolean red, boolean blue, boolean yellow, boolean dark) {
        if (! dark) {        
            if (red && ! blue && ! yellow) {
                this.beam = 'r'; this.mode = "A red beam"; 
            }
            else if (! red && blue && ! yellow) {
                this.beam = 'b'; this.mode = "A blue beam"; 
            }
            else if (! red && ! blue && yellow) {
                this.beam = 'y'; this.mode = "A yellow beam"; 
            }
            else if (red && blue && ! yellow) {
                this.beam = 'p'; this.mode = "A purple beam"; 
            }
            else if (! red && blue && yellow) {
                this.beam = 'g'; this.mode = "A green beam"; 
            }
            else if (red && ! blue && yellow) {
                this.beam = 'o'; this.mode = "An orange beam"; 
            }
            else if (red && blue && yellow) {                  
                this.beam = 'w'; this.mode = "A white beam"; 
            }
            else {
                this.beam = 'c'; this.mode = "A clear scattered light"; 
            }
        }
        else {
            if (red && ! blue && ! yellow) {
                this.beam = 'R'; this.mode = "A dark red beam"; 
            }
            else if (! red && blue && ! yellow) {
                this.beam = 'B'; this.mode = "A dark blue beam"; 
            }
            else if (! red && ! blue && yellow) {
                this.beam = 'Y'; this.mode = "A dark yellow beam"; 
            }
            else if (red && blue && ! yellow) {
                this.beam = 'P'; this.mode = "A dark purple beam"; 
            }
            else if (! red && blue && yellow) {
                this.beam = 'G'; this.mode = "A dark green beam"; 
            }
            else if (red && ! blue && yellow) {
                this.beam = 'O'; this.mode = "A dark orange beam"; 
            }
            else if (red && blue && yellow) {                  
                this.beam = 'D'; this.mode = "A dark beam"; 
            }
            else {
                this.beam = 'W'; this.mode = "Barely any light"; 
            }       
        }       
    GUI.out(mode + " emits from the artifact's mouth.\n");        
    } 
/*----------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        this.useDialog = "You place the " + item + " in the hole.";
        Player.getInv().give(item, this.inv);
        
        return this.useDialog;
    }
/*----------------------------------------------------------------------------*/
    public char getBeam() {
        return this.beam;
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/
/*----------------------------------------------------------------------------*/
    private class Art_Inv extends Inventory {
        public Art_Inv(Item ... items) {
            super(items);
        }
    /*------------------------------------------------------------------------*/
        @Override public boolean add(Item item) {
            if (item.getType().equals(NameConstants.FOCUS)) {
                this.CONTENTS.add(item);
                triggerEvent();
                return true;
            }
            GUI.out("The " + item + " doesn't fit in.");
            return false;
        }
    /*------------------------------------------------------------------------*/
        @Override public void remove(Item removeThis) {  
            this.CONTENTS.remove(removeThis);
            triggerEvent();
        }
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/
/*----------------------------------------------------------------------------*/
}

