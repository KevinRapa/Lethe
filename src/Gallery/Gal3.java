package Gallery;

import A_Super.Room;
/**
 * Contains the totem, part of the light puzzle, and a raised ladder which
 * gives access to the gallery loft.
 * 
 * @see Gallery.Gal3_Totem
 * @see Gallery.Gal4
 * @see Gallery.Gal6
 * @author Kevin Rapa
 */
public class Gal3 extends Room{
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Gal3(String name, String ID) {
        super(name, ID);
        description= 
                "Many sub-Saharan African artifacts and masks decorate\n" +
                "this wing of the gallery. The most noteable piece is a tall\n" +
                "wooden totem standing against the room's west wall. A big\n" +
                "stringed instrument is displayed above another hearth on\n" +
                "the south wall. Above you and to the north is an open hatch\n" +
                "leading to the next floor up. A ladder protrudes down through\n" +
                "the hatch and is suspended above the floor by a rope\n" +
                "holding it up.";
    }
/*----------------------------------------------------------------------------*/
}
