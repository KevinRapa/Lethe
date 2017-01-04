package A_Super;

public class Static_Wndw extends Furniture {
/* CONSTRUCTOR ---------------------------------------------------------------*/    
    public Static_Wndw() {
        super();
        this.searchable = false;
        this.actDialog = "This is a plain window. It has no moving parts.";
        this.addActKeys("open", "close");
        this.addNameKeys("window", "barred window");
    }
/*----------------------------------------------------------------------------*/
}

