package Rotunda;

import A_Main.AudioPlayer;
import A_Main.GUI;
import A_Main.Id;
import A_Main.Player;
import A_Super.Direction;
import A_Super.Room;
import A_Super.Furniture;
/**
 * This room rotates, only allowing access to two of its adjacent rooms at a time.
 * Room is rotated by four levers in the adjacent rooms or by a wheel in the
 * fountain, that must first be drained.
 * Connects to Foyw, Look, Stud, and Iha1
 * 
 * @see Iron_Hall.Iha1_Lever
 * @see West_Antechamber.Want_Lever
 * @see Iron_Hall.Iha1
 * @see Study.Stud
 * @see Lookout.Look
 * @see West_Antechamber.Want
 * @see Rotunda.Rotu_Fountain
 * @see Rotunda.Rotu_Wheel
 * @author Kevin Rapa
 */
public class Rotu extends Room {
    private char state;
    private final Furniture NDOOR, SDOOR, EDOOR, WDOOR; 
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu(String name, String ID) {
        super(name, ID);
        
        this.NDOOR = new Rotu_Door(Direction.NORTH);
        this.SDOOR = new Rotu_Door(Direction.SOUTH);
        this.EDOOR = new Rotu_Door(Direction.EAST);
        this.WDOOR = new Rotu_Door(Direction.WEST);
        
        this.addFurniture(WDOOR, EDOOR);
        
        description = "You are in a symmetrical dome-shaped chamber. Everything\n" +
                      "is ornate and carved from polished rock. A fountain in the \n" +
                      "center serves as a focus. At each diagonal below a spherical\n" +
                      "sconce is a glaring statue. Various\n" +
                      "potted plants decorate the room. Looking straight up, there's\n" +
                      "a hole in the ceiling giving view to the sky. Only a single\n" +
                      "other door on the opposite side is apparent. At the perpendicular\n" +
                      "ends are peculiar arched frames carved into the wall. Your\n" +
                      "only complaint is that this room smells quite awful.";
        this.state = 'e';
    }
/*----------------------------------------------------------------------------*/
    public void rotate() {
        AudioPlayer.playEffect(18);
        
        if (this.state == 'e') {
            this.addAdjacent(Id.STUD);
            Player.getRoomObj(Id.STUD).addAdjacent(this.ID);
            this.addAdjacent(Id.IHA1); 
            Player.getRoomObj(Id.IHA1).addAdjacent(this.ID);
            this.removeAdjacent(Id.FOYW);
            Player.getRoomObj(Id.FOYW).removeAdjacent(this.ID);
            this.removeAdjacent(Id.LOOK);
            Player.getRoomObj(Id.LOOK).removeAdjacent(this.ID);
            
            this.removeFurniture(EDOOR);
            this.removeFurniture(WDOOR);
            this.addFurniture(NDOOR);
            this.addFurniture(SDOOR);
            this.state = 'n';
        }
        else {
            this.addAdjacent(Id.FOYW);
            Player.getRoomObj(Id.FOYW).addAdjacent(this.ID);
            this.addAdjacent(Id.LOOK); 
            Player.getRoomObj(Id.LOOK).addAdjacent(this.ID);
            this.removeAdjacent(Id.STUD);
            Player.getRoomObj(Id.STUD).removeAdjacent(this.ID);
            this.removeAdjacent(Id.IHA1);
            Player.getRoomObj(Id.IHA1).removeAdjacent(this.ID);
            
            this.removeFurniture(NDOOR);
            this.removeFurniture(SDOOR);
            this.addFurniture(EDOOR);
            this.addFurniture(WDOOR);
            this.state = 'e'; 
        }    
    }
/*----------------------------------------------------------------------------*/        
    public char getState() {
        return this.state;
    }
/*----------------------------------------------------------------------------*/   
    @Override public String triggeredEvent() {
        if (! Player.hasVisited(ID))
            GUI.out("\"What a foul stench of decay!\" You think to yourself as you enter this domed chamber.");
            
        return STD_RM_OUT;
    }
}
