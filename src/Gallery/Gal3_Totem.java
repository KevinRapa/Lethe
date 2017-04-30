package Gallery;

import A_Main.AudioPlayer;
import A_Super.Item;
import A_Main.GUI;
import A_Super.Furniture;
import A_Main.Inventory;
import A_Main.Menus;
import A_Main.Names;
import static A_Main.Names.*;
import static A_Main.Patterns.GAL_TOTEM_ONE_TO_FOUR;
import A_Main.Player;
/**
 * One of four components of the light machine puzzle in the gallery.
 * Uses bit operations to spin heads just for the heck of it. Used to be
 * an array of booleans.
 * 
 * @see Gallery.Gal_LightMachine
 * @see Gallery.Gal1_Drgn
 * @see Gallery.Gal6_Cnn
 * @see Gallery.Gal4_Statue
 * @author Kevin Rapa
 */
public class Gal3_Totem extends Gal_LightMachine {
    private final Gal4_Statue GAL4_STAT_REF;
    private byte heads = 0b0000; // Each bit represents 1 head. A '1' means the head is forward.
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3_Totem(Furniture stat) {
        super();
        this.searchable = false;
        this.GAL4_STAT_REF = (Gal4_Statue) stat;
        
        this.searchDialog = "The only place to search is the totem's open third mouth. ";
        this.turnOffDialog = "The lights in the totem's eyes and mouth fade.";
        
        this.addActKeys("turn", "spin", "twist");
        this.addUseKeys(RED_FOCUS, BLUE_FOCUS, YELLOW_FOCUS, DARK_FOCUS);
        this.addNameKeys("totem", "wood totem", "wooden totem");
        this.inv = new Ttm_Inv();       
    }
//-----------------------------------------------------------------------------    
    @Override public String getDescription() {
        return "The tall wooden totem stands back against the west "
             + "wall facing the central chamber. Its four stacked "
             + "segments are carved to resemble obscure faces. " + numBackwards() +
               " On each side of the segments is a peg sticking out.";
    }
//----------------------------------------------------------------------------- 
    private String numBackwards() {
        byte temp = heads, numBackward = 4;
        
        while (temp != 0b0000) {
            // Counts the number of 1 bits in HEADS.
            if ((temp & 0b0001) == 0b0001)
                numBackward--;
            
            temp >>= 1; 
        }
        
        switch(numBackward) {
            case 0:
                return "All of them face forward. From the third shines a light.";
            case 1:
                return "One of them faces back towards the wall.";
            case 2:
                return "Two of them face back towards the wall.";
            case 3:
                return "Three of them face back towards the wall.";
            default:
                return "All of them face back towards the wall.";
        }
    }
//-----------------------------------------------------------------------------    
    @Override public String getSearchDialog() {
        if (! this.searchable)
            return this.searchDialog.concat("That head is now facing towards the wall.");
        else
            return this.searchDialog;
    }
//-----------------------------------------------------------------------------    
    @Override public String interact(String key) {  
        String action, result = NOTHING, h1, h2, h3, h4;
        
        do {
            h1 = (heads & 0b0001) == 1 ?      "~[-_-]~  4" :      "~[   ]~  4";
            h2 = (heads & 0b0010) == 2 ? "\t   ~[\"o\"]~  3" : "\t   ~[   ]~  3";
            h3 = (heads & 0b0100) == 4 ? "\t   ~[=_=]~  2" : "\t   ~[   ]~  2";
            h4 = (heads & 0b1000) == 8 ? "\t   ~[-_-]~  1" : "\t   ~[   ]~  1";
        
            GUI.out("           " + h1 + "       \t" + h2 + "\t\t" + 
                       h3 + "\t\t" + h4 + "\t\t\t\t\t\t" + result);
        
            action = GUI.askChoice(Menus.GAL_TOTEM, GAL_TOTEM_ONE_TO_FOUR);
        
            if (Player.isNonEmptyString(action)) {
                this.turnHead(Integer.parseInt(action));
                result = this.check();
            }            
        } while (Player.isNonEmptyString(action));
        
        return NOTHING;
    }
//-----------------------------------------------------------------------------
    private String check() {
       if (heads == 0b1111) 
           return this.turnOn();
       else if (this.isOn)
           return this.turnOff();
       else
           return NOTHING;
    }
//-----------------------------------------------------------------------------
    private void turnHead(int head) {
        AudioPlayer.playEffect(44);
        switch(head) {
            case 1:
                heads ^= 0b1010; // Switch 1 and 3
                break;
            case 2:
                heads ^= 0b0111; // Switch 2, 3, and 4
                break;
            case 3:
                heads ^= 0b1011; // Switch 1, 3, and 4
                break;
            default:
                heads ^= 0b0011; // Switch 3 and 4
        }
        
        this.searchable = (heads & 0b0010) == 0b0010;
    }
//-----------------------------------------------------------------------------     
    @Override protected String turnOn() {
        this.determineColor();
        this.isOn = true;       
        return "The totem's eyes begin to glow. " + beam +
               " emits from the totem's third mouth. " + GAL4_STAT_REF.activate(beam);
    }
//-----------------------------------------------------------------------------
    @Override protected void resetStatue() {
        this.GAL4_STAT_REF.reset();
    }
//-----------------------------------------------------------------------------
/******************************************************************************/    
//-----------------------------------------------------------------------------     
    private class Ttm_Inv extends Inventory {   
        public Ttm_Inv() {
            super();
        }
        //---------------------------------------------------------------------
        @Override public boolean add(Item item) { 
            if (item.getType().equals(Names.FOCUS)) {
                AudioPlayer.playEffect(43);
                this.CONTENTS.add(item);
                
                if (Gal3_Totem.this.isOn)
                    this.trigger();
                else
                    GUI.out("You stick the " + item + " into the totem's mouth.");
                
                return true;
            }
            GUI.out("That doesn't look like it fits there.");
            return false;
        }
        //---------------------------------------------------------------------
        @Override public void remove(Item removeThis) {
            this.CONTENTS.remove(removeThis);
            
            if (Gal3_Totem.this.isOn) 
                this.trigger();
        }
        //---------------------------------------------------------------------
        private void trigger() {   
            determineColor();
            GUI.out(beam + " emits from the totem's mouth. " + GAL4_STAT_REF.activate(beam)); 
        }
    }
//-----------------------------------------------------------------------------
/******************************************************************************/    
//----------------------------------------------------------------------------- 
}
