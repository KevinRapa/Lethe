package Gallery;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Id;
import A_Super.Item;
import A_Super.Furniture;
import A_Main.Inventory;
import A_Main.Names;
import static A_Main.Names.*;
import A_Main.Player;
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
    private final int GAL7_STAT_ID;   
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal6_Canon(Furniture stat) {
        super();
        this.searchDialog = "You search around the futuristic cannon.";
        this.actDialog = "You have no idea how this thing works.";
        this.turnOffDialog = "The lights on the cannon stop blinking.";
        this.description = "This thing looks complicated. It's black, and... it "
                         + "has some kind of big ball for a body. And it's metal. "
                         + "Yeah, you're sure that's metal. It has a long barrel "
                         + "coming out the front with slots in it and the whole "
                         + "thing is covered in lights and wires. Wait... there's "
                         + "an empty square compartment on top. What is that for?";
        this.GAL7_STAT_ID = stat.getID();
        this.addActKeys("fire", "shoot");
        this.addNameKeys("(?:electr(?:on)?ic )?cann?on");
        this.addUseKeys(CHARGED_BATTERY, DEAD_BATTERY);
        this.inv = new Cnn_Inv();       
    }
//-----------------------------------------------------------------------------    
    @Override public String getDescription() {   
        if (containsItem(CHARGED_BATTERY)) 
            return "The cannon is blinking and making bleeping noises. "
                 + "A ray of light shoots out the barrel too. It must be on!";
        else
            return this.description; 
    }
//-----------------------------------------------------------------------------    
    @Override protected String turnOn() {
        this.determineColor();
        Furniture s = Player.getRoomObj(Id.GAL7).getFurnRef(GAL7_STAT_ID);
        String r = "The lights on the cannon light up and start bleeping. " + beam +
               " emits from the barrel. ";
        this.isOn = true;     
        
        return (s != null) ? r + ((Gal7_Statue)s).activate(beam) : r;
    }
//-----------------------------------------------------------------------------
    @Override protected void resetStatue() {
        // Do nothing. Once Gal 7 statue raises a level, it can't go back down.
    }
//----------------------------------------------------------------------------- 
    private class Cnn_Inv extends Inventory{
        public Cnn_Inv() {
            super();
        }
        //---------------------------------------------------------------------
        @Override public boolean add(Item item) {   
            if (item.getType().equals(Names.FOCUS)) {
                AudioPlayer.playEffect(43);
                this.CONTENTS.add(item);
                
                if (Gal6_Canon.this.isOn)
                    this.trigger();
                else
                    GUI.out("You slide the " + item + " inside a slot on the cannon barrel.");
                
                return true;
            }
            else if (item.toString().equals(CHARGED_BATTERY)) {
                AudioPlayer.playEffect(43);
                this.CONTENTS.add(item);
                GUI.out("You slide the box inside the square compartment in the cannon. " + Gal6_Canon.this.turnOn());
                return true;
            }
            else if (item.toString().equals(DEAD_BATTERY)) {
                AudioPlayer.playEffect(43);
                this.CONTENTS.add(item);
                GUI.out("The box fits snugly inside the cannon, however nothing interesting happens.");
                return true;
            }
            else {
                GUI.out("That doesn't look like it fits there.");
                return false;
            }
        }
        //---------------------------------------------------------------------
        @Override public void remove(Item item) {
            this.CONTENTS.remove(item);
            
            if (item.toString().equals(CHARGED_BATTERY))
                GUI.out(turnOff());
            
            else if (Gal6_Canon.this.isOn) 
                this.trigger();
        }
        //---------------------------------------------------------------------
        private void trigger() { 
            determineColor();
            Furniture s = Player.getRoomObj(Id.GAL7).getFurnRef(GAL7_STAT_ID);
            String r = beam + " shoots out the front of the cannon. ";
            GUI.out((s != null) ? r + ((Gal7_Statue)s).activate(beam) : r);
        }   
    }
//-----------------------------------------------------------------------------    
}
