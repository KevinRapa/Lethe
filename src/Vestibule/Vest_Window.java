package Vestibule;

import A_Main.AudioPlayer;
import A_Super.Window;
import A_Super.Furniture;
import A_Main.Player;

public class Vest_Window extends Window {
    private final Vest_Fireplace REF;
    
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Vest_Window(Furniture ref) {
        super();
        this.isOpen = false;
        this.REF = (Vest_Fireplace)ref;
        this.escapeDialog = "You would never be able to fit through those bars, and they're too thick to cut...";
        this.searchDialog = "The only place to look is on the sill,\n" + 
                            "but there's nothing there.";
        this.descOpen = "It's an open, barred arched window of stone. A strong\n" +
                        "draft rolls in. From it, you can see the front\n" +
                        "courtyard surrounded by the rest of the castle\n" +
                        "and a tall front gate.\n";
        this.descClosed = "It's a closed, barred stone arched window with a\n" +
                          "small hole in the glass. A small gust of\n" +
                          "air forces it's way through.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        Vest vest = (Vest)Player.getPos(); // Player must be in vesibule.
        
        if (key.matches("open|close")) {
            if (this.isOpen && key.equals("close")) {
                this.close(); 
                vest.switchWindow();
                AudioPlayer.playEffect(26);
                return "You close the window.";
            }
            else if (! this.isOpen && key.equals("open")) {
                this.open();
                vest.switchWindow();
                AudioPlayer.playEffect(26);

                if (REF.isLit()) {
                    this.REF.extinguish();
                    return "You open the window. A strong gust comes through\n" +
                                          "and extinguishes the fireplace."; 
                }
                else
                    return "You open the window."; 
            }
            else
                return "The window is already " + (key.equals("open") ? "open" : "closed") + "!";
        }
        else
            return this.escapeDialog;
    }
/*----------------------------------------------------------------------------*/
}
