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

    Kid(String name, int age)
    {
        super(name, age, -1);
    }

    /** returns the Kid's favorite candy
     * @return favCandy the favorite candy of the kid
     */
    public String getFavCandy() {
        return favCandy;
    }

    /** sets the Kid's favorite candy
     * @param favCandy the kid's favorite candy
     */
    public void setFavCandy(String favCandy) {
        this.favCandy = favCandy;
    }
}
