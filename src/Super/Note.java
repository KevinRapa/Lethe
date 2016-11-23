package Super;

public class Note extends Item {
    public Note(String name) {
        super(name);
        this.useID = 1;
    }
/*----------------------------------------------------------------------------*/
    @Override public String useEvent() {
        return this.description;
    }
/*----------------------------------------------------------------------------*/       
}
