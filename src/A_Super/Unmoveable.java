package A_Super;

/**
 * Similar to Moveable, but returns a different dialog.
 * @author Mantis Toboggan
 */
public interface Unmoveable extends Moveable {
    @Override default String moveIt() {
        return "It's mounted to the room. There's no way you'll be moving that anywhere.";
    }
}
