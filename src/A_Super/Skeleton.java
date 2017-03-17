package A_Super;

/**
 * @author Kevin Rapa
 */
public class Skeleton extends SearchableFurniture implements Moveable {
/*----------------------------------------------------------------------------*/
    public Skeleton (Item... items) {
        super(items);
        
        this.actDialog = "\"Hello? Are you okay? Do you know a way out?\" You repeatedly ask the skeleton.\n"
                       + "The skeleton lies silently, motionless, rudely ignoring your inquiry.";
        this.searchDialog = "You crouch down.";

        this.addNameKeys("skeleton|body");
        this.addActKeys("eat", "speak|talk|converse|chat|greet|listen");
    }
/*----------------------------------------------------------------------------*/
    @Override public String interact(String key) {
        if (key.equals("eat"))
            return "The thought of that makes you shutter...";
        else
            return this.actDialog;
    }
/*----------------------------------------------------------------------------*/
    @Override public String moveIt() {
        return "This skeleton is most likely dead at this point. May as well let it rest.";
    }
/*----------------------------------------------------------------------------*/  
}


