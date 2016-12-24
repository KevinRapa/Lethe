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
 * @see Room_References#constructRoomReferences()
// ***************************************************************************/
public class Room_References {
    private static final HashMap<String, String[]> ADJACENTS = new HashMap<>();
    private static final HashMap<String, int[]> COORDINATES = new HashMap<>();

//******************************************************************************
// <editor-fold desc="ROOM IDS">  
// Each element maps to an element in ADJS for ADJACENTS.
// Each element maps to an element in COORDS for COORDINATES.
//******************************************************************************
    private static final String[] IDS = 
        {"NULL",
        // FLOOR 1 ROOM ID'S --------------------------------------------------
        "COU1","COU2","COU3","COU4","COU5","COU6","COU7","VEST","FOY1","FOY2",
        "FOYW","FOYB","FOYC","GAL1","GAL2","LIB1","LIB2","LIB3","BHA1","BHA2",
	"BHA3","OBS1","STUD","PAR1","LOOK","ROTU","MHA1","CHS1","SQUA","SHA2",
        "IHA1","MHA2","DIN1","SHAR","SHA1","IHA2","MHA3","KITC","WBAL","WOW1",
        "WOW2","COUS","DST1","EOW1","EOW2",
        // FLOOR 2 ROOM ID'S --------------------------------------------------
        "GAL5","LIB4","OBS2","JHA1","PAR2","FOY3","GAL3","GAL4","LIB5","SST1",
        "JHA2","CHS2","GAR1","GAR2","DIN2","GAR3","GAR4","DRAR","WOW3","GQUA",
        "WORK","EOW4",
        // FLOOR 3 ROOM ID'S --------------------------------------------------
        "OBS3","ATT1","LABO","FOY4","GAL6","GAL7","SST2","ATT2","BLS1","BAL1",
        "BAL2","CHS3","DUSC","CHA1","RANR","CHA2",
        // FLOOR 4 ROOM ID'S --------------------------------------------------
        "SOUL","TBAL","BLS2","THR1","LQUA","THR2",
        // BASEMENT ROOM ID'S -------------------------------------------------
        "VAU4","VAU3","VAU2","CAS1","CRY2","VAU1","SEW7","SEW6","SEW5","PRIS",
        "TORC","CRY1","VAUH","SEW8","AARC","SEW4","SEW3","SEW2","SEW1","VAUE",
        "SEW9","OUB1","INTR","STRP","ARCH","DST2",
        // CATACOMBS ROOM ID'S ------------------------------------------------
        "CAS2","OUB2","CAT1","CAT2","CAT3","CAT4","CAT5","CAT6","CAT7","MYST",
        "CAT9","CA10","CA11","CA12","CA13","CA14","CA15","CA16","CA17","CA18",
        "CA19","CA20","CA22","CA23","CA24","CA25","CA26","CA27","CA28","CA29",
        "CA30","CA31","CA32","CA33","CA34","CA35","CA36","ANT1","CA38","CA39",
        "CA40","CA41","CA43","CA44","ANT2","CA46","CA47","CA48",
        // CAVES ROOM ID'S ----------------------------------------------------
        "CV11","CV12","CV13","CV14","CV15","CV16","CV17","MYS2","CV21","CV22",
        "CV23","CV24","CV25","CV26","CV27","CV28","CV31","CV32","CV33","FOUN",
        "CV35","CV36","CV37","CV38","CV41","CV42","CV43","CV44","CV45","CV46",
        "CV47","CV48","CV51","CV52","CV53","CV54","CV55","CV56","CV57","CV58",
        "CV61","CV62","CV63","CV64","MAS1","MAS2","CV67","CV68"};
//******************************************************************************    
// </editor-fold>  
//******************************************************************************
    
    
//******************************************************************************
// <editor-fold desc="ADJACENTS">  
//******************************************************************************
    private static final String[][] ADJS = 
        {{"NULL"},        
        // FLOOR 1 ROOM ADJS --------------------------------------------------   
        {"COU2"}, {"COU1","COU3"}, {"COU7","COU4","COU2","COU5"}, {"COU3"},
        {"COU3","COU6"}, {"COU5"}, {"FOY1","COU3"}, {"FOY1"}, 
        {"FOY2","VEST","FOYW","COU7"}, {"FOY1","FOYB","FOY3"}, {"FOY1","ROTU"}, 
        {"FOYC","FOY2"}, {"GAL1","FOYB"}, {"GAL2","GAL3","FOYC"}, 
        {"GAL1","LIB3","MHA1"}, {"LIB2"}, {"LIB3"}, {"LIB2","LIB5","GAL2"}, 
        {"OBS1","BHA2"}, {"BHA1","BHA3"}, {"BHA2","PAR1"}, {"BHA1","OBS2"}, 
        {"ROTU"}, {"PAR2"}, {"ROTU"}, {"FOYW","LOOK"},       
        {"MHA2","GAL2","CHS1"}, {"CHS2","MHA1"}, {"SHA2"}, {"SHA1","SQUA"},
        {"IHA2","ROTU"}, {"MHA1","MHA3","DIN1"}, {"DIN2","MHA2"}, {"SHA1"},
        {"SHA2","WOW1"}, {"IHA1","WOW2"}, {"KITC","EOW1","MHA2"},
        {"MHA3"}, {"WOW1"}, {"WBAL","WOW2","SHA1"}, {"IHA2","WOW1"},
        {}, {"EOW1","DST2"}, {"EOW2","DST1","MHA3"}, {"EOW1"},
        // FLOOR 2 ROOM ADJS --------------------------------------------------
        {"GAL4"}, {"LIB5"}, {"OBS1","OBS3"}, {"JHA2","PAR2"},
        {"PAR1","FOY3","JHA1"}, {"PAR2","FOY2","FOY4"}, {"GAL4","GAL1"},
        {"GAL3","GAL5"}, {"LIB3","LIB4"}, {"SST2","JHA2"}, {"JHA1","GAR2"}, 
        {"CHS1","CHS3"}, {"GAR2","GAR3"}, {"JHA2","GAR1","GAR4"}, {"DIN1","DRAR"}, 
        {"GAR1","GAR4"}, {"GAR3","GAR2"}, {"DIN2"}, {"GQUA","WOW2"}, 
        {"WOW3","COUS"}, {"EOW4"}, {"WORK","EOW2"},        
        // FLOOR 3 ROOM ADJS --------------------------------------------------
        {"OBS2"}, {"LABO","ATT2"}, {"ATT1"}, {"BAL1","FOY3"}, {"GAL3"},
        {}, {"ATT2","SST1"}, {"ATT1","SST2"}, {"BLS2","BAL1"},
        {"FOY4","BAL2","DUSC","BLS1"}, {"BAL1"}, {"CHS2","CHA1"},
        {"RANR","BAL1"}, {"CHA2","CHS3"}, {"DUSC"}, {"CHA1"},
        // FLOOR 4 ROOM ADJS --------------------------------------------------
        {"TBAL"}, {"SOUL","THR1"}, {"THR1","BLS1"}, 
        {"THR2","TBAL","BLS2","LQUA"}, {"THR1"}, {"THR1"}, 
        // BASEMENT ROOM ADJS -------------------------------------------------
        {"VAU3"}, {"VAU4","VAU2"}, {"VAU3","VAU1"}, {"CAS2","CRY2"}, 
        {"CRY1","CAS1"}, {"VAU2","VAUH"}, {"SEW8","SEW6"}, {"SEW7","SEW5"}, 
        {"SEW4","SEW6"}, {"TORC"}, {"SEW2","PRIS","CRY1"}, {"TORC","CRY2"},
        {"VAU1","VAUE"}, {"SEW9","SEW7","AARC"}, {"SEW8"}, {"SEW5","SEW3"},
        {"STRP","SEW4","SEW2"}, {"TORC","SEW3","SEW1"}, {"DST2","SEW2"},
        {"VAUH"}, {"OUB1","SEW8"}, {"OUB2","SEW9"}, {"STRP"},
        {"INTR","ARCH","SEW3"}, {"STRP"}, {"SEW1","DST1"},
        // SUB-LEVEL ROOM ADJS ------------------------------------------------
        {"CAS1","CA20"}, {"OUB1","CA34"}, {"CAT9","CAT2"}, {"CAT1","CAT3","CA10"},
        {"CAT2","CAT4"}, {"CAT3","CAT5","CA12"}, {"CAT4"}, {"CA14"}, {"MYST","CA15"},
        {"CAT7"}, {"CAT1"}, {"CAT2","CA11"}, {"CA10","CA19"}, {"CAT4","CA13"},
        {"CA12","CA14"}, {"CAT6","CA13"}, {"CAT7","CA16"}, {"CA15","CA24"},
        {"CA18","CA25"}, {"CA17"}, {"CA11","CA20","CA27"}, {"CA19","CAS2"},
        {"CA23","CA30"}, {"CA22"}, {"CA16","CA32"}, {"CA17","CA33"},
        {"CA27","CA34"}, {"CA19","CA26"}, {"CA29","CA36"}, {"CA28","CA30","ANT1"},
        {"CA29","CA22","CA38"}, {"CA39"}, {"CA24","CA40"}, {"CA25","CA34","CA41"},
        {"CA33","CA26","CA35","OUB2"}, {"CA34","CA36"}, {"CA28","CA35","CA44"},
        {"CA29","ANT2"}, {"CA30","CA39"}, {"CA38","CA31","CA40"},
        {"CA32","CA39","CA48"}, {"CA33"}, {"CA44"}, {"CA36","CA43"},
        {"ANT1"}, {"CA47"}, {"CA46","CA48"}, {"CA47","CA40"},
        // CAVES ROOM ADJS ----------------------------------------------------
        {"CV21"}, {"CV13","CV22"}, {"CV12","CV14"}, {"CV13","CV24"}, {"CV25","CV16"}, 
	{"CV15","CV17"}, {"CV16","CV27","MYS2"}, {"CV17","MYS1"}, {"CV11","CV31"}, 
	{"CV12","CV23"}, {"CV22"}, {"CV14","FOUN"}, {"CV15","CV26"}, {"CV25"}, 
	{"CV17","CV37"}, {"CV38"}, {"CV21","CV32"}, {"CV31","CV33"}, {"CV32","FOUN"}, 
	{"CV24","CV33","CV35","CV44"}, {"FOUN","CV45"}, {"CV46","CV37"}, 
	{"CV27","CV36","CV38"}, {"CV37","CV28","CV48"}, {"CV42"}, {"CV41","CV43"}, 
	{"CV42","CV53"}, {"FOUN","CV54"}, {"CV35","CV46"}, {"CV45","CV36"}, {"CV57"}, 
	{"CV38","CV58"}, {"CV61","CV52"}, {"CV51","CV53","CV62"}, {"CV52","CV54","CV43"}, 
	{"CV53","CV55","CV44"}, {"CV54"}, {"CV57"}, {"CV47","CV67","CV56","CV58"}, 
	{"CV48","CV68","CV57"}, {"CV51"}, {"CV63","CV52"}, {"CV62","CV64"},
	{"CV63","MAS1"}, {"CV64","MAS2"}, {"MAS1"}, {"CV57"}, {"CV58"}};
//******************************************************************************    
// </editor-fold>  
//******************************************************************************    
    
    
//******************************************************************************
// <editor-fold desc="COORDINATES">  
//****************************************************************************** 
    private static final int[][] COORDS =   
       {{-1,-1,-1}, 
        // 1ST FLOOR COORDINATES ----------------------------------------------
        {3,4,4}, {3,5,4}, {3,5,5}, {3,6,5}, {3,5,6}, {3,4,6}, {3,4,5}, {3,3,6}, 
        {3,3,5}, {3,2,5}, {3,3,4}, {3,1,5}, {3,1,6}, {3,2,6}, {3,2,7}, {3,1,7}, 
        {3,1,8}, {3,2,8}, {3,1,2}, {3,1,3}, {3,1,4}, {3,2,2}, {3,2,3}, {3,2,4},
        {3,3,2}, {3,3,3}, {3,3,7}, {3,3,8}, {3,4,1}, {3,4,2}, {3,4,3}, {3,4,7}, 
        {3,4,8}, {3,5,1}, {3,5,2}, {3,5,3}, {3,5,7}, {3,5,8}, {3,6,1}, {3,6,2}, 
        {3,6,3}, {3,6,4}, {3,6,6}, {3,6,7}, {3,6,8},         
        // 2ND FLOOR COORDINATES ----------------------------------------------        
        {2,1,7}, {2,1,8}, {2,2,2}, {2,2,3}, {2,2,4}, {2,2,5}, {2,2,6}, {2,2,7}, 
        {2,2,8}, {2,3,2}, {2,3,3}, {2,3,8}, {2,4,2}, {2,4,3}, {2,4,8}, {2,5,2}, 
        {2,5,3}, {2,5,8}, {2,6,3}, {2,6,4}, {2,6,7}, {2,6,8},       
        //3RD FLOOR COORDINATES -----------------------------------------------        
        {1,2,2}, {1,2,3}, {1,2,4}, {1,2,5}, {1,2,6}, {1,2,7}, {1,3,2}, {1,3,3}, 
        {1,3,4}, {1,3,5}, {1,3,6}, {1,3,8}, {1,4,5}, {1,4,8}, {1,5,5}, {1,5,8},  
        // 4TH FLOOR COORDINATES ----------------------------------------------        
        {0,1,5}, {0,2,5}, {0,3,4}, {0,3,5}, {0,3,6}, {0,4,5},       
        // BASEMENT COORDINATES -----------------------------------------------    
        {4,1,7}, {4,1,8}, {4,2,8}, {4,3,5}, {4,3,6}, {4,3,8}, {4,4,1}, {4,4,2}, 
        {4,4,3}, {4,4,4}, {4,4,5}, {4,4,6}, {4,4,8}, {4,5,1}, {4,5,2}, {4,5,3}, 
        {4,5,4}, {4,5,5}, {4,5,6}, {4,5,8}, {4,6,1}, {4,6,2}, {4,6,3}, {4,6,4},
        {4,6,5}, {4,6,6},          
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
        {6,6,1}, {6,6,2}, {6,6,3}, {6,6,4}, {6,6,5}, {6,6,6}, {6,6,7}, {6,6,8}};
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
        return new ArrayList() {{
            addAll(Arrays.asList(ADJACENTS.get(ID)));
        }}; 
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
