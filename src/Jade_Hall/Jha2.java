package Jade_Hall;
/**
 * @author Kevin Rapa
 */
import A_Super.Room;
import A_Super.Furniture;

public class Jha2 extends Room {
    private final Jha_Ln LION_REF, LION_REF2;
    private final Furniture MYSTDR_REF, DR_REF;
    private final String desc2;
// ============================================================================    
    public Jha2(String name, String ID, Furniture ln, Furniture ln2, Furniture mystDr, Furniture dr) {
        super(name, ID);
        this.description= "You stand at the south end of the hall near a\n" +
                          "southern door leading outside. At this end,\n" +
                          "another jade lion at the east stares at\n" +
                          "the blank western wall. A lantern hangs in the\n" +
                          "center of this half of the hall.";
        this.desc2 = "You stand at the south end of the hall near a\n" +
                     "southern door leading outside. The jade lion at the east\n"
                   + "stares at the newly formed door on the west wall. A lantern\n"
                   + "hangs in the center of this half of the hall.";
        this.LION_REF = (Jha_Ln)ln;
        this.LION_REF2 = (Jha_Ln)ln;
        this.MYSTDR_REF = mystDr;
        this.DR_REF = dr;
    }
// ============================================================================
    public String lionCheck() {
        if (LION_REF.hasRuby() && LION_REF2.hasRuby()) {
            this.removeFurniture(DR_REF);
            this.addFurniture(MYSTDR_REF);
            this.addAdjacent("SST1");
            return "At this moment, you hear a strange noise coming from close\n"
                 + "behind you. You turn and discover that mysterious door has\n"
                 + "materialized at the south end of the hallway.";
        }
        return "";
    }
// ============================================================================
    @Override public String getDescription() {
        if (this.hasFurniture("mysterious door"))
            return this.desc2;
        else
            return this.description;
    }
// ============================================================================
}