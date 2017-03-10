package Tunnels;

import A_Main.Player;
import A_Super.Furniture;
import static A_Main.Id.*;
import A_Main.NameConstants;
import static A_Main.Patterns.*;
import A_Super.Item;
/**
 * Serves as a way to reference the tunnel monster.
 * This furniture is important, as it helps the player in determining where
 * the monster is.
 * 
 * @author Kevin Rapa
 */
public class DungeonMonsterFurniture extends Furniture {
    private final String CANT_SEE_IT = "You can't hear or see it from here.";
    private final String FAR_ROOMS_PATTERN = CRY1+"|"+CRY2+"|"+DKCH+"|"+TORC;
    // ========================================================================
    public DungeonMonsterFurniture () {
        super();

        this.description = "A disfigured corpse-like creature is roaming the tunnels.\n"
                         + "It holds a dangling chain wrapped around itself several times\n"
                         + "and drags its bare feet as it walks crookedly. ";
        this.actDialog = "It's probably best to stay as far from that thing as possible.";
        this.searchDialog = this.useDialog = this.actDialog;

        this.addNameKeys("(?:disfigured )?(?:corpse-like )?(?:creature|monster|thing)", 
                "(?:unsettling )?(?:noise|sound)");
        this.addUseKeys(ANYTHING);
        this.addActKeys(".{2,}");
    }
    // ======================================================================== 
    @Override public String getDescription() {
        String result;
        
        if (Player.getPosId().matches(FAR_ROOMS_PATTERN)) {
            result = CANT_SEE_IT;
        }
        else if (areaName(Player.getPosId()).equals("ESC")) {
            result = "It's lurking around somewhere above your head... You can't hear it though.";
        }
        else if ((areaName(DungeonMonster.getPos()).equals("CIS") && 
                        ! NO_SEE_AREA_W.matcher(Player.getPosId()).matches()) ||
                 (areaName(DungeonMonster.getPos()).equals("SEW") && 
                        ! NO_SEE_AREA_E.matcher(Player.getPosId()).matches())) 
        {
            result = CANT_SEE_IT;
        }
        else {
            switch (DungeonMonster.getPos()) {
                case SEW0: case SEW1: case SEW2:
                    result = "It's lurking at the east end of the tunnel.";
                    break;
                case SEW3: case SEW4: case SEW5:
                    result = "It's lurking at the west end of the tunnel.";
                    break;
                case CIS1: case CIS2:
                    result = "It's lurking in the north end of the cistern walkway.";
                    break;
                default:
                    result = "It's lurking in the south end of the cistern walkway.";
            }
            
            if (SAFE_AREA.matcher(Player.getPosId()).matches())
                result = result.concat(" You should be out of its line of sight from here.");
        }
        
        return this.description.concat("\t\t\t\t\t\t\t" + result);
    }
    // ========================================================================   
}


