package A_Super;

/**
 * Color enum for the Gallery light machines and artifact.
 * @see Gallery.Gal_LightMachine
 * @see Secret_Archives.Lib1_Artifact
 * @author Kevin Rapa
 */
public enum MachineColor {
    RED         ("A red beam"), 
    BLUE        ("A blue beam"), 
    YELLOW      ("A yellow beam"), 
    GREEN       ("A green beam"), 
    ORANGE      ("An orange beam"), 
    PURPLE      ("A purple beam"),
    DARK_RED    ("A dark red beam"), 
    DARK_BLUE   ("A dark blue beam"), 
    DARK_YELLOW ("A dark yellow beam"), 
    DARK_GREEN  ("A dark green beam"),
    DARK_ORANGE ("A dark orange beam"), 
    DARK_PURPLE ("A dark purple beam"), 
    WHITE       ("A white beam"), 
    DARK        ("A dark beam"),
    CLEAR       ("A clear scattered light"),
    NONE        ("Barely any light");
    
    private final String DESC;
    
    MachineColor(String desc) {
        this.DESC = desc;
    }
    
    @Override public String toString() {
        return DESC;
    }
}
