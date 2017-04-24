package A_Super;

import static A_Main.Names.W_DIR;
import static A_Main.Names.SEP;
import static A_Main.Names.DATA;
import A_Main.AudioPlayer;
import A_Main.Id;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import A_Main.RoomGraph;
import java.util.HashSet;
/**
 * <p>
 * Represents one element in the game map array. 
 * The player always has a defined attribute of integer coordinates which
 * give access to furniture in the room at those coordinates in the array.
 * </p> <p>
 * Each room has a unique ID string, roughly corresponding to the room name.
 * The IDs uniquely identify the room for the purposes of getting coordinates
 * and adjacent rooms. The ID is used by Keys as well.
 * </p> <p>
 * Rooms are adjacent to other rooms, which means that movement between them
 * is possible. Two adjacent rooms are separated by empty space if the first 3 letters
 * of there IDs match, excluding the caves and catacombs. Otherwise, they are
 * separated by a door, unless they are on two different floors, e.g. connected
 * by stairs.
 * </p> <p>
 * Rooms may be locked, which means that movement into the is not allowed unless
 * the player carries a key with the matching ID number.
 * </p> <p>
 * Rooms have a <code>triggeredEvent</code> method, called whenever the player 
 * enters. Generally, the method notifies the player where he/she is in the
 * castle.
 * </p>
 * 
 * @see A_Main.RoomGraph
 * @author Kevin Rapa
 */
public class Room implements Serializable { 
    protected static final String 
            PATH = W_DIR + SEP + DATA + SEP + "desc" + SEP,
            WALL_BARRIER = "There is a wall that way.";
    protected final String 
            NAME, ID,                           // The name and unique ID of the room.
            STD_RM_OUT;                         // Prints where you are.
    protected final int[] COORDS;               // Index coordinates of this room.
    protected boolean locked;                   // You cannot move into a locked room.
    private transient String description;       // Description of the room.
    protected HashSet<String> adjacent;         // Rooms one could move to from this.
    protected ArrayList<Furniture> furnishings; // Holds furniture.
    // CONSTRUCTOR ============================================================
    public Room(String name, String ID) {  
        this.NAME = name;
        this.ID = ID;
        this.STD_RM_OUT = name;
        this.locked = false;
        this.COORDS = RoomGraph.getCoords(this.ID); 
        this.adjacent = RoomGraph.getAdj(this.ID);
        // Gets the room's description from a file.
        String filename;
        
        if (ID.equals(Id.NULL) || this instanceof Caves.Cave)
            return; // Caves make their own description. No need for a file.
        else if (this instanceof Catacombs.Catacomb)
            filename = "CT"; // All catacombs have one file.
        else
            filename = ID;
        
        this.description = readDescription(filename);
    }
//******************************************************************************
// <editor-fold desc="GETTERS">
//******************************************************************************     
    @Override public String toString() {
        return this.NAME; 
    }
    //-------------------------------------------------------------------------
    public String getID() {
        return this.ID; 
    } 
    //------------------------------------------------------------------------- 
    public int[] getCoords() {
        return this.COORDS;
    } 
    //-------------------------------------------------------------------------
    public String getDescription() {
        if (this.description == null) {
            this.description = Room.readDescription(this.ID);
        } 
        return this.description;
    }
    //-------------------------------------------------------------------------
    /**
     * Reads the room's description from a file. 
     * Descriptions are not serialized.
     * @param filename Name of the file containing this room's description.
     * @return The room's description.
     */
    private static String readDescription(String filename) {
        try (BufferedReader br = new BufferedReader(
                new FileReader(PATH + filename + ".txt"))
                ) 
        {
            String descLine;
            StringBuilder descBuilder = new StringBuilder();

            while ((descLine = br.readLine()) != null)
                descBuilder.append(descLine);
            
            return descBuilder.toString();
        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
            return "";
        } 
    }
    //-------------------------------------------------------------------------
    /**
     * If the player fails a movement attempt, this returns the reason.
     * Overridden if the room contains other barrier types (e.g. railing)
     * @param dir A direction.
     * @return Why the move failed.
     */
    public String getBarrier(Direction dir) {
        return bumpIntoWall(); 
    }
    //-------------------------------------------------------------------------
    /**
     * Notifies player of incorrect direction and plays a sound.
     * @return Standard dialog that player has moved towards a solid wall.
     */
    protected static String bumpIntoWall() {
        AudioPlayer.playEffect(6);
        return WALL_BARRIER;
    }
    //-------------------------------------------------------------------------
    public ArrayList<Furniture> getFurnishings() {
        return this.furnishings;
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************    
    
    
//******************************************************************************
// <editor-fold desc="SETTERS">      
//******************************************************************************    
    public final void lock() {
        this.locked = true;
    }
    //-------------------------------------------------------------------------
    public final void unlock() {
        this.locked = false; 
    }
    //-------------------------------------------------------------------------
    /**
     * Adds a room adjacent to this one.
     * @param roomID A room to be added to adjacent.
     */
    public final void addAdjacent(String roomID) {
        this.adjacent.add(roomID);
    }
    //-------------------------------------------------------------------------
    /**
     * Removes a room from this.adjacent.
     * @param roomID A room to remove from adjacent.
     */
    public final void removeAdjacent(String roomID) {
        this.adjacent.remove(roomID);
    }
    //-------------------------------------------------------------------------
    public final void removeFurniture(Furniture removeThis) {
        this.furnishings.remove(removeThis);
    }
    //-------------------------------------------------------------------------
    public final void addFurniture(Furniture ... furnishings) {
        if (this.furnishings == null)
            this.furnishings = new ArrayList<>(furnishings.length);
            
        this.furnishings.addAll(Arrays.asList(furnishings));
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
    
    
//******************************************************************************
// <editor-fold desc="OTHER">      
//****************************************************************************** 
    /**
     * The event that occur whenever the player enters this room.
     * @return A string default that says which room you are in.
     */
    public String triggeredEvent() {
        return STD_RM_OUT;
    }
    //-------------------------------------------------------------------------
    public boolean isLocked() {
        return this.locked; 
    }
    //-------------------------------------------------------------------------
    /**
     * Checks if a room is accessible from this one, used in movement.
     * By 'accessible', is the destination separated by this room by either
     * a door or empty space?
     * @param destination A room ID.
     * @return If room is adjacent to this one.
     */
    public boolean isAdjacent(String destination) {
        return this.adjacent.contains(destination); 
    } 
    //-------------------------------------------------------------------------
    /**
     * Checks this room for a piece of furniture with the name.
     * @param name The name of a piece of furniture.
     * @return If your location contains furniture with that name.
     */
    public boolean hasFurniture(String name) {   
        return this.furnishings.stream()
                .anyMatch(i -> (i.nameKeyMatches(name)));
    }
    //-------------------------------------------------------------------------
    public boolean hasFurniture(Furniture furn) {
        return this.furnishings.contains(furn);
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
}