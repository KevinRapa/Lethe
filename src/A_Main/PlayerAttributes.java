package A_Main;

import A_Super.Room;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * This class holds all the attributes of the player to be serialized out to a file.
 * When a game starts, if save game data exists, the serialized instance of this
 * is read in and used as a template to form the player.
 * 
 * @author Kevin Rapa
 */
public final class PlayerAttributes implements Serializable {
    private final Room[][][] MAP;
    private final int[] OCC;
    private final Inventory INV, KEYS; 
    private final ArrayList<String> VISITED; 
    private final String LSTVISITED, SHOES; 
    // ========================================================================
    public PlayerAttributes() {
        this.MAP = Player.getMapRef();
        this.OCC = Player.getOcc().getCoords();
        this.INV = Player.getInv();
        this.KEYS = Player.getKeys();
        this.LSTVISITED = Player.getLastVisited();
        this.SHOES = Player.getShoes();
        this.VISITED = Player.getVisitedRooms();
    }
    // ========================================================================
    public void loadAttributes() {
        Player.loadAttributes(INV, KEYS, VISITED, LSTVISITED, SHOES, OCC, MAP);
    }
    // ========================================================================
}

