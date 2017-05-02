package Forest;

import A_Main.Player;

/**
 * Player dies if the player wanders too far from the castle. Ah well!
 * @author Kevin Rapa
 */
public class For5 extends Forest {
//-----------------------------------------------------------------------------
    public For5(String ID) {
        super(ID);
    }
//-----------------------------------------------------------------------------
    @Override public String triggeredEvent() {
        Player.commitSuicide("All of the sudden, a clumsy step sends the player "
                + "tumbling down a shallow easterly hill. Sheer unluck sends "
                + "the player straight into the open mouth of a nearby "
                + "yawning python. You are dead.");
        return "";
    }
//-----------------------------------------------------------------------------
}