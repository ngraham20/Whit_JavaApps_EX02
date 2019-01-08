/**
 * Kid Object
 * This models a kid person
 */
public class Kid extends Person {
    private String favCandy;

    /** Default Kid constructor */
    Kid()
    {
        super();
    }

    /** returns the Kid's favorite candy */
    public String getFavCandy() {
        return favCandy;
    }

    /** sets the Kid's favorite candy */
    public void setFavCandy(String favCandy) {
        this.favCandy = favCandy;
    }
}
