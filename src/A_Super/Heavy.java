package A_Super;

/**
 * Functions similarly to Moveable, however this returns a different dialog.
 * @author Kevin Rapa
 */
public interface Heavy extends Moveable {
    @Override default String moveIt() {
        return "You are by all means a strongly-willed man, but you know your limits.";
    }
}
