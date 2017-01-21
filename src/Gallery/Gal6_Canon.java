package Gallery;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Super.Item;
import A_Super.Furniture;
import A_Main.Inventory;
import A_Main.NameConstants;
import static A_Main.NameConstants.*;
/**
 * One of four components of the light machine puzzle in the gallery.
 * 
 * @see Gallery.Gal_LightMachine
 * @see Gallery.Gal1_Drgn
 * @see Gallery.Gal3_Ttm
 * @see Gallery.Gal7_Statue
 * @author Kevin Rapa
 */
public class Gal6_Canon extends Gal_LightMachine {
    private final Gal7_Statue STAT;   
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_Canon(Furniture stat) {
        super();
        this.searchDialog = "You search around the futuristic cannon.";
        this.actDialog = "You have no idea how this thing works.";
        this.turnOffDialog = "The lights on the cannon stop blinking.";
        this.description = "This thing looks complicated. It's black, and... it\n"
                         + "has some kind of big ball for a body. And it's metal.\n"
                         + "Yeah, you're sure that's metal. It has a long barrel\n"
                         + "coming out the front with slots in it and the whole\n"
                         + "thing is covered in lights and wires. Wait... there's\n"
                         + "an empty square compartment on top. What is that for?";
        this.STAT = (Gal7_Statue) stat;
        this.addActKeys("fire", "shoot");
        this.addNameKeys("(?:electr(?:on)?ic )?cannon");
        this.addUseKeys(BOX_THINGY);
        this.inv = new Cnn_Inv();       
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getDescription() {   
        if (containsItem(BOX_THINGY)) 
            return "The cannon is blinking and making bleeping noises.\n"
                 + "A ray of light shoots out the barrel too. It must be on!";
        else
            return this.description; 
    }
/*----------------------------------------------------------------------------*/    
    @Override protected String turnOn() {
        this.determineColor();
        this.isOn = true;       
        return "The lights on the cannon light up and start bleeping. " + mode +
               " emits from the barrel. " + STAT.activate(beam);
    }
/*----------------------------------------------------------------------------*/
    @Override protected void resetStatue() {
        // Do nothing. Once Gal 7 statue raises a level, it can't go back down.
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/    
/*----------------------------------------------------------------------------*/     
    private class Cnn_Inv extends Inventory{
        public Cnn_Inv() {
            super();
        }
        /*--------------------------------------------------------------------*/
        @Override public boolean add(Item item) {   
            if (item.getType().equals(NameConstants.FOCUS)) {
                AudioPlayer.playEffect(43);
                this.CONTENTS.add(item);
                
                if (Gal6_Canon.this.isOn)
                    this.trigger();
                else
                    GUI.out("You slide the " + item + " inside a slot on the cannon barrel.");
                
                return true;
            }
            else if (item.toString().equals(BOX_THINGY)) {
                AudioPlayer.playEffect(43);
                this.CONTENTS.add(item);
                GUI.out("You slide the box inside the square compartment in the cannon. " + Gal6_Canon.this.turnOn());
                return true;
            }
            else {
                GUI.out("That doesn't look like it fits there.");
                return false;
            }
        }
        /*--------------------------------------------------------------------*/
        @Override public void remove(Item item) {
            this.CONTENTS.remove(item);
            
            if (item.toString().equals(BOX_THINGY))
                GUI.out(turnOff());
            
            else if (Gal6_Canon.this.isOn) 
                this.trigger();
        }
        /*--------------------------------------------------------------------*/
        private void trigger() { 
            determineColor();
            GUI.out(mode + " shoots out the front of the cannon.\n" + STAT.activate(beam));
        }   
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/    
/*----------------------------------------------------------------------------*/         
}
