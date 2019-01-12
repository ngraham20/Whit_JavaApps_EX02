import java.util.Vector;

/**
 * Building Object
 *
 *
 */
public abstract class Building {

    private String name;
    private String address;
    private String designation;
    private Vector<Person> occupants = new Vector<>();

    /** Default constructor */
    Building(String name, String address, String designation)
    {
        this.name = name;
        this.address = address;
        this.designation = designation;
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
     * @return An Vector containing the occupants of the building
     */
    public Vector<Person> getOccupants() {
        return occupants;
    }

    public String getDesignation()
    {
        return this.designation;
    }

    /** adds an occupant to a building */
    void addOccupant(Person occupant)
    {

    }

    void addOccupants(Vector<Person> occupants)
    {
        this.occupants = occupants;
    }

    /**
     * Removes a specific occupant from the building
     * @param occupant An occupant to remove from the building
     */
    void removeOccupant(Person occupant)
    {

    }

    @Override
    public String toString() {
        return this.name;
    }
}
