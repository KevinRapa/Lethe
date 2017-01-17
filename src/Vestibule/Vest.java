package Vestibule;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Id;
import A_Main.Player;
import A_Super.Room;

public class Vest extends Room {
    String descOpen, descClosed;
    private boolean windowOpen;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Vest(String name, String ID) {
        super(name, ID);
        this.windowOpen = false;
        descClosed = "You are in a small but tall chamber. A shale tile floor\n" +
                   "and granite walls surround you. In front of you is a small wooden table displaying a ceramic case\n" +
                   "next to an ornate chair facing a large marble fireplace. To your\n" + 
                   "right, a closed barred window lets in a small draft. A large tapestry " +
                   "consumes most of the wall behind you. In a dark corner, there is a desk.";
        descOpen = "You are in a small but tall chamber. A shale tile floor\n" +
                   "and granite walls surround you. In front of you is a small wooden table displaying a ceramic case\n" +
                   "between two velvet chairs facing a large marble fireplace. To your\n" + 
                   "right, an open window bars your way from escape. A large tapestry\n" +
                   "consumes most of the wall behind you. In a dark corner, there is a desk.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        return this.windowOpen ? descOpen : descClosed; 
    }
/*----------------------------------------------------------------------------*/    
    @Override public String triggeredEvent() {        
        // Locks the door to the foyer.
        AudioPlayer.playEffect(5);
        Player.getRoomObj(Id.VEST).lock();
        GUI.out("You hear a click behind you.");
        
        return STD_RM_OUT;
    }            
/*----------------------------------------------------------------------------*/
    public void switchWindow() {
        this.windowOpen = ! this.windowOpen;
    }
/*----------------------------------------------------------------------------*/    
}
