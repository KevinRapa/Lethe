package Ancient_Tomb;

import A_Main.AudioPlayer;
import A_Main.Inventory;
import static A_Main.Names.BRAIN;
import A_Main.Player;
import A_Super.Item;
import A_Super.NonPlayerCharacter;
import A_Super.Note;
/**
 * An NPC that the player can talk to. Gives the player a tool to find the 
 * iridescent jewel.
 * 
 * @see Ancient_Tomb.Compass
 * @author Kevin Rapa
 */
public class Ant_Zombie extends NonPlayerCharacter {
    private final Item QUARTZ_DEVICE, ZOMBIE_NOTE;  // Zombie gives these to player.
    private final String CONVERSE_REP2;
    private final Inventory FLOOR_INV_REF;  // Zombie drops note if player inv is full.
    private boolean pleased;  // pleased once player gives brain to zombie.
    /*------------------------------------------------------------------------*/
    /*
        drawerNum is passed is from the Cry_Drawers, which randomly puts the
        jarred brain in one of them. This parameter is which drawer that is
        so that it can be written on the note. This class must be instantiated
        AFTER Cry_Drawers is as a result.
    */
    public Ant_Zombie (Inventory floorInv, int drawerNum) {
        super();
        
        this.QUARTZ_DEVICE = new Compass("quartz device");
        this.ZOMBIE_NOTE = new Zombie_Note("message", drawerNum);
        this.FLOOR_INV_REF = floorInv;
        this.pleased = false;
        
        this.description = "The hideous dessicated figure is eyeless and frail. It just\n" +
                           "stands there in the corner of the room, pointing\n" +
                           "its face at you with its mouth hanging open. It\n" +
                           "is clothed in simple farming vestments and keeps\n" +
                           "one of its hands in its pocket. 'Is it alive?'\n" +
                           "You wonder to yourself.";
        this.actDialog =    "The figure makes a loud moan. You jump, and every "
                          + "hair on your body stands. The zombie takes the "
                          + "brain in a jar from you and manages to stuff it "
                          + "in its small pocket. The figure pulls its hand "
                          + "out and offers you a small boxy object. The "
                          + "figure makes another load moan and holds its hand "
                          + "out. You take the item. The figure "
                          + "makes a final loud moan and remains quiet.";
        
        this.useDialog = "The zombie-like body, though horrific, appears passive. "
                       + "You aren't very inclined to attack it.";
        
        this.searchDialog = "You aren't nearly sly enough for that.";
        
        this.CONVERSE_REP2 = "The figure just stands there, staring at you with\n"
                           + "its mouth hanging open.";

        this.addUseKeys(BRAIN);
        this.addNameKeys("(?:frail )?(?:eyeless )?(?:dessicated )?(?:corpse|figure|zombie)", 
                "zombie-like (?:figure|body)", "him");
    }
    /*------------------------------------------------------------------------*/
    @Override public String useEvent(Item item) {
        if (item.toString().equals(BRAIN)) {
            Player.getInv().remove(item);
            this.pleased = true;
            this.firstTime = false;
            return converse1();
        }
        else
            return super.useEvent(item);
    }
    /*------------------------------------------------------------------------*/
    @Override public String interact(String key) { 
        if (key.matches(ATTACK_PATTERN))
            return ATTACK_DIALOG;
        else if (pleased || ! firstTime)
            // Once zombie is pleased, first time is immediately false. No
            // need to handle firstTime = true here.
            return converse2();
        else {
            AudioPlayer.playEffect(46);
            this.firstTime = false;
            return converse3();
        }
    }
    /*------------------------------------------------------------------------*/
    @Override protected String converse1() {
        // Player inv can't be full because the zombie just took the brain from the player.
        AudioPlayer.playEffect(46);
        Player.getInv().add(QUARTZ_DEVICE);
        return actDialog;
    }
    /*------------------------------------------------------------------------*/   
    @Override protected String converse2() {
        return CONVERSE_REP2;
    }
    /*------------------------------------------------------------------------*/
    private String converse3() {
        String result = "The figure looks at you with a hollow stare. "
                + "It slowly lifts its arm up and hands out a piece of paper.";
        
        if (Player.getInv().add(ZOMBIE_NOTE))
            return result.concat("You take the message. The figure then lifts "
                    + "its hand higher and points vaguely upwards.");
        else {
            FLOOR_INV_REF.add(ZOMBIE_NOTE);
            return result.concat("The paper slowly drifts to the floor "
                    + "from the zombie's weak grasp. The figure then lifts "
                    + "its hand higher and points vaguely upwards.");
        }
    }
    /*------------------------------------------------------------------------*/
    /**************************************************************************/
    /*------------------------------------------------------------------------*/   
    private static class Zombie_Note extends Note {
        public Zombie_Note(String name, int drawerNum) {
            super(name);
            this.description = "The wrinkled message has been written in what "
                    + "seems to be blunt charcoal. Only a single number is "
                    + "scrawled largely in the center: " + drawerNum+ ".";
        }
    }
    /*------------------------------------------------------------------------*/
    /**************************************************************************/
    /*------------------------------------------------------------------------*/
    private static class Compass extends Item {
        private Compass(String name) {
            super(name, 100);
            this.useID = 1;
            this.description = "You can't quite figure out what it is. It's a small\n"
                             + "metal box with a bit of heft. A polished rock of\n"
                             + "quartz has been fit into its center indentation, acting\n"
                             + "as a window of sorts. On the top and bottom of the box\n"
                             + "are copper plates.";
            this.useDialog = "You grasp the box firmly with your fingers and palm\n"
                           + "covering the plates. In a short while, 3 digits:\t\t[";
        }
        /*--------------------------------------------------------------------*/
        /**
         * Displays the player's coordinates in the GUI output window.
         * The coordinates are Cartesian, with the 1st floor being z = 0 and
         * the top row of rooms in the map array being y = 6.
         * @return coordinates of the player.
         */
        @Override public String useEvent() {
            int[] c = Player.getPos().getCoords();
            int z = Math.abs(c[0] - 6) - 3;
            int y = Math.abs(c[1] - 7);

            return this.useDialog.concat(c[2] + ", " + y + ", " + z + 
                                         "]\t\tmaterialize in the quartz window.");
        }
    }
}


