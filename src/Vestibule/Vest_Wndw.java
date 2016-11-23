package Vestibule;

import Super.Window;
import Super.Furniture;
import Super.Room;

public class Vest_Wndw extends Window {
    private final Vest_Frplc REF;
    private final Vest REF2;
    
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Vest_Wndw(String NAME, Furniture ref, Room vest) {
        super(NAME);
        this.isOpen = false;
        this.REF = (Vest_Frplc)ref;
        this.REF2 = (Vest)vest;
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
    @Override public String interact(Room[][][] map, String key) {

        if (this.isOpen) {
            this.interactDialog = "You close the window.";
            this.close(); }
        else {
            if (REF.isLit()) {
                this.open();
                this.REF.extinguish();
                this.interactDialog = "You open the window. A strong gust comes through\n" +
                         "and extinguishes the fireplace."; }
            else {
                this.open();
                this.interactDialog = "You open the window."; }
        }
        this.REF2.switchWindow();
        
        return interactDialog;
    }
/*----------------------------------------------------------------------------*/
}
