package A_Super;
/**
 * A generic door, used when a room has multiple doors.
 * If the player specifies a 'door' in a room with many doors, this furniture
 * is accessed. Though all Door objects contain the valid name key 'door', this
 * object, being FIRST in the furnishings list, will be accessed first if the
 * player types 'door'.
 * 
 * @author Kevin Rapa
 */
public class GenDoor extends Furniture {
    // ========================================================================
    public GenDoor () {
        super();
        
        this.description = "There are several doors here. Use <direction 'door'>";
        this.searchDialog = this.description;
        this.useDialog = "You have no idea how to pick a lot. And do you really think that will fit in there?";
        this.actDialog = this.description;

        this.addUseKeys(ANYTHING);
        this.addNameKeys("door");
        this.addActKeys("open|close", "use", "kick|knock|bang", "unlock|lock");
    }
    // ======================================================================== 
}


