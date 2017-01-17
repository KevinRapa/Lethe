package Gallery;

import A_Super.Room;
/**
 * Contains the GAL1 dragon which is a light machine interacted with in the
 * gallery light machine puzzle.
 * 
 * @see Gallery.Gal1_Drgn
 * @author Kevin Rapa
 */
public class Gal1 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal1(String name, String ID) {
        super(name, ID);
        this.description= "You find yourself in a small, one-story room adjoining a\n" +
                          "larger round room. 'This room seems much different from\n" +
                          "the previous areas,' you note. The room is brightly lit\n" +
                          "with electric lights and the wall is tiled green and\n" +
                          "purple. The area is filled with paintings and sculptures\n" +
                          "of Asian origin. Other pieces include a katana displayed\n" +
                          "over a hearth on the south wall and an armor suit against\n" +
                          "the north wall. A screen stands in the corner of the room.\n"
                        + "One sculpture dwarfs the rest; a snake-like dragon\n" +
                          "displayed against the west wall.";
    }
/*----------------------------------------------------------------------------*/    
    @Override public String getDescription() {
        if (! this.hasFurniture("katana")) {
            return "You find yourself in a small, one-story room adjoining a\n" +
                   "larger, round room. 'This area seems much different from\n" +
                   "the previous areas' you think. The room is brightly lit\n" +
                   "with electric lights and the walls are tiled green and\n" +
                   "purple. This area is filled with paintings and sculptures\n" +
                   "of Asian origin. An armor suit stands against the north\n" +
                   "wall and a screen stands in the corner of the room.\n "
                 + "One sculpture dwarfs the rest though; a snake-like\n" +
                   "dragon, displayed against the west wall.";
        }
        return this.description;
    }
/*----------------------------------------------------------------------------*/  
}