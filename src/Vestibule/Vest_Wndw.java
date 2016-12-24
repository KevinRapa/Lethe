package Vestibule;

import A_Super.Window;
import A_Super.Furniture;
import A_Main.Player;

public class Vest_Wndw extends Window {
    private final Vest_Frplc REF;
    
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Vest_Wndw(Furniture ref) {
        super();
        this.isOpen = false;
        this.REF = (Vest_Frplc)ref;
        this.searchDialog = "The only place to look is on the sill,\n" + 
                            "but there's nothing there.";
        this.descOpen = "It's an open arched window of stone. A strong\n" +
                        "draft rolls in. From it, you can see the front\n" +
                        "courtyard surrounded by the rest of the castle\n" +
                        "and a tall front gate.\n";
        this.descClosed = "It's a closed, stone arched window with a\n" +
                          "small hole in the glass. A small gust of\n" +
                          "air forces it's way through.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        Vest vest = (Vest)Player.getRoomRef("VEST");
        
        if (this.isOpen && key.matches("close")) {
            this.actDialog = "You close the window.";
            this.close(); 
            vest.switchWindow();
        }
        else if (! this.isOpen && key.matches("open")) {
            this.open();
            
            if (REF.isLit()) {
                this.REF.extinguish();
                this.actDialog = "You open the window. A strong gust comes through\n" +
                                      "and extinguishes the fireplace."; 
            }
            else
                this.actDialog = "You open the window."; 
            
            vest.switchWindow();
        }
        else
            this.actDialog = "The window is already " + (key.matches("open") ? "open" : "closed") + "!";
        
        return actDialog;
    }
/*----------------------------------------------------------------------------*/
}
