package A_Main;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
/****************************************************************************
 * This class is used by each room when it is instantiated, and allows the
 * room to fetch its own coordinates and adjacent rooms by passing its ID.
 * The hash maps in this class populate themselves with 
 * <code>constructRoomReferences</code>.
 * @author Kevin Rapa                                                        
// ***************************************************************************/
public class RoomReferences {
    private static final HashMap<String, String[]> ADJACENTS = new HashMap<>();
    private static final HashMap<String, int[]> COORDINATES = new HashMap<>();

//******************************************************************************
// <editor-fold desc="ROOM IDS">  
// Each element maps to an element in ADJS for ADJACENTS.
// Each element maps to an element in COORDS for COORDINATES.
//******************************************************************************
    private static final String[] IDS = {
        Id.NULL, Id.END_,
        // FLOOR 1 ROOM ID'S --------------------------------------------------
        Id.COU1, Id.COU2, Id.COU3, Id.COU4, Id.COU5, Id.COU6, Id.COU7, Id.VEST, 
        Id.FOY1, Id.FOY2, Id.FOYW, Id.FOYB, Id.FOYC, Id.GAL1, Id.GAL2, Id.LIB1, 
        Id.LIB2, Id.LIB3, Id.BHA1, Id.BHA2, Id.BHA3, Id.OBS1, Id.STUD, Id.PAR1,
        Id.LOOK, Id.ROTU, Id.MHA1, Id.CHS1, Id.SQUA, Id.SHA2, Id.IHA1, Id.MHA2, 
        Id.DIN1, Id.SHAR, Id.SHA1, Id.IHA2, Id.MHA3, Id.KITC, Id.WBAL, Id.WOW1,
        Id.WOW2, Id.COUS, Id.DST1, Id.EOW1, Id.EOW2,
        // FLOOR 2 ROOM ID'S --------------------------------------------------
        Id.GAL5, Id.LIB4, Id.OBS2, Id.JHA1, Id.PAR2, Id.FOY3, Id.GAL3, Id.GAL4, 
        Id.LIB5, Id.SST1, Id.JHA2, Id.GAR1, Id.GAR2, Id.DIN2, Id.GAR3, Id.GAR4,
        Id.DRAR, Id.WOW3, Id.CLOS, Id.WORK, Id.EOW4,
        // FLOOR 3 ROOM ID'S --------------------------------------------------
        Id.OBS3, Id.ATT1, Id.LABO, Id.FOY4, Id.GAL6, Id.GAL7, Id.SST2, Id.ATT2, 
        Id.BLS1, Id.TOW1, Id.CHS3, Id.CHA1, Id.CHA2,
        // FLOOR 4 ROOM ID'S --------------------------------------------------
        Id.SOUL, Id.TBAL, Id.BLS2, Id.TOW2, Id.LQU1, Id.LQU2,
        // BASEMENT ROOM ID'S -------------------------------------------------
        Id.CAS1, Id.CRY2, Id.VAU1, Id.CIS2, Id.CIS1, Id.SEW5, Id.PRIS, Id.TORC, 
        Id.CRY1, Id.VAU2, Id.CIS4, Id.AARC, Id.SEW4, Id.SEW3, Id.SEW2, Id.SEW1,
        Id.VAUE, Id.CIS3, Id.OUB1, Id.INTR, Id.SEWP, Id.DKCH, Id.SEW0, Id.ESC1,
        Id.ESC2, Id.ESC3, Id.ESC4, Id.ESC5, Id.ESC6,    
        // CATACOMBS ROOM ID'S ------------------------------------------------
        Id.CS35, Id.OU62, Id.CT11, Id.CT12, Id.CT13, Id.CT14, Id.CT15, Id.TM16, 
        Id.CT17, Id.MY18, Id.CT21, Id.CT22, Id.CT23, Id.CT24, Id.CT25, Id.CT26,
        Id.CT27, Id.CT28, Id.CT31, Id.TM32, Id.CT33, Id.CT34, Id.CT36, Id.CT37,
        Id.CT38, Id.CT41, Id.CT42, Id.CT43, Id.CT44, Id.CT45, Id.CT46, Id.CT47,
        Id.CT48, Id.CT51, Id.CT52, Id.CT53, Id.CT54, Id.AN55, Id.CT56, Id.CT57,
        Id.CT58, Id.CT61, Id.CT63, Id.CT64, Id.AN65, Id.TM66, Id.CT67, Id.CT68,
        // CAVES ROOM ID'S ----------------------------------------------------
        Id.CV11, Id.CV12, Id.CV13, Id.CV14, Id.CV15, Id.CV16, Id.CV17, Id.CV18, 
        Id.CV21, Id.CV22, Id.CV23, Id.CV24, Id.CV25, Id.CV26, Id.CV27, Id.CV28,
        Id.CV31, Id.CV32, Id.CV33, Id.CV34, Id.CV35, Id.CV36, Id.CV37, Id.CV38,
        Id.CV41, Id.CV42, Id.CV43, Id.CV44, Id.CV45, Id.CV46, Id.CV47, Id.CV48,
        Id.CV51, Id.CV52, Id.CV53, Id.CV54, Id.CV55, Id.CV56, Id.CV57, Id.CV58,
        Id.CV61, Id.CV62, Id.CV63, Id.CV64, Id.MS65, Id.MS66, Id.CV67, Id.CV68
        };
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
    
    
//******************************************************************************
// <editor-fold desc="ADJACENTS">  
//******************************************************************************
    private static final String[][] ADJS = {
        {}, {},       
        // FLOOR 1 ROOM ADJS --------------------------------------------------   
        {Id.COU2},                          {Id.COU1,Id.COU3}, 
        {Id.COU7,Id.COU4,Id.COU2,Id.COU5},  {Id.COU3},
        {Id.COU3,Id.COU6},                  {Id.COU5}, 
        {Id.FOY1,Id.COU3},                  {Id.FOY1}, 
        {Id.FOY2,Id.VEST,Id.FOYW,Id.COU7},  {Id.FOY1,Id.FOYB,Id.FOY3}, 
        {Id.FOY1,Id.ROTU},                  {Id.FOYC,Id.FOY2}, 
        {Id.GAL1,Id.FOYB},                  {Id.GAL2,Id.GAL3,Id.FOYC}, 
        {Id.GAL1,Id.LIB3,Id.MHA1},          {Id.LIB2}, 
        {Id.LIB3},                          {Id.LIB2,Id.LIB5,Id.GAL2}, 
        {Id.OBS1,Id.BHA2},                  {Id.BHA1,Id.BHA3}, 
        {Id.BHA2,Id.PAR1},                  {Id.BHA1,Id.OBS2}, 
        {Id.ROTU},                          {Id.PAR2}, 
        {Id.ROTU},                          {Id.FOYW,Id.LOOK}, 
        {Id.MHA2,Id.GAL2,Id.CHS1},          {Id.MHA1}, 
        {Id.SHA2},                          {Id.SHA1,Id.SQUA}, 
        {Id.IHA2,Id.ROTU},                  {Id.MHA1,Id.MHA3,Id.DIN1},  
        {Id.DIN2,Id.MHA2},                  {Id.SHA1},  
        {Id.SHA2,Id.WOW1},                  {Id.IHA1,Id.WOW2}, 
        {Id.KITC,Id.EOW1,Id.MHA2},          {Id.MHA3},  
        {Id.WOW1},                          {Id.WBAL,Id.WOW2,Id.SHA1},  
        {Id.IHA2,Id.WOW1},                  {}, 
        {Id.EOW1,Id.SEW0},                  {Id.EOW2,Id.DST1,Id.MHA3}, 
        {Id.EOW1},
        // FLOOR 2 ROOM ADJS --------------------------------------------------
        {Id.GAL4},                          {Id.LIB5}, 
        {Id.OBS1,Id.OBS3},                  {Id.JHA2,Id.PAR2},
        {Id.PAR1,Id.FOY3,Id.JHA1},          {Id.PAR2,Id.FOY2,Id.FOY4}, 
        {Id.GAL4,Id.GAL1},                  {Id.GAL3,Id.GAL5}, 
        {Id.LIB3,Id.LIB4},                  {Id.SST2,Id.JHA2},
        {Id.JHA1,Id.GAR2},                  {Id.GAR2,Id.GAR3}, 
        {Id.JHA2,Id.GAR1,Id.GAR4},          {Id.DIN1,Id.DRAR}, 
        {Id.GAR1,Id.GAR4},                  {Id.GAR3,Id.GAR2}, 
        {Id.DIN2},                          {Id.CLOS,Id.WOW2}, 
        {Id.WOW3,Id.COUS},                  {Id.EOW4}, 
        {Id.WORK,Id.EOW2},        
        // FLOOR 3 ROOM ADJS --------------------------------------------------
        {Id.OBS2},                          {Id.LABO,Id.ATT2}, 
        {Id.ATT1},                          {Id.TOW1,Id.FOY3}, 
        {Id.GAL3},                          {}, 
        {Id.ATT2,Id.SST1},                  {Id.ATT1,Id.SST2}, 
        {Id.BLS2,Id.TOW1},                  {Id.FOY4,Id.BLS1}, 
        {Id.CHA1},                          {Id.CHA2,Id.CHS3},           
        {Id.CHA1},                         
        // FLOOR 4 ROOM ADJS --------------------------------------------------
        {Id.TBAL},                          {Id.SOUL,Id.TOW2}, 
        {Id.TOW2,Id.BLS1},                  {Id.TBAL,Id.BLS2,Id.LQU1}, 
        {Id.TOW2},                          {Id.LQU1},       
        // BASEMENT ROOM ADJS -------------------------------------------------
        {Id.CS35},                          {Id.CRY1}, 
        {Id.VAU2},                          {Id.CIS3,Id.CIS1}, 
        {Id.CIS2,Id.SEW5},                  {Id.SEW4,Id.CIS1,Id.PRIS}, 
        {Id.TORC,Id.SEW3,Id.SEW5},          {Id.PRIS,Id.CRY1}, 
        {Id.TORC,Id.CRY2},                  {Id.VAU1,Id.VAUE}, 
        {Id.CIS3,Id.OUB1},                  {Id.CIS3}, 
        {Id.SEW5,Id.SEW3},                  {Id.SEWP,Id.SEW4,Id.SEW2,Id.PRIS}, 
        {Id.SEW3,Id.SEW1},                  {Id.SEW0,Id.SEW2},
        {Id.VAU2},                          {Id.AARC,Id.CIS4,Id.CIS2}, 
        {Id.CIS4},                          {Id.SEWP},
        {Id.INTR,Id.DKCH,Id.SEW3},          {Id.SEWP}, 
        {Id.SEW1,Id.DST1},                  {Id.ESC2}, 
        {Id.ESC1,Id.ESC3},                  {Id.ESC2,Id.ESC4}, 
        {Id.ESC3,Id.ESC5},                  {Id.ESC4,Id.ESC6}, 
        {Id.ESC5},
        // SUB-LEVEL ROOM ADJS ------------------------------------------------
        {Id.CAS1,Id.CT34},                  {Id.OUB1,Id.CT52}, 
        {Id.CT21,Id.CT12},                  {Id.CT11,Id.CT13,Id.CT22},
        {Id.CT12,Id.CT14},                  {Id.CT13,Id.CT15,Id.CT24},
        {Id.CT14},                          {Id.CT26}, 
        {Id.MY18,Id.CT27},                  {Id.CT17}, 
        {Id.CT11},                          {Id.CT12,Id.CT23}, 
        {Id.CT22,Id.CT33},                  {Id.CT14,Id.CT25},
        {Id.CT24,Id.CT26},                  {Id.TM16,Id.CT25}, 
        {Id.CT17,Id.CT28},                  {Id.CT27,Id.CT38},
        {Id.TM32,Id.CT41},                  {Id.CT31}, 
        {Id.CT23,Id.CT34,Id.CT43},          {Id.CT33,Id.CS35},
        {Id.CT37,Id.CT46},                  {Id.CT36}, 
        {Id.CT28,Id.CT48},                  {Id.CT31,Id.CT51},
        {Id.CT43,Id.CT52},                  {Id.CT33,Id.CT42}, 
        {Id.CT45,Id.CT54},                  {Id.CT44,Id.CT46,Id.AN55},
        {Id.CT45,Id.CT36,Id.CT56},          {Id.CT57}, 
        {Id.CT38,Id.CT58},                  {Id.CT41,Id.CT52,Id.CT61},
        {Id.CT51,Id.CT42,Id.CT53,Id.OU62},  {Id.CT52,Id.CT54}, 
        {Id.CT44,Id.CT53,Id.CT64},          {Id.CT45,Id.AN65}, 
        {Id.CT46,Id.CT57},                  {Id.CT56,Id.CT47,Id.CT58},
        {Id.CT48,Id.CT57,Id.CT68},          {Id.CT51}, 
        {Id.CT64},                          {Id.CT54,Id.CT63},
        {Id.AN55},                          {Id.CT67}, 
        {Id.TM66,Id.CT68},                  {Id.CT67,Id.CT58},
        // CAVES ROOM ADJS ----------------------------------------------------
        {Id.CV21},                          {Id.CV13,Id.CV22}, 
        {Id.CV12,Id.CV14},                  {Id.CV13,Id.CV24}, 
        {Id.CV25,Id.CV16},                  {Id.CV15,Id.CV17}, 
        {Id.CV16,Id.CV27,Id.CV18},          {Id.CV17,Id.MY18}, 
        {Id.CV11,Id.CV31},                  {Id.CV12,Id.CV23}, 
        {Id.CV22},                          {Id.CV14,Id.CV34}, 
        {Id.CV15,Id.CV26},                  {Id.CV25}, 
	{Id.CV17,Id.CV37},                  {Id.CV38}, 
        {Id.CV21,Id.CV32},                  {Id.CV31,Id.CV33}, 
        {Id.CV32,Id.CV34},                  {Id.CV24,Id.CV33,Id.CV35,Id.CV44}, 
        {Id.CV34,Id.CV45},                  {Id.CV46,Id.CV37}, 
	{Id.CV27,Id.CV36,Id.CV38},          {Id.CV37,Id.CV28,Id.CV48}, 
        {Id.CV42},                          {Id.CV41,Id.CV43}, 
	{Id.CV42,Id.CV53},                  {Id.CV34,Id.CV54}, 
        {Id.CV35,Id.CV46},                  {Id.CV45,Id.CV36}, 
        {Id.CV57},                          {Id.CV38,Id.CV58}, 
        {Id.CV61,Id.CV52},                  {Id.CV51,Id.CV53,Id.CV62}, 
        {Id.CV52,Id.CV54,Id.CV43},          {Id.CV53,Id.CV55,Id.CV44},
        {Id.CV54},                          {Id.CV57}, 
        {Id.CV47,Id.CV67,Id.CV56,Id.CV58},  {Id.CV48,Id.CV68,Id.CV57}, 
        {Id.CV51},                          {Id.CV63,Id.CV52}, 
        {Id.CV62,Id.CV64},                  {Id.CV63,Id.MS65}, 
        {Id.CV64,Id.MS66},                  {Id.MS65}, 
        {Id.CV57},                          {Id.CV58}
    };
//******************************************************************************    
// </editor-fold>  
//******************************************************************************    
    
    
//******************************************************************************
// <editor-fold desc="COORDINATES">  
//****************************************************************************** 
    private static final int[][] COORDS = {  
       {-1,-1,-1}, {3, 7, 5},
       // 1ST FLOOR COORDINATES ----------------------------------------------
       {3,4,4}, {3,5,4}, {3,5,5}, {3,6,5}, {3,5,6}, {3,4,6}, {3,4,5}, {3,3,6}, 
       {3,3,5}, {3,2,5}, {3,3,4}, {3,1,5}, {3,1,6}, {3,2,6}, {3,2,7}, {3,1,7}, 
       {3,1,8}, {3,2,8}, {3,1,2}, {3,1,3}, {3,1,4}, {3,2,2}, {3,2,3}, {3,2,4},
       {3,3,2}, {3,3,3}, {3,3,7}, {3,3,8}, {3,4,1}, {3,4,2}, {3,4,3}, {3,4,7}, 
       {3,4,8}, {3,5,1}, {3,5,2}, {3,5,3}, {3,5,7}, {3,5,8}, {3,6,1}, {3,6,2}, 
       {3,6,3}, {3,6,4}, {3,6,6}, {3,6,7}, {3,6,8},         
       // 2ND FLOOR COORDINATES ----------------------------------------------        
       {2,1,7}, {2,1,8}, {2,2,2}, {2,2,3}, {2,2,4}, {2,2,5}, {2,2,6}, {2,2,7}, 
       {2,2,8}, {2,3,2}, {2,3,3}, {2,4,2}, {2,4,3}, {2,4,8}, {2,5,2}, 
       {2,5,3}, {2,5,8}, {2,6,3}, {2,6,4}, {2,6,7}, {2,6,8},       
       //3RD FLOOR COORDINATES -----------------------------------------------        
       {1,2,2}, {1,2,3}, {1,2,4}, {1,2,5}, {1,2,6}, {1,2,7}, {1,3,2}, {1,3,3}, 
       {1,3,4}, {1,3,5}, {1,3,8}, {1,4,8}, {1,5,8},  
       // 4TH FLOOR COORDINATES ----------------------------------------------        
       {0,1,5}, {0,2,5}, {0,3,4}, {0,3,5}, {0,3,6}, {0,3,7},       
       // BASEMENT COORDINATES -----------------------------------------------    
       {4,3,5}, {4,3,6}, {4,3,8}, {4,4,1}, {4,4,2}, {4,4,3}, {4,4,4}, {4,4,5},
       {4,4,6}, {4,4,8}, {4,6,1}, {4,5,2}, {4,5,3}, {4,5,4}, {4,5,5}, {4,5,6},
       {4,5,8}, {4,5,1}, {4,6,2}, {4,6,3}, {4,6,4}, {4,6,5}, {4,6,6}, {4,2,2},
       {4,2,1}, {4,1,1}, {4,1,2}, {4,1,3}, {4,2,3},
       // CATACOMBS COORDINATES ----------------------------------------------      
       {5,3,5}, {5,6,2}, {5,1,1}, {5,1,2}, {5,1,3}, {5,1,4}, {5,1,5}, {5,1,6},
       {5,1,7}, {5,1,8}, {5,2,1}, {5,2,2}, {5,2,3}, {5,2,4}, {5,2,5}, {5,2,6},
       {5,2,7}, {5,2,8}, {5,3,1}, {5,3,2}, {5,3,3}, {5,3,4}, {5,3,6}, {5,3,7}, 
       {5,3,8}, {5,4,1}, {5,4,2}, {5,4,3}, {5,4,4}, {5,4,5}, {5,4,6}, {5,4,7}, 
       {5,4,8}, {5,5,1}, {5,5,2}, {5,5,3}, {5,5,4}, {5,5,5}, {5,5,6}, {5,5,7}, 
       {5,5,8}, {5,6,1}, {5,6,3}, {5,6,4}, {5,6,5}, {5,6,6}, {5,6,7}, {5,6,8},   
       // CAVES ROOM ADJS ----------------------------------------------------
       {6,1,1}, {6,1,2}, {6,1,3}, {6,1,4}, {6,1,5}, {6,1,6}, {6,1,7}, {6,1,8}, 
       {6,2,1}, {6,2,2}, {6,2,3}, {6,2,4}, {6,2,5}, {6,2,6}, {6,2,7}, {6,2,8}, 
       {6,3,1}, {6,3,2}, {6,3,3}, {6,3,4}, {6,3,5}, {6,3,6}, {6,3,7}, {6,3,8}, 
       {6,4,1}, {6,4,2}, {6,4,3}, {6,4,4}, {6,4,5}, {6,4,6}, {6,4,7}, {6,4,8},
       {6,5,1}, {6,5,2}, {6,5,3}, {6,5,4}, {6,5,5}, {6,5,6}, {6,5,7}, {6,5,8}, 
       {6,6,1}, {6,6,2}, {6,6,3}, {6,6,4}, {6,6,5}, {6,6,6}, {6,6,7}, {6,6,8}
    };
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
    
    
//******************************************************************************
// <editor-fold desc="HASHMAP ASSEMBLER AND GETTERS">  
//******************************************************************************     
    /**
     * Constructs the two hash maps.
     */
    public static void constructRoomReferences() {
        int index = 0;

        for (String key : IDS) {
            ADJACENTS.put(key, ADJS[index]);   
            index++; 
        }
        constructCoorinateReferences();
    }
    // ========================================================================
    /**
     * Used when a saved game is loaded.
     */
    public static void constructCoorinateReferences() {
        int index = 0;

        for (String key : IDS) {
            COORDINATES.put(key, COORDS[index]);
            index++; 
        }
    }
    // ========================================================================
    /**
     * For any room, this returns which rooms are accessible from it.
     * @param ID A room ID.
     * @return A list of rooms adjacent to the room.
     */
    public static ArrayList getAdj(String ID) {
        ArrayList<String> result = new ArrayList<>();
        result.addAll(Arrays.asList(ADJACENTS.get(ID)));
        return result;
    }
    // ========================================================================  
    /**
     * For any room, this returns its coordinates in the castle array.
     * @param ID A room ID
     * @return The room's coordinates in the castle array.
     */
    public static int[] getCoords(String ID) {
        return COORDINATES.get(ID);
    }
//******************************************************************************    
// </editor-fold>  
//******************************************************************************       
}
