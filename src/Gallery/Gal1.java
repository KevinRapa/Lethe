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
        if (! this.hasFurniture("katana")) 
            return super.getDescription()
                    .replaceFirst("A katana is displayed " +
                                "over a hearth on the south wall and an armor suit " +
                                "against the north wall", 
                            "A hearth rests against the south wall and an armor suit is north");
        else
            return super.getDescription();
    }
//-----------------------------------------------------------------------------  
}
