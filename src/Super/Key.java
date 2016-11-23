package Super;
/* 
   Keys and your keyring are special. Keys are not meant to be stored.
   Keys are not used on anything. They only allow access to locked rooms.
   Keys are never added to your inventory, only to your key ring. 
*/
public class Key extends Item {
/* CONSTRUCTOR ---------------------------------------------------------------*/       
        /**
         * Constructor for a key.
         * @param name The string printed in your inventory.
         * @param ID An ID string which matches to the ID of the room this unlocks.
         */
    public Key(String name, String ID) {
        super(name);
        this.type = ID;
    }
/*----------------------------------------------------------------------------*/      
}
