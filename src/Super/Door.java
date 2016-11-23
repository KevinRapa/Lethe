package Super;

public class Door extends Furniture{
/* CONSTRUCTOR ---------------------------------------------------------------*/     
    public Door (String NAME) {
        super(NAME);
        this.searchable = false;
        this.searchDialog = "You aren't sure what you'd search for on a door.";
        this.description = "It looks like a heavy wooden door.";
        this.interactDialog = "You extend a confident hand towards the doorknob, but\n"
                    + "then think to yourself, 'am I the type of person who tests\n"
                    + "if doors are locked before opening? Well, do I test how hot\n"
                    + "my coffee is before sipping? No, I do not! That's why I am\n"
                    + "a strong protagonist. I won't intend to back down, defeated,\n"
                    + "to a locked door. If I'm going to use this door, I will,\n"
                    + "MOVE towards it, with a proud stride, ready to accept\n"
                    + "whatever challenge awaits! I don't just open doors, I\n"
                    + "conquer doors! With an arrogant smirk, you pull your hand\n"
                    + "away.";
        
        this.addActKeys("open", "use", "conquer", "punch", "hit");
        this.addNameKeys("door");
    }
/*----------------------------------------------------------------------------*/    
    @Override public String interact(Room[][][] map, String key) {
       String rep = this.interactDialog;
       
       if (key.matches("(conquer|hit|punch)")) {
           rep = "With a passionate fury, you punch the door as\n"
               + "hard as you can. \"OW!\" you yell, for the door\n"
               + "is of solid hickory.";
       }
       return rep;
    } 
/*----------------------------------------------------------------------------*/ 
}
