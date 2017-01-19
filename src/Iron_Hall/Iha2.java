package Iron_Hall;

import A_Super.Room;

public class Iha2 extends Room{
    private boolean hasPolearm;
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Iha2(String name, String ID) {
        super(name, ID);
        this.hasPolearm = true;
        description= "You are on the south end of the sandstone hallway. Looking\n" +
                     "to the north, the hallway darkens and ends at a door on the\n" +
                     "other side. Just like in the north end, a suit of armor is\n" +
                     "displayed here looking out an open barred window on the hallway's east\n" +
                     "side. It hold a polearm in its gauntlet. Above you also hangs a steel bowl lit with fire.";
    }
/*----------------------------------------------------------------------------*/  
    public void removePolearm() {
        this.hasPolearm = false;
    }
/*----------------------------------------------------------------------------*/
    public void addPolearm() {
        this.hasPolearm = true;
    }
/*----------------------------------------------------------------------------*/
    @Override public String getDescription() {
        if (this.hasPolearm)
            return this.description;
        else
            return this.description.replaceAll(" It hold a polearm in its gauntlet.", "");
    }
/*----------------------------------------------------------------------------*/
}