package Gallery;

import static A_Main.NameConstants.*;
import A_Super.Item;
import A_Super.Furniture;
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
abstract public class LghtMchn extends Furniture {
    protected boolean isOn;
    protected char beam;
    protected String mode, turnOffDialog;    
    private final HashMap<String, String> COLOR_MAP = new HashMap() {{
           //drby {dark, red, blue, yellow}
        put("0000", "c A clear scattered light");                
        put("0001", "y A yellow beam");
        put("0010", "b A blue beam");
        put("0011", "g A green beam");            
        put("0100", "r A red beam");
        put("0101", "o An orange beam");
        put("0110", "p A purple beam");
        put("0111", "w A white beam");
        put("1000", "W Barely any light");
        put("1001", "Y A dark yellow beam");
        put("1010", "B A dark blue beam");
        put("1011", "G A dark green beam");
        put("1100", "R A dark red beam");
        put("1101", "O A dark orange beam");
        put("1110", "P A dark purple beam");
        put("1111", "D A dark beam");
    }};
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public LghtMchn() {
        super();
        this.isOn = false;
        this.addUseKeys(RED_FOCUS, BLUE_FOCUS, YELLOW_FOCUS, DARK_FOCUS);
    }
/*----------------------------------------------------------------------------*/
    public void determineColor() {
        char red = '0', blue = '0', yellow = '0', dark = '0';
        
        for (Item i : this.inv) {
            switch (i.toString().charAt(0)) {
                case 'r':
                    red = '1'; break;
                case 'b':
                    blue = '1'; break;
                case 'y':
                    yellow = '1'; break;
                default:
                    dark = '1';
            }
        } 
        char[] data = {dark, red, blue, yellow};
        
        String result = COLOR_MAP.get(String.valueOf(data));

        beam = result.charAt(0);
        mode = result.substring(2);
    }
/*----------------------------------------------------------------------------*/ 
    public boolean isOn() {
        return isOn;
    }
/*----------------------------------------------------------------------------*/
    public char getBeam() {
        return beam;
    }
/*----------------------------------------------------------------------------*/
    public String turnOff() {
        this.isOn = false;      
        
        return turnOffDialog;
    }
/*----------------------------------------------------------------------------*/
}


