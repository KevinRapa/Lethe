package A_Super;

import static A_Main.Names.WEAPON;

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
    /*------------------------------------------------------------------------*/
    public GenDoor () {
        super();
        
        this.description = "There are several doors here. Use <direction 'door'>";
        this.searchDialog = this.description;
        this.useDialog = "...Do you intend to pick the lock with that? Well,\n"
                       + "perhaps you could, but then again, you are not learned\n"
                       + "of this skill. Yet another you yearn for at the moment.";
        this.actDialog = this.description;

        this.addUseKeys(ANYTHING);
        this.addNameKeys("door");
        this.addActKeys(ANYTHING);
    }
    /*------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        if (item.getType().equals(WEAPON)) 
            return "The door is build too solidly and breaking it down is futile.";
        else
            return this.useDialog;
        
    }
    /*------------------------------------------------------------------------*/
}


