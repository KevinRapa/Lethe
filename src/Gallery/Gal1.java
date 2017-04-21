package Gallery;

import A_Super.Room;
/**
 * Contains the GAL1 dragon which is a light machine interacted with in the
 * gallery light machine puzzle.
 * Connects to Gal2 and Foyc
 * 
 * @see Back_Balcony.Bba2
 * @see Gallery.Gal2
 * @see Gallery.Gal1_Dragon
 * @author Kevin Rapa
 */
public class Gal1 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1(String name, String ID) {
        super(name, ID);
    }
//-----------------------------------------------------------------------------    
    @Override public String getDescription() {
        if (! this.hasFurniture("katana")) {
            return "You find yourself in a small, one-story room adjoining a " +
                   "larger, round room. The room is brightly lit " +
                   "with electric lights and the walls are tiled green and " +
                   "purple. This area is filled with paintings and sculptures " +
                   "of Asian origin. An armor suit stands against the north " +
                   "wall and a screen stands in the corner of the room. "
                 + "One sculpture dwarfs the rest though; a snake-like " +
                   "dragon, displayed against the west wall.";
        }
        else
            return this.description;
    }
//-----------------------------------------------------------------------------  
}
