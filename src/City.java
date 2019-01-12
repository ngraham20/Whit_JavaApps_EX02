import java.util.Vector;

/**
 *  City class contains information regarding the citizens of the city and all buildings held within
 */
public class City {
    private Vector<Person> citizens = new Vector<>();
    private Vector<Building> buildings = new Vector<>();
    private Vector<Building> schools = new Vector<>();

    private Vector<Person> schoolgoers = new Vector<>();
    private Vector<Person> cityHallPolice = new Vector<>();

    /**
     *  Default constructor for the city
     */
    City()
    {

    }

    /**
     *  Lists all buildings contained within the city
     */
    void listBuildings()
    {
        System.out.println("--- All Buildings in City ---");
        for(Building building : buildings)
        {
            System.out.println(building.getName());
        }
        System.out.println();
    }

    /**
     * Lists all citizens of the city
     */
    void listCitizens()
    {
        System.out.println("--- All Citizens in City ---");
        for(Person person : citizens)
        {
            System.out.println(person.getName());
        }
        System.out.println();
    }

    /**
     * Updates all occupancy numbers and registers which citizens are in city hall and schools
     */
    void updateOccupancy()
    {
        Vector<Person> tempSchoolgoers = new Vector<>();
        for(Building building : buildings)
        {
            if (building instanceof School)
            {
                tempSchoolgoers.addAll(building.getOccupants());
            }
            if (building instanceof CityHall)
            {
                cityHallPolice = building.getOccupants();
            }
        }
        schoolgoers = tempSchoolgoers;
    }

    /**
     * Updates the occupancy of the schools
     */
    void updateBuildings()
    {
        Vector<Building> temp = new Vector<>();
        for(Building building: buildings)
        {
            if(building instanceof School)
            {
                temp.add(building);
            }
        }
        buildings = temp;
    }

    /**
     * Lists all residents who are in school or who are teachers
     */
    void listSchoolgoers()
    {
        System.out.println("--- Listing Teachers and Students ---");
        for (Person person : schoolgoers)
        {
            System.out.println(person.getName());
        }
        System.out.println();
    }

    /**
     * Lists all police officers currently in the City Hall
     */
    void listOfficersInCH()
    {
        System.out.println("--- Listing Officers in City Hall ---");
        for(Person person : cityHallPolice)
        {
            System.out.println(person.getName());
        }
        System.out.println();
    }

    /**
     * Pays all employees of the city
     */
    void payAllEmployees()
    {
        for(Person person : citizens)
        {
            if(person instanceof Employee)
            {
                ((Employee) person).payEmployee();
            }
        }
    }

    /**
     * Returns all citizens
     * @return an Vector of citizens
     */
    public Vector<Person> getCitizens() {
        return citizens;
    }

    /**
     * Sets the citizens list to an Vector
     * @param citizens: the citizens of the city
     */
    public void setCitizens(Vector<Person> citizens) {
        this.citizens = citizens;
    }

    /**
     * Returns all buildings within the city as an Vector
     * @return an Vector containing the buildings in the city
     */
    public Vector<Building> getBuildings() {
        return buildings;
    }

    /**
     * sets the buildings contained in the city
     * @param buildings the Vector of buildings
     */
    public void setBuildings(Vector<Building> buildings) {
        this.buildings = buildings;
    }

    /**
     * Returns all buildings which are schools
     * @return an Vector of buildings
     */
    public Vector<Building> getSchools() {
        return schools;
    }

    /**
     * Sets all schools in the city
     * @param schools all the school in the city
     */
    public void setSchools(Vector<Building> schools) {
        this.schools = schools;
    }

    /**
     * Returns all citizens currently in a school building
     * @return an Vector of People
     */
    public Vector<Person> getSchoolgoers() {
        return schoolgoers;
    }

    /**
     * sets list of citizens from an outside Vector of people
     * @param schoolgoers all citizens in a school building
     */
    public void setSchoolgoers(Vector<Person> schoolgoers) {
        this.schoolgoers = schoolgoers;
    }

    /**
     * gets all police officers currently inside City Hall
     * @return all officers inside City Hall
     */
    public Vector<Person> getCityHallPolice() {
        return cityHallPolice;
    }

    /**
     * sets the List of officers inside City Hall from outside Vector of people
     * @param cityHallPolice a list of officers currently inside City Hall
     */
    public void setCityHallPolice(Vector<Person> cityHallPolice) {
        this.cityHallPolice = cityHallPolice;
    }
}
