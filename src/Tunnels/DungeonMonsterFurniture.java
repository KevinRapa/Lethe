package Tunnels;

import A_Main.Id;
import A_Main.Player;
import A_Super.Furniture;
/**
 * Serves as a way to reference the tunnel monster.
 * This furniture is important, as it helps the player in determining where
 * the monster is.
 * 
 * @author Kevin Rapa
 */
public class DungeonMonsterFurniture extends Furniture {
    private final String CANT_SEE_IT = "You can't hear or see it from here.";
    private final String FAR_ROOMS_PATTERN = Id.CRY1+"|"+Id.CRY2+"|"+Id.DKCH+"|"+Id.TORC;
    // ========================================================================
    public DungeonMonsterFurniture () {
        super();
        this.searchable = false;
        
        this.description = "A disfigured corpse-like creature is roaming the tunnels.\n"
                         + "It holds a dangling chain wrapped around itself several times\n"
                         + "and drags its bare feet as it walks crookedly. ";
        this.actDialog = "You wouldn't ever think of going near that thing...";
        this.searchDialog = this.actDialog;

        this.addNameKeys("(?:disfigured )?(?:corpse-like )?(?:creature|monster)", "thing");
        this.addActKeys(".{2,}");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        String result;
        
        if (Player.getPosId().matches(FAR_ROOMS_PATTERN)) {
            result = CANT_SEE_IT;
        }
        else if (Player.getPosId().matches("ESC.")) {
            result = "It's lurking around somewhere above your head... You can't hear it though.";
        }
        else if ((DungeonMonster.getPos().matches("CIS\\d") && ! Player.getPosId().matches("CIS\\d|OUB1|AARC")) ||
                 (DungeonMonster.getPos().matches("SEW\\d") && ! Player.getPosId().matches("SEW[0-5P]|PRIS|INTR"))) {
            result = CANT_SEE_IT;
        }
        else {
            switch (DungeonMonster.getPos()) {
                case Id.SEW0: case Id.SEW1: case Id.SEW2:
                    result = "It's lurking at the east end of the tunnel.";
                    break;
                case Id.SEW3: case Id.SEW4: case Id.SEW5:
                    result = "It's lurking at the west end of the tunnel.";
                    break;
                case Id.CIS1: case Id.CIS2:
                    result = "It's lurking in the north end of the cistern walkway.";
                    break;
                default:
                    result = "It's lurking in the south end of the cistern walkway.";
            }
            
            if (Player.getPosId().matches("PRIS|OUB1|AARC"))
                result = result.concat(" You should be out of its line of sight from here.");
        }
        
        return this.description.concat("\t\t\t\t\t\t\t" + result);
    }
    // ========================================================================   
}


