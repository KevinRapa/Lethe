package A_Main; 

import static A_Main.Id.*;
import java.util.ArrayList;

import java.util.HashMap; import java.util.Arrays; import java.util.HashSet;
/**************************************************************************** 
 * This class is used by each room when it is instantiated, and allows the 
 * room to fetch its own coordinates and adjacent rooms by passing its  
 * The hash maps in this class populate themselves with 
 * constructRoomGraph. 
 * @author Kevin Rapa 
 ****************************************************************************/ 

public class RoomGraph { 
    private static final HashMap<String, String[]> ADJACENTS = new HashMap<>();
    private static final HashMap<String, int[]> COORDINATES = new HashMap<>(); 
    
//****************************************************************************** 
// <editor-fold defaultstate="collapsed" desc="IDS"> 
// Each element maps to an element in ADJS for ADJACENTS. 
// Each element maps to an element in COORDS for COORDINATES. 
//****************************************************************************** 
    private static final String[] IDS = { 
        NULL, ENDG, HADS,
        // FLOOR 1 ROOM ID'S -------------------------------------------------- 
        COU1, COU2, COU3, COU4, COU5, COU6, COU7, VEST, FOY1, FOY2, FOYW, FOYB, 
        FOYC, GAL1, GAL2, LIB1, LIB2, LIB3, BHA1, BHA2, BHA3, OBS1, STUD, PAR1, 
        LOOK, ROTU, MHA1, CHS1, SQUA, SHA2, IHA1, MHA2, DIN1, SHAR, SHA1, IHA2, 
        MHA3, KITC, WBAL, WOW1, WOW2, COUS, DST1, EOW1, EOW2, COU8, FOR1, FOR2,
        FOR3, FOR4, FOR5,
        // FLOOR 2 ROOM ID'S -------------------------------------------------- 
        GAL5, LIB4, OBS2, JHA1, PAR2, FOY3, GAL3, GAL4, LIB5, SST1, JHA2, GAR1, 
        GAR2, DIN2, GAR3, GAR4, DRAR, WOW3, CLOS, WORK, EOW4, 
        // FLOOR 3 ROOM ID'S -------------------------------------------------- 
        OBS3, ATT1, LABO, FOY4, GAL6, GAL7, SST2, ATT2, BLS1, TOW1, CHS3, CHA1, 
        CHA2, 
        // FLOOR 4 ROOM ID'S --------------------------------------------------
        // CEL rooms are actually under the Rotunda. They're here to save space
        SOUL, TBAL, BLS2, TOW2, LQU1, LQU2, CEL1, CEL2, CEL3, CEL4, CEL5, CEL6,
        // BASEMENT ROOM ID'S ------------------------------------------------- 
        CAS1, CRY2, VAU1, CIS2, CIS1, SEW5, PRIS, TORC, CRY1, VAU2, CIS4, AARC, 
        SEW4, SEW3, SEW2, SEW1, VAUE, CIS3, OUB1, INTR, SEWP, DKCH, SEW0, ESC1, 
        ESC2, ESC3, ESC4, ESC5, ESC6, CIS5,
        // CATACOMBS ROOM ID'S ------------------------------------------------ 
        CS35, OU62, CT11, CT12, CT13, CT14, CT15, TM16, CT17, MY18, CT21, CT22, 
        CT23, CT24, CT25, CT26, CT27, CT28, CT31, TM32, CT33, CT34, CT36, CT37, 
        CT38, CT41, CT42, CT43, CT44, CT45, CT46, CT47, CT48, CT51, CT52, CT53, 
        CT54, AN55, CT56, CT57, CT58, CT61, CT63, CT64, AN65, TM66, CT67, CT68, 
        // CAVES ROOM ID'S ---------------------------------------------------- 
        CV11, CV12, CV13, CV14, CV15, CV16, CV17, CV18, CV21, CV22, CV23, CV24, 
        CV25, CV26, CV27, CV28, CV31, CV32, CV33, CV34, CV35, CV36, CV37, CV38, 
        CV41, CV42, CV43, CV44, CV45, CV46, CV47, CV48, CV51, CV52, CV53, CV54, 
        CV55, CV56, CV57, CV58, CV61, CV62, CV63, CV64, MS65, MS66, CV67, CV68 
    }; 
//****************************************************************************** 
// </editor-fold>
//****************************************************************************** 
    
    
//****************************************************************************** 
// <editor-fold defaultstate="collapsed" desc="ADJACENTS"> 
//****************************************************************************** 
    private static final String[][] ADJS = { 
        {}, {}, {},
        // FLOOR 1 ROOM ADJS -------------------------------------------------- 
        {COU2},                 {COU1,COU3},            {COU7,COU4,COU2,COU5}, 
        {COU3, ENDG},           {COU3,COU6,COU8},       {COU5}, 
        {FOY1,COU3},            {FOY1},                 {FOY2,VEST,COU7}, 
        {FOY1,FOYB,FOY3},       {ROTU},                 {FOYC,FOY2}, 
        {GAL1,FOYB},            {GAL2,FOYC},            {GAL1,LIB3,MHA1,GAL4}, 
        {LIB2},                 {LIB3},                 {LIB2,GAL2}, 
        {OBS1,BHA2},            {BHA1,BHA3},            {BHA2,PAR1}, 
        {BHA1,OBS2},            {},                     {PAR2}, 
        {ROTU},                 {FOYW,LOOK},            {MHA2,GAL2,CHS1}, 
        {MHA1},                 {SHA2},                 {SHA1,SQUA}, 
        {IHA2},                 {MHA1,MHA3,DIN1},       {DIN2,MHA2}, 
        {SHA1},                 {SHA2,WOW1},            {IHA1,WOW2}, 
        {KITC,EOW1,MHA2},       {MHA3},                 {WOW1}, 
        {WBAL,WOW2,SHA1},       {IHA2,WOW1,WOW3},       {CLOS}, 
        {EOW1,SEW0},            {EOW2,DST1,MHA3},       {EOW1,EOW4},
        {COU5},                 {FOR2},                 {FOR1, FOR3}, 
        {FOR2, FOR4},           {FOR3, FOR5},           {FOR4},
        // FLOOR 2 ROOM ADJS -------------------------------------------------- 
        {GAL4},                 {LIB5},                 {OBS1,OBS3}, 
        {JHA2,PAR2},            {PAR1,FOY3,JHA1},       {PAR2,FOY2,FOY4}, 
        {GAL4,GAL6},            {GAL3,GAL5,GAL2},       {LIB4}, 
        {SST2,JHA2},            {JHA1,GAR2},            {GAR2,GAR3}, 
        {JHA2,GAR1,GAR4},       {DIN1,DRAR},            {GAR1,GAR4}, 
        {GAR3,GAR2},            {DIN2},                 {CLOS,WOW2}, 
        {WOW3,COUS},            {EOW4},                 {WORK,EOW2}, 
        // FLOOR 3 ROOM ADJS -------------------------------------------------- 
        {OBS2},                 {LABO,ATT2},            {ATT1}, 
        {TOW1,FOY3},            {GAL3},                 {}, 
        {ATT2,SST1},            {ATT1,SST2},            {BLS2,TOW1}, 
        {FOY4,BLS1},            {CHA1},                 {CHA2,CHS3}, 
        {CHA1}, 
        // FLOOR 4 ROOM ADJS -------------------------------------------------- 
        {TBAL},                 {SOUL,TOW2},            {TOW2,BLS1}, 
        {TBAL,BLS2,LQU1},       {TOW2},                 {LQU1}, 
        {CEL2},                 {CEL1, CEL4},           {CEL4, CEL5},
        {CEL3, CEL2},           {CEL3},                 {},
        // BASEMENT ROOM ADJS ------------------------------------------------- 
        {CS35},                 {CRY1},                 {VAU2}, 
        {CIS3,CIS1},            {CIS2,SEW5},            {SEW4,CIS1,PRIS}, 
        {TORC,SEW3,SEW5},       {PRIS,CRY1},            {TORC,CRY2}, 
        {VAU1,VAUE},            {CIS3,OUB1},            {CIS3}, 
        {SEW5,SEW3},            {SEWP,SEW4,SEW2,PRIS},  {SEW3,SEW1}, 
        {SEW0,SEW2},            {VAU2},                 {AARC,CIS4,CIS2}, 
        {CIS4},                 {SEWP},                 {INTR,DKCH,SEW3}, 
        {SEWP},                 {SEW1,DST1},            {ESC2}, 
        {ESC1,ESC3},            {ESC2,ESC4},            {ESC3,ESC5}, 
        {ESC4,ESC6},            {ESC5},                 {},
        // SUB-LEVEL ROOM ADJS ------------------------------------------------ 
        {CAS1,CT34},            {CT52},                 {CT21,CT12}, 
        {CT11,CT13,CT22},       {CT12,CT14},            {CT13,CT15,CT24}, 
        {CT14},                 {CT26},                 {MY18,CT27}, 
        {CT17,CV18},            {CT11},                 {CT12,CT23}, 
        {CT22,CT33},            {CT14,CT25},            {CT24,CT26}, 
        {TM16,CT25},            {CT17,CT28},            {CT27,CT38}, 
        {TM32,CT41},            {CT31},                 {CT23,CT34,CT43}, 
        {CT33,CS35},            {CT37,CT46},            {CT36}, 
        {CT28,CT48},            {CT31,CT51},            {CT43,CT52}, 
        {CT33,CT42},            {CT45,CT54},            {CT44,CT46,AN55}, 
        {CT45,CT36,CT56},       {CT57},                 {CT38,CT58}, 
        {CT41,CT52,CT61},       {CT51,CT42,CT53,OU62},  {CT52,CT54}, 
        {CT44,CT53,CT64},       {CT45,AN65},            {CT46,CT57}, 
        {CT56,CT47,CT58},       {CT48,CT57,CT68},       {CT51}, 
        {CT64},                 {CT54,CT63},            {AN55}, 
        {CT67},                 {TM66,CT68},            {CT67,CT58}, 
        // CAVES ROOM ADJS ---------------------------------------------------- 
        {CV21},                 {CV13,CV22},            {CV12,CV14}, 
        {CV13,CV24},            {CV25,CV16},            {CV15,CV17}, 
        {CV16,CV27,CV18},       {CV17,MY18},            {CV11,CV31}, 
        {CV12,CV23},            {CV22},                 {CV14,CV34}, 
        {CV15,CV26},            {CV25},                 {CV17,CV37}, 
        {CV38},                 {CV21,CV32},            {CV31,CV33}, 
        {CV32,CV34},            {CV24,CV33,CV35,CV44},  {CV34,CV45}, 
        {CV46,CV37},            {CV27,CV36,CV38},       {CV37,CV28,CV48}, 
        {CV42},                 {CV41,CV43},            {CV42,CV53}, 
        {CV34,CV54},            {CV35,CV46},            {CV45,CV36}, 
        {CV57},                 {CV38,CV58},            {CV61,CV52}, 
        {CV51,CV53,CV62},       {CV52,CV54,CV43},       {CV53,CV55,CV44}, 
        {CV54},                 {CV57},                 {CV47,CV67,CV56,CV58}, 
        {CV48,CV68,CV57},       {CV51},                 {CV63,CV52}, 
        {CV62,CV64},            {CV63,MS65},            {CV64,MS66}, 
        {MS65},                 {CV57},                 {CV58} 
    }; 
//****************************************************************************** 
// </editor-fold>
//****************************************************************************** 
    
    
//****************************************************************************** 
// <editor-fold defaultstate="collapsed" desc="COORDINATES"> 
//****************************************************************************** 
    private static final int[][] COORDS = { 
        {-1,-1,-1}, {3, 7, 5}, {0, 1, 8},
    // 1ST FLOOR COORDINATES -------------------------------------------------- 
        {3,4,4}, {3,5,4}, {3,5,5}, {3,6,5}, {3,5,6}, {3,4,6}, {3,4,5}, {3,3,6}, 
        {3,3,5}, {3,2,5}, {3,3,4}, {3,1,5}, {3,1,6}, {3,2,6}, {3,2,7}, {3,1,7}, 
        {3,1,8}, {3,2,8}, {3,1,2}, {3,1,3}, {3,1,4}, {3,2,2}, {3,2,3}, {3,2,4}, 
        {3,3,2}, {3,3,3}, {3,3,7}, {3,3,8}, {3,4,1}, {3,4,2}, {3,4,3}, {3,4,7}, 
        {3,4,8}, {3,5,1}, {3,5,2}, {3,5,3}, {3,5,7}, {3,5,8}, {3,6,1}, {3,6,2}, 
        {3,6,3}, {3,6,4}, {3,6,6}, {3,6,7}, {3,6,8}, {2,5,6}, {1,4,1}, {1,5,1},
        {1,5,2}, {1,5,3}, {1,6,3},
    // 2ND FLOOR COORDINATES -------------------------------------------------- 
        {2,1,7}, {2,1,8}, {2,2,2}, {2,2,3}, {2,2,4}, {2,2,5}, {2,2,6}, {2,2,7}, 
        {2,2,8}, {2,3,2}, {2,3,3}, {2,4,2}, {2,4,3}, {2,4,8}, {2,5,2}, {2,5,3}, 
        {2,5,8}, {2,6,3}, {2,6,4}, {2,6,7}, {2,6,8}, 
    //3RD FLOOR COORDINATES --------------------------------------------------- 
        {1,2,2}, {1,2,3}, {1,2,4}, {1,2,5}, {1,2,6}, {1,2,7}, {1,3,2}, {1,3,3}, 
        {1,3,4}, {1,3,5}, {1,3,8}, {1,4,8}, {1,5,8}, 
    // 4TH FLOOR COORDINATES -------------------------------------------------- 
        {0,1,5}, {0,2,5}, {0,3,4}, {0,3,5}, {0,3,6}, {0,3,7}, {0,3,1}, {0,3,2},
        {0,2,1}, {0,2,2}, {0,1,1}, {0,1,3},
    // BASEMENT COORDINATES --------------------------------------------------- 
        {4,3,5}, {4,3,6}, {4,3,8}, {4,4,1}, {4,4,2}, {4,4,3}, {4,4,4}, {4,4,5}, 
        {4,4,6}, {4,4,8}, {4,6,1}, {4,5,2}, {4,5,3}, {4,5,4}, {4,5,5}, {4,5,6}, 
        {4,5,8}, {4,5,1}, {4,6,2}, {4,6,3}, {4,6,4}, {4,6,5}, {4,6,6}, {4,2,2}, 
        {4,2,1}, {4,1,1}, {4,1,2}, {4,1,3}, {4,2,3}, {4,1,8},
    // CATACOMBS COORDINATES -------------------------------------------------- 
        {5,3,5}, {5,6,2}, {5,1,1}, {5,1,2}, {5,1,3}, {5,1,4}, {5,1,5}, {5,1,6}, 
        {5,1,7}, {5,1,8}, {5,2,1}, {5,2,2}, {5,2,3}, {5,2,4}, {5,2,5}, {5,2,6}, 
        {5,2,7}, {5,2,8}, {5,3,1}, {5,3,2}, {5,3,3}, {5,3,4}, {5,3,6}, {5,3,7}, 
        {5,3,8}, {5,4,1}, {5,4,2}, {5,4,3}, {5,4,4}, {5,4,5}, {5,4,6}, {5,4,7}, 
        {5,4,8}, {5,5,1}, {5,5,2}, {5,5,3}, {5,5,4}, {5,5,5}, {5,5,6}, {5,5,7}, 
        {5,5,8}, {5,6,1}, {5,6,3}, {5,6,4}, {5,6,5}, {5,6,6}, {5,6,7}, {5,6,8}, 
    // CAVES ROOM ADJS -------------------------------------------------------- 
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

    /** 
     * Constructs the two hash maps. 
     */ 
    public static void constructRoomGraph() { 
        int index = 0; 
        
        for (String key : IDS) 
            ADJACENTS.put(key, ADJS[index++]);  

        assignCoordinates(); 
    } 
    //------------------------------------------------------------------------- 
    /** 
     * Used when a saved game is loaded.
     * Rooms already have there adjacency lists, so no need to assemble those.
     */ 
    public static void assignCoordinates() { 
        int index = 0; 
        
        for (String key : IDS)
            COORDINATES.put(key, COORDS[index++]); 
    } 
    //------------------------------------------------------------------------- 
    /** 
     * For any room, this returns which rooms are accessible from it. 
     * @param ID A room  
     * @return A list of rooms adjacent to the room. 
     */ 
    public static ArrayList<String> getAdj(String ID) { 
        ArrayList<String> result = new ArrayList(5);
        
        for (String s : ADJACENTS.get(ID))
            result.add(s);
        
        result.trimToSize();
        
        return result; 
    }
    //------------------------------------------------------------------------- 
    /** 
     * For any room, this returns its coordinates in the castle array. 
     * @param ID A room ID
     * @return The room's coordinates in the castle array.
     */ 
    public static int[] getCoords(String ID) { 
        return COORDINATES.get(ID); 
    } 
}