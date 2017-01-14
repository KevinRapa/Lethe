package Gallery;

import A_Main.GUI;
import A_Super.Item;
import A_Super.Furniture;
import A_Main.Inventory;
import A_Main.Player;
/**
 * One of four components of the light machine puzzle in the gallery.
 * 
 * @see Gallery.LghtMchn
 * @see Gallery.Gal1_Drgn
 * @see Gallery.Gal3_Ttm
 * @see Gallery.Gal7_Stat
 * @author Kevin Rapa
 */
public class Gal6_Cnn extends LghtMchn {
    private final Gal7_Stat STAT;   
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_Cnn(Furniture stat, Item... items) {
        super();
        this.searchDialog = "You search around the futuristic cannon.";
        this.actDialog = "You have no idea how this thing works.";
        this.turnOffDialog = "The lights on the cannon stop blinking.";
        this.description = "This thing looks complicated. It's black, and... it\n"
                         + "has some kind of big ball for a body. And it's metal.\n"
                         + "Yeah, you're sure that's metal. It has a long barrel\n"
                         + "coming out the front with slots in it and the whole\n"
                         + "thing is covered in lights and wires. Wait... there's\n"
                         + "an empty square compartment on top. What is that for?\n"
                         + "And there's a weird switch thing over here on the\n"
                         + "other side.";
        this.STAT = (Gal7_Stat) stat;
        this.beam = 'c';
        this.mode = "A clear scattered light";
        this.addActKeys("fire", "shoot");
        this.addNameKeys("(?:electr(?:on)?ic )?cannon");
        this.addUseKeys("box thingy");
        this.inv = new Cnn_Inv(items);       
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getDescription() {   
        if (doesThisHaveIt("box thingy")) {
            if (! isOn)
                return "The battery fits like a glove in that top compartment! But\n"
                     + "why aren't the light all lighting up and bleeping?";
            else
                return "The cannon is blinking and making bleeping noises.\n"
                     + "A ray of light shoots out the barrel too. It must be on!";
        }
        return this.description; 
    }
/*----------------------------------------------------------------------------*/    
    public String turnOn() {
        this.determineColor();
        this.isOn = true;       

        return "The lights on the cannon light up and start bleeping.\n" + mode +
               " emits from the barrel.\n" + STAT.activate(this.beam, true);
    }
/*----------------------------------------------------------------------------*/    
    @Override public String useEvent(Item item) {
        Player.getInv().give(item, this.inv);
        
        if (item.toString().matches("box thingy"))
            return "You place the box in the compartment.";
        else
            return "You place the focus in the barrel's slot.";
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/    
/*----------------------------------------------------------------------------*/     
    private class Cnn_Inv extends Inventory{
        public Cnn_Inv(Item ... items) {
            super(items);
        }
        /*--------------------------------------------------------------------*/
        @Override public boolean add(Item item) {   
            if (item.getType().matches("focus") || item.toString().matches("box thingy")) {
                this.CONTENTS.add(item);
                this.trigger();
                return true;
            }
            GUI.out("The " + item + " doesn't fit in.");
            return false;
        }
        /*--------------------------------------------------------------------*/
        @Override public void remove(Item item) {
            this.CONTENTS.remove(item);
 
            if (isOn) {
                if (item.toString().matches("box thingy"))
                    GUI.out(turnOff());
                else {
                    determineColor();
                    GUI.out(mode + " shoots out the front of the cannon.\n" + STAT.activate(beam, true));
                }
            }
            else {
                if (item.toString().matches("box thingy"))
                    GUI.out("The box fits nicely in the slot on top. It's a battery!");
                else
                    determineColor();
            }
        }
        /*--------------------------------------------------------------------*/
        @Override public void give(Item item, Inventory giveToThis) {
            if (giveToThis.add(item))
                this.remove(item);
        }
        /*--------------------------------------------------------------------*/
        private void trigger() { 
            determineColor();
            
            if (isOn)
                GUI.out(mode + " shoots out the front of the cannon.\n" + STAT.activate(beam, true));
        }   
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/    
/*----------------------------------------------------------------------------*/         
}
