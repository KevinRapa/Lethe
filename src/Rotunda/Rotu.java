package Rotunda;

import Super.Room;

public class Rotu extends Room{
    private final Room REF;
    private String state;

/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Rotu(String name, String ID, Room want) {
        super(name, ID);
        description = "You are in a symmetrical dome-shaped chamber. Everything\n" +
                      "is ornate and carved from polished rock. A fountain in the \n" +
                      "center serves as a focus. At each diagonal below a spherical\n" +
                      "sconce is a glaring statue projecting from the wall. Various\n" +
                      "potted plants decorate the room. Looking straight up, there's\n" +
                      "a hole in the ceiling giving view to the sky. Only a single\n" +
                      "other door to the west is apparent. At the north and south\n" +
                      "ends are peculiar arched frames carved into the wall. Your\n" +
                      "only complaint is that this room smells quite awful.";
        this.REF = want;
        this.state = "EW";
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        String rep = this.description;
        if (this.state.matches("NS")) {
            rep = "The room appears unchanged. The fountain, along with\n"
                + "everything else remain still.";
        }           
        return rep; 
    }    
/*----------------------------------------------------------------------------*/
    public void rotate() {
        if (this.state.matches("EW")) {
            this.addAdjacent("STUD");
            this.addAdjacent("IHA1"); 
            this.removeAdjacent("FOYW");
            this.removeAdjacent("LOOK");
            this.REF.removeAdjacent("ROTU");
            this.state = "NS";
        }
        else if (this.state.matches("NS")) {
            this.addAdjacent("FOYW");
            this.addAdjacent("LOOK"); 
            this.removeAdjacent("STUD");
            this.removeAdjacent("IHA1");
            this.REF.addAdjacent("ROTU");
            this.state = "EW"; 
        }    
    }
/*----------------------------------------------------------------------------*/        
    public String getState() {
        return this.state;
    }
/*----------------------------------------------------------------------------*/   
}
