package A_Super;

/**
 * Similar to Moveable, but returns a different dialog.
 * @author Kevin Rapa
 */
public interface Unmoveable extends Moveable {
    final String[] MESSAGES = {
        "You are by all means a strongly-willed man, but you know your limits.",
        "It appears most unmoveable.", 
        "In an incredible feat, you trip over your own shoes.",
        "The stories of you moving that will surely echo through the fields of Elysium.",
        "You pull a nerve a short duration into the attempt.",
        "The player is thwarted in the ridiculous attempt."
    };
    
    // Randomely displays one of the messages.
    @Override default String moveIt() {
        int i = (int)Math.abs(System.currentTimeMillis()) % MESSAGES.length;
        return MESSAGES[i];
    }
}
