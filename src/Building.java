import java.util.ArrayList;

/**
 * Building Object
 *
 *
 */
public class Building {

    private String name;
    private String address;
    private ArrayList<Person> occupants;

    /** Default constructor */
    Building()
    {

    }

    /** Returns the name of the building
     * @return The name of the building
     */
    public String getName() {
        return name;
    }

    /** Returns the address of the building
     * @return The address of the building
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns the occupants of the building
     * @return An ArrayList containing the occupants of the building
     */
    public ArrayList<Person> getOccupants() {
        return occupants;
    }

    /** adds an occupant to a building */
    //PT -- have this return a boolean, in case add (or remove) fails.
    void addOccopant(Person occupant)
    {
        //PT -- maybe add occupant to occupants? -2
    }

    /**
     * Removes a specific occupant from the building
     * @param occupant An occupant to remove from the building
     */
    void removeOccupant(Person occupant)
    {

    }
}
