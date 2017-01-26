package Escape_Tunnel;

import A_Main.GUI;
import A_Main.Id;
import A_Main.Player;
import static A_Main.NameConstants.HAND_TORCH;
import A_Super.Ceiling;
import A_Super.Room;
import A_Super.Direction;
import A_Super.Furniture;
import A_Super.Wall;
import Tunnels.DungeonMonsterFurniture;
import Tunnels.Dungeon_Floor;
/**
 * Represents the tunnels the player must walk through to escape INTR (cell).
 * 
 * @see Cell.Intr_Grt
 * @see Cell.Intr
 * @author Kevin Rapa
 */
public class Esc extends Room {
    private final Furniture MACHINERY_REF = new Esc_Mchnry(),
                            FLOOR_REF = new Esc_F(),
                            ESC_WALL = new Wall("The walls are masked by a wall of machinery."),
                            ESC_CLNG = new Ceiling() {{this.description = "The ceiling is pretty low here.";}};
    private final String MACHINERY_DESC = "You're crammed in a small utility tunnel.\n" +
            "Many pistons, gears, and other complicated machinery operate around you.\n"
          + "The hallway offers a bit of space in which to move forward. ",
                         REFUSE_TO_MOVE = "It's too dark to see anything, and there is\n"
          + "a lot of dangerous sounding machinery. You don't feel comfortable moving forward.",
                         TOO_DARK = "It's too dark to see anything at all. All you here is\n"
          + "a bunch of dangerous sounding machinery.";
// ============================================================================    
    public Esc(String name, String ID, String desc) {
        super(name, ID);
        this.description = desc;
        this.addFurniture(MACHINERY_REF, FLOOR_REF, ESC_WALL, ESC_CLNG, new DungeonMonsterFurniture());
    }
// ============================================================================
    @Override public String getBarrier(Direction dir) {
        if (playerHasTorch())
            return "There's a lot of dangerous looking machinery that way.";
        else
            return TOO_DARK;
    }
// ============================================================================
    @Override public String getDescription() {
        if (playerHasTorch())
            return this.MACHINERY_DESC + this.description;
        else
            return TOO_DARK;
    }
// ============================================================================
    @Override public String triggeredEvent() {
        if (! playerHasTorch() && ! Player.getPosId().equals(Id.ESC1)) {
            GUI.out(this.REFUSE_TO_MOVE);
            Player.setOccupies(Id.ESC1);
        }
        return "You are " + Player.getPos() + ".";
    }
// ============================================================================
    private boolean playerHasTorch() {
        return Player.hasItem(HAND_TORCH);
    }
// ============================================================================
// ****************************************************************************
// ============================================================================    
    public class Esc_Mchnry extends Furniture {
        public Esc_Mchnry () {
            super();
            this.searchable = false;

            this.description = "All sorts of dangerous exposed machinery operate\n"
                             + "around you. You better be careful moving. This\n"
                             + "machinery must power some areas of the castle?";
            this.actDialog = "You wouldn't dream of going anywhere near it.";
            this.searchDialog = "You best keep moving and get out of here.";

            this.addNameKeys("machinery", "gears", "pistons");
            this.addActKeys("touch", "operate");
        }
        @Override public String getDescription() {
            if (Esc.this.playerHasTorch())
                return this.description;
            else
                return Esc.this.TOO_DARK;
        }
    }
// ============================================================================
// ****************************************************************************    
// ============================================================================    
    private class Esc_F extends Dungeon_Floor {
        public Esc_F() {
            super();
            this.searchable = false;
            this.searchDialog = "There's nothing here, and you don't feel comfortable\n"
                              + "putting anything down where it will drop into oblivion.";
        }
        @Override public String getDescription() {
            if (Esc.this.playerHasTorch())
                return this.description;
            else
                return Esc.this.TOO_DARK;
        }
    }
// ============================================================================
// ****************************************************************************    
// ============================================================================       
}