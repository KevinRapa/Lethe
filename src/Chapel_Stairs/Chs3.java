package Chapel_Stairs;

import Super.Room;

public class Chs3 extends Room {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Chs3(String name, String ID) {
        super(name, ID);
        description= "You stand a few stories up on the tower's top floor. A door\n"
                   + "stands solemnly in the south wall. The room is otherwise\n"
                   + "unfurnished and carries the notion of purity.";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getBarrier(char dir) {
        
        if (dir == 'a')
            return "The landing's railing protects you from tumbling three stories.";
        
        return "There is a wall in the way.";
    }
/*----------------------------------------------------------------------------*/
}