package A_Super;

import A_Main.AudioPlayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.Serializable;
import A_Main.RoomReferences;
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
 * @see A_Main.RoomReferences
 * @author Kevin Rapa
 */
public class Room implements Serializable { 
    protected final String NAME, ID,            // The name and unique ID of the room.
                           STD_RM_OUT;          // Prints where you are.
    protected final int[] COORDS;               // Index coordinates of this room.
    protected boolean isLocked;                 // You cannot move into a locked room.
    protected String description;               // Description of the room.
    protected ArrayList<String> adjacent;       // Rooms one could move to from this.
    protected ArrayList<Furniture> furnishings; // Holds furniture.
    protected static final String WALL_BARRIER = "There is a wall that way.";
    private static final Furniture GEN_FURNITURE = new GenericFurniture();
    // CONSTRUCTOR ============================================================
    public Room(String name, String ID) {  
        this.NAME = name;
        this.ID = ID;
        this.STD_RM_OUT = "You are " + name + ".";
        this.isLocked = false;
        this.adjacent = new ArrayList<>();
        this.furnishings = new ArrayList<>();
        this.furnishings.add(GEN_FURNITURE);
        this.COORDS = RoomReferences.getCoords(this.ID); 
        this.adjacent = RoomReferences.getAdj(this.ID);
}
//******************************************************************************
// <editor-fold desc="GETTERS">
//******************************************************************************     
    @Override public String toString() {
        return this.NAME; 
    }
    // ========================================================================
    public String getID() {
        return this.ID; 
    } 
    // ======================================================================== 
    public int[] getCoords() {
        return this.COORDS;
    } 
    // ========================================================================
    public String getDescription() {
        return this.description; 
    }
    // ========================================================================
    /**
     * If the player fails a movement attempt, this returns the reason.
     * Overridden if the room contains other barrier types (e.g. railing)
     * @param dir A direction.
     * @return Why the move failed.
     */
    public String getBarrier(Direction dir) {
        return bumpIntoWall(); 
    }
    // ========================================================================
    protected String bumpIntoWall() {
        AudioPlayer.playEffect(6);
        return WALL_BARRIER;
    }
    // ========================================================================
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
        this.isLocked = true;
    }
    // ========================================================================
    public final void unlock() {
        this.isLocked = false; 
    }
    // ========================================================================
    /**
     * Adds a room adjacent to this one.
     * @param roomID A room to be added to adjacent.
     */
    public final void addAdjacent(String roomID) {
        this.adjacent.add(roomID);
    }
    // ========================================================================
    /**
     * Removes a room from this.adjacent.
     * @param roomID A room to remove from adjacent.
     */
    public final void removeAdjacent(String roomID) {
        this.adjacent.remove(roomID);
    }
    // ========================================================================
    public final void removeFurniture(Furniture removeThis) {
        this.furnishings.remove(removeThis);
    }
    // ========================================================================
    public final void addFurniture(Furniture ... furnishings) {
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
    // ========================================================================
    public boolean isThisLocked() {
        return this.isLocked; 
    }
    // ========================================================================
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
    // ========================================================================
    /**
     * Checks this room for a piece of furniture with the name.
     * @param name The name of a piece of furniture.
     * @return If your location contains furniture with that name.
     */
    public boolean hasFurniture(String name) {   
        for (Furniture i : this.furnishings) 
            for (String j : i.getValidNames()) 
                if (name.matches(j))
                    return true;

        return false;  
    }
    // ========================================================================
    public boolean hasFurniture(Furniture furn) {
        return this.furnishings.contains(furn);
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
}