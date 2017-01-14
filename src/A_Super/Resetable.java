package A_Super;
/**
 * Represents furniture that is reset if the player is caught by the monster.
 * @author Kevin Rapa
 */
public interface Resetable {
    /**
     * Reset involves replacing taken items and un-solving puzzles.
     */
    public void reset();
}
