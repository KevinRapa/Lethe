package Gallery;

import static A_Main.Names.*;
import A_Main.Player;
import A_Super.Item;
import A_Super.MachineColor;
import A_Super.SearchableFurniture;
import java.util.HashMap;
/**
 * A part of a puzzle in the gallery that emits colors of light depending on
 * combinations of lenses that are put into it.
 * 
 * Interacts with the statue in the central chamber.
 * 
 * @see Gallery.Gal1_Drgn
 * @see Gallery.Gal3_Ttm
 * @see Gallery.Gal6_Cnn
 * @see Gallery.Gal_2E_Stat
 * @author Kevin Rapa
 */
abstract public class Gal_LightMachine extends SearchableFurniture {
    protected boolean isOn;
    protected MachineColor beam;
    protected String turnOffDialog;
    
    protected static final HashMap<Integer, MachineColor> 
            COLOR_MAP = new HashMap<>();

    static {
        COLOR_MAP.put(0b0000, MachineColor.CLEAR);                
        COLOR_MAP.put(0b0001, MachineColor.YELLOW);
        COLOR_MAP.put(0b0010, MachineColor.BLUE);
        COLOR_MAP.put(0b0011, MachineColor.GREEN);            
        COLOR_MAP.put(0b0100, MachineColor.RED);
        COLOR_MAP.put(0b0101, MachineColor.ORANGE);
        COLOR_MAP.put(0b0110, MachineColor.PURPLE);
        COLOR_MAP.put(0b0111, MachineColor.WHITE);
        COLOR_MAP.put(0b1000, MachineColor.NONE);
        COLOR_MAP.put(0b1001, MachineColor.DARK_YELLOW);
        COLOR_MAP.put(0b1010, MachineColor.DARK_BLUE);
        COLOR_MAP.put(0b1011, MachineColor.DARK_GREEN);
        COLOR_MAP.put(0b1100, MachineColor.DARK_RED);
        COLOR_MAP.put(0b1101, MachineColor.DARK_ORANGE);
        COLOR_MAP.put(0b1110, MachineColor.DARK_PURPLE);
        COLOR_MAP.put(0b1111, MachineColor.DARK);
    }
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal_LightMachine() {
        super();
        this.isOn = false;
        this.beam = MachineColor.CLEAR;
        this.addUseKeys(RED_FOCUS, BLUE_FOCUS, YELLOW_FOCUS, DARK_FOCUS);
    }
//-----------------------------------------------------------------------------
    protected void determineColor() {
        int color = 0b0000;
        
        for (Item i : this.inv) {
            switch (i.toString()) {
                case RED_FOCUS:
                    color |= 0b0100; break;
                case BLUE_FOCUS:
                    color |= 0b0010; break;
                case YELLOW_FOCUS:
                    color |= 0b0001; break;
                case DARK_FOCUS:
                    color |= 0b1000;
            }
        } 
        this.beam = COLOR_MAP.get(color);
    }
//----------------------------------------------------------------------------- 
    public boolean isOn() {
        return isOn;
    }
//-----------------------------------------------------------------------------
    public MachineColor getBeam() {
        return beam;
    }
//-----------------------------------------------------------------------------
    abstract protected String turnOn();
//-----------------------------------------------------------------------------
    abstract protected void resetStatue();
//-----------------------------------------------------------------------------
    public String turnOff() {
        this.isOn = false;      
        this.resetStatue();
        return turnOffDialog;
    }
//-----------------------------------------------------------------------------    
    @Override public String useEvent(Item item) {
        Player.getInv().give(item, this.inv);
        return this.useDialog;
    }
//-----------------------------------------------------------------------------
}


