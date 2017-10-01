package A_Super;

import static A_Main.Names.W_DIR;   import static A_Main.Names.SEP;
import static A_Main.Names.DATA;

import A_Main.AudioPlayer;          import A_Main.GUI;
import A_Main.RoomGraph;

import java.util.ArrayList;     import java.util.Arrays;
import java.io.BufferedReader;  import java.io.FileReader;
import java.io.IOException;     import java.io.Serializable;
import java.util.Iterator;

/**
 * <p>
 * Represents a room in the castle. 
 * The player always has a defined attribute of integer coordinates which
 * give access to furniture in the room when the player is at those coordinates.
 * </p> <p>
 * Each room has a unique ID string, roughly corresponding to the room name.
 * The IDs uniquely identify the room for the purposes of getting coordinates
 * and adjacent rooms. The ID is used by Keys as well.
 * </p> <p>
 * Rooms are adjacent to other rooms, which means that movement between them
 * is possible. Two adjacent rooms are separated by empty space if the first 3 letters
 * of their IDs match, excluding the caves and catacombs. Otherwise, they are
 * separated by a door, unless they are on two different floors, e.g. connected
 * by stairs.
 * </p> <p>
 * Rooms may be locked, which means that movement into them is not allowed unless
 * the player carries a key with the matching ID number.
 * </p> <p>
 * Rooms have a <code>triggeredEvent</code> method, called whenever the player 
 * enters. Generally, the method outputs the room name at least.
 * </p>
 * 
 * @see A_Main.RoomGraph
 * @author Kevin Rapa
 */
public class Room implements Serializable { 
    protected static final String 
        PATH = W_DIR + SEP + DATA + SEP + "desc" + SEP, // Path to desc folder
        WALL_BARRIER = "There is a wall that way.",
        EXT = ".txt";
    
    protected final String NAME, ID;           // Name and unique 4-letter ID.
    protected final int[] COORDS;              // Coordinates of this room.
    protected boolean locked;                  // Is this room locked?
    private transient String desc;             // Description of the room.
    protected final ArrayList<String> ADJ;     // Rooms moveable to from this.
    protected final ArrayList<Furniture> FURN; // Holds furniture.
    // CONSTRUCTOR ============================================================
    public Room(String name, String ID) {  
        this.ID = ID;
        this.NAME = name;
        this.locked = false;
        this.COORDS = RoomGraph.getCoords(this.ID);
        this.ADJ = RoomGraph.getAdj(this.ID);
        this.FURN = new ArrayList<>();
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
    public Furniture getFurnRef(int id) {
        // Name must be a pattern name.
        for(Furniture f : this.FURN) {
            if (f.getID() == id)
                return f;           
        }
        return null;
    }
    //-------------------------------------------------------------------------
    public String getDescription() {
        if (this.desc == null) {
            this.desc = (this instanceof Catacombs.Catacomb) ? 
                    readDescription("CT" + EXT) : readDescription(this.ID + EXT);
        }
        return this.desc;
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
                new FileReader(PATH + filename))) 
        {
            String descLine;
            StringBuilder descBuilder = new StringBuilder();

            while ((descLine = br.readLine()) != null)
                descBuilder.append(descLine);
            
            return descBuilder.toString();
        } 
        catch (IOException ex) {
            System.err.println("Could not find room description: " + ex.getMessage());
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
        return this.FURN;
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************    
    
    
//******************************************************************************
// <editor-fold desc="SETTERS">      
//******************************************************************************    
    public final void setLocked(boolean locked) {
        this.locked = locked; 
    }
    //-------------------------------------------------------------------------
    /**
     * Adds a room adjacent to this one.
     * @param roomID A room to be added to adjacent.
     */
    public final void addAdjacent(String roomID) {
        if (! this.ADJ.contains(roomID))
            this.ADJ.add(roomID);
    }
    //-------------------------------------------------------------------------
    /**
     * Removes a room from this.adjacent.
     * @param roomID A room to remove from adjacent.
     */
    public final void removeAdjacent(String roomID) {
        this.ADJ.remove(roomID);
    }
    //-------------------------------------------------------------------------
    public final void removeFurniture(int removeId) {
        Iterator<Furniture> iter = this.FURN.iterator();
        
        while (iter.hasNext()) {
            if (iter.next().getID() == removeId) {
                iter.remove();
                return;
            }
        }
        GUI.out("Suspicious: furniture to remove was not found.");
    }
    //-------------------------------------------------------------------------
    public final void addFurniture(Furniture ... furnishings) {
        this.FURN.addAll(Arrays.asList(furnishings));
        this.FURN.trimToSize();
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
        return NAME;
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
        return this.ADJ.contains(destination);
    } 
    //-------------------------------------------------------------------------
    /**
     * Checks this room for a piece of furniture with the name.
     * @param name the name of the furniture.
     * @return If your location contains furniture with that name.
     */
    public boolean hasFurniture(String name) {   
        return this.FURN.stream().anyMatch(i -> i.nameKeyMatches(name));
    }
    //-------------------------------------------------------------------------
    public boolean hasFurniture(int id) {
        return this.FURN.stream().anyMatch(i -> i.getID() == id);
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
}
