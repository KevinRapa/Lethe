package A_Super;
/**
 * Represents furniture on which the player may type a Get word to get an item
 * from it.
 * 
 * Furniture representing certain divisible, heavy, etc. objects implement
 * the default method.
 * 
 * @see Furniture#GETKEYS
 * @author Kevin Rapa
 */
public interface Gettable {
    default String getIt() {
        return "You cannot pick that up with your hands...";
    }
    //=========================================================================
    default String getIt(String dialog) {
        return dialog;
    }
    //=========================================================================
}
