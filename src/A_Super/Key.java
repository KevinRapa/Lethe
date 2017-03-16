package A_Super;
/** 
 * Keys are not used on anything, they only allow access to locked rooms.
 * Keys and your key ring are special. Keys are not meant to be stored.
 * Keys are never added to your inventory, only to your key ring. 
 * 
 * The key type is matched to a room ID; the room that the key 'unlocks'
 * 
 * @author Kevin Rapa
 */
public class Key extends Item {
/* CONSTRUCTOR ---------------------------------------------------------------*/       
    public Key(String name, String ID) {
        super(name, 0);
        this.type = ID;
    }
/*----------------------------------------------------------------------------*/      
}
