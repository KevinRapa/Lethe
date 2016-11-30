package Super;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.Serializable;
import Core.Room_References;
/**
 * @author Kevin Rapa
 */
public class Room implements Serializable { 
    protected final String NAME, ID;    // The name and unique ID of the room.
    protected final int[] COORDS;       // Index coordinates of this room.
    protected boolean isLocked;         // You cannot move into a locked room.
    protected String description;       // Description of the room.
    protected ArrayList<String> adjacent; // List of rooms one can move to from this one.
    protected ArrayList<Furniture> furnishings; // Holds furniture.

    // CONSTRUCTOR ============================================================
    public Room(String name, String ID) {  
        this.NAME = name;
        this.ID = ID;
        this.isLocked = false;
        this.adjacent = new ArrayList();
        this.furnishings = new ArrayList();
        this.COORDS = Room_References.getCoord(this.ID); 
        this.adjacent = Room_References.getAdj(this.ID);
}
//******************************************************************************
// <editor-fold desc="GETTERS">
//******************************************************************************     
    /**
     * @return This room's name.
     */
    @Override public String toString() {
        return this.NAME; 
    }
    // ========================================================================
    /**
     * @return This room's unique ID.
     */
    public String getID() {
        return this.ID; 
    } 
    // ======================================================================== 
    /**
     * @return The coordinates of this room.
     */
    public int[] getCoords() {
        return this.COORDS;
    } 
    // ========================================================================
    /**
     * The description that prints whenever a room is entered.
     * @return A description of this room.
     * @see Player#describeRoom
     */
    public String getDescription() {
        return this.description; 
    }
    // ========================================================================
    /**
     * If the player fails a move, this prints a string of the reason.
     * @param dir A direction.
     * @return Why the move failed.
     */
    public String getBarrier(char dir) {
        // Used in movement when you hit a barrier. Overridden in many cases.
        return "There is a wall in the way.";
    }
    // ========================================================================
    /**
     * @return A list of the furniture in this room.
     */
    public ArrayList<Furniture> getFurnishings() {
        return this.furnishings;
    }
    // ========================================================================
    /**
     * Checks if this room is locked.
     * The player cannot enter a locked room without a key.
     * @return If this room is locked.
     */
    public boolean isThisLocked() {
        return this.isLocked; 
    }
    // ========================================================================  
    /**
     * The events that occur whenever the player enters this room.
     * This method is overwritten several specific rooms.
     * @param map A reference to other rooms used (e.g. vestibule).
     * @return A string default that says which room you are in.
     */
    public String triggeredEvent(Room[][][] map) {
        // Dialog of player entering. Sometimes other events occur.
        return "You are " + this + ".";
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
        for (Furniture i : this.furnishings) {
            for (String j : i.getValidNames()) {
                if (j.matches(name))
                    return true;
            }
        }
        return false;
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************    
    
    
//******************************************************************************
// <editor-fold desc="SETTERS">      
//******************************************************************************    
    public void lock() {
        this.isLocked = true;
    }
    // ========================================================================
    public void unlock() {
        this.isLocked = false; 
    }
    // ========================================================================
    /**
     * Adds a room adjacent to this one.
     * Used for the rotunda, secret doors, etc.
     * @param roomID A room to be added to this.adjacent.
     */
    public void addAdjacent(String roomID) {
        this.adjacent.add(roomID);
    }
    // ========================================================================
    /**
     * Removes a room from this.adjacent.
     * Used for the rotunda, secret doors, etc.
     * @param roomID A room to remove from this.adjacent.
     */
    public void removeAdjacent(String roomID) {
        this.adjacent.remove(roomID);
    }
    // ========================================================================
    /**
     * Removes furniture from this room.
     * @param removeThis Furniture to be removed;
     */
    public void removeFurniture(Furniture removeThis) {
        this.furnishings.remove(removeThis);
    }
    // ========================================================================
    /**
     * Adds furniture to this room.
     * @param furnishings list of furniture to add.
     */
    public void addFurniture(Furniture ... furnishings) {
        this.furnishings.addAll(Arrays.asList(furnishings));
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
}