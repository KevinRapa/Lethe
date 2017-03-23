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
 * 
 * @see Gallery.Gal_LightMachine
 * @see Gallery.Gal1_Drgn
 * @see Gallery.Gal6_Cnn
 * @see Gallery.Gal4_Statue
 * @author Kevin Rapa
 */
public class Gal3_Totem extends Gal_LightMachine {
    private final Gal4_Statue GAL4_STAT_REF;
    private final boolean[] HEADS = {false, false, false, false};    
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
/*----------------------------------------------------------------------------*/    
    @Override public String getDescription() {
        return "The tall wooden totem stands back against the west\n"
             + "wall facing the central chamber. Its four stacked\n"
             + "segments are carved to resemble obscure faces.\n" + numBackwards() +
               "\nOn each side of the segments is a peg sticking out.";
    }
/*----------------------------------------------------------------------------*/ 
    private String numBackwards() {
        int numBackwards = 0;
        
        for (boolean i : HEADS)
            if (! i) numBackwards++;
        
        switch(numBackwards) {
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
/*----------------------------------------------------------------------------*/    
    @Override public String getSearchDialog() {
        if (! this.searchable)
            return this.searchDialog.concat("That head is now facing towards the wall.");
        else
            return this.searchDialog;
    }
/*----------------------------------------------------------------------------*/    
    @Override public String interact(String key) {  
        String action, result = NOTHING;
        
        do {
            String four = HEADS[3]  ?        "-[-_-]-  4" :      "-[   ]-  4";
            String three = HEADS[2] ?   "\t   -[*o*]-  3" : "\t   -[   ]-  3";
            String two = HEADS[1]   ?   "\t   -[-_-]-  2" : "\t   -[   ]-  2";
            String one = HEADS[0]   ?   "\t   -[-_-]-  1" : "\t   -[   ]-  1";
        
            GUI.out("           " + four + "       \t" + three + "\t\t" + 
                       two + "\t\t" + one + "\t\t\t\t\t\t" + result);
        
            action = GUI.askChoice(Menus.GAL_TOTEM, GAL_TOTEM_ONE_TO_FOUR);
        
            if (Player.isNonEmptyString(action)) {
                this.turnHead(Integer.parseInt(action));
                result = this.check();
            }            
        } while (Player.isNonEmptyString(action));
        
        return this.actDialog;
    }
/*----------------------------------------------------------------------------*/
    private String check() {
       if (HEADS[0] && HEADS[1] && HEADS[2] && HEADS[3]) 
           return this.turnOn();
       else if (this.isOn)
           return this.turnOff();
       else
           return NOTHING;
    }
/*----------------------------------------------------------------------------*/
    private void turnHead(int head) {
        AudioPlayer.playEffect(44);
        switch(head) {
            case 1:
                HEADS[0] = ! HEADS[0];
                HEADS[3] = ! HEADS[3];
                break;
            case 2:
                HEADS[1] = ! HEADS[1];
                HEADS[2] = ! HEADS[2];
                HEADS[3] = ! HEADS[3];
                break;
            case 3:
                HEADS[0] = ! HEADS[0];
                HEADS[2] = ! HEADS[2];
                HEADS[3] = ! HEADS[3];
                break;
            default:
                HEADS[2] = ! HEADS[2];
                HEADS[3] = ! HEADS[3];
        }
        this.searchable = this.HEADS[2];
    }
/*----------------------------------------------------------------------------*/     
    @Override protected String turnOn() {
        this.determineColor();
        this.isOn = true;       
        return "The totem's eyes begin to glow. " + this.mode +
               " emits from the totem's third mouth. " + GAL4_STAT_REF.activate(this.beam);
    }
/*----------------------------------------------------------------------------*/
    @Override protected void resetStatue() {
        this.GAL4_STAT_REF.reset();
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/    
/*----------------------------------------------------------------------------*/     
    private class Ttm_Inv extends Inventory {   
        public Ttm_Inv() {
            super();
        }
        /*--------------------------------------------------------------------*/
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
        /*--------------------------------------------------------------------*/
        @Override public void remove(Item removeThis) {
            this.CONTENTS.remove(removeThis);
            
            if (Gal3_Totem.this.isOn) 
                this.trigger();
        }
        /*--------------------------------------------------------------------*/
        private void trigger() {   
            determineColor();
            GUI.out(mode + " emits from the totem's mouth.\n" + GAL4_STAT_REF.activate(beam)); 
        }
    }
/*----------------------------------------------------------------------------*/
/******************************************************************************/    
/*----------------------------------------------------------------------------*/ 
}
