package Tower;

import A_Super.Furniture;
import Lichs_Quarters.Lich_Room;
/**
 * @author Kevin Rapa
 */
public class Tow1 extends Lich_Room {
    private final Furniture TOW_PEDESTAL;
// ============================================================================    
    public Tow1(String name, String ID, Furniture pedestal) {
        super(name, ID);
        this.TOW_PEDESTAL = pedestal;
        this.lichDead = false;
        this.description= "Through the door, you find yourself standing in a plain\n" +
                          "circular room with a blue and white checkered floor. Looking\n" +
                          "up, the room is a few stories high with a circular balcony\n" +
                          "wrapping around the room one story up. Wide paned windows\n" +
                          "extend along the south and east walls. On the west side\n" +
                          "is a pair of imposing black iron doors. Sitting in the\n" +
                          "center of a room is a pedestal. ";
    }
// ============================================================================
    @Override public String getDescription() {
        String result = this.description.concat(TOW_PEDESTAL.getDescription());
        
        if (! this.lichDead)
            return result.replaceFirst("\\s(?=Wide)", " You see a magnificent glowing sphere of light hovering in the highest area of the tower. ");
        
        return result;
    }
// ============================================================================
}