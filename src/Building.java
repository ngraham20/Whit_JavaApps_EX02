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

    /** returns the name of the building */
    public String getName() {
        return name;
    }

    /** returns the address of the building */
    public String getAddress() {
        return address;
    }

    /** returns the occupants of the building */
    public ArrayList<Person> getOccupants() {
        return occupants;
    }

    /** adds an occupant to a building */
    void addOccopant(Person occupant)
    {

    }

    /**
     * removes a specific occupant from the building
     * @param occupant the occupant to remove
     */
    void removeOccupant(Person occupant)
    {

    }
}
