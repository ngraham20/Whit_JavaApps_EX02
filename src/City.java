import java.util.ArrayList;

/**
 *  City class contains information regarding the citizens of the city and all buildings held within
 */
public class City {
    private ArrayList<Person> citizens;
    private ArrayList<Building> buildings;
    private ArrayList<Building> schools;

    private ArrayList<Person> schoolgoers;
    private ArrayList<Person> cityHallPolice;

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
        ArrayList<Person> tempSchoolgoers = new ArrayList<>();
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
        ArrayList<Building> temp = new ArrayList<>();
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
     * @return an ArrayList of citizens
     */
    public ArrayList<Person> getCitizens() {
        return citizens;
    }

    /**
     * Sets the citizens list to an ArrayList
     * @param citizens: the citizens of the city
     */
    public void setCitizens(ArrayList<Person> citizens) {
        this.citizens = citizens;
    }

    /**
     * Returns all buildings within the city as an ArrayList
     * @return an ArrayList containing the buildings in the city
     */
    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    /**
     * sets the buildings contained in the city
     * @param buildings the ArrayList of buildings
     */
    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }

    /**
     * Returns all buildings which are schools
     * @return an ArrayList of buildings
     */
    public ArrayList<Building> getSchools() {
        return schools;
    }

    /**
     * Sets all schools in the city
     * @param schools all the school in the city
     */
    public void setSchools(ArrayList<Building> schools) {
        this.schools = schools;
    }

    /**
     * Returns all citizens currently in a school building
     * @return an ArrayList of People
     */
    public ArrayList<Person> getSchoolgoers() {
        return schoolgoers;
    }

    /**
     * sets list of citizens from an outside ArrayList of people
     * @param schoolgoers all citizens in a school building
     */
    public void setSchoolgoers(ArrayList<Person> schoolgoers) {
        this.schoolgoers = schoolgoers;
    }

    /**
     * gets all police officers currently inside City Hall
     * @return all officers inside City Hall
     */
    public ArrayList<Person> getCityHallPolice() {
        return cityHallPolice;
    }

    /**
     * sets the List of officers inside City Hall from outside ArrayList of people
     * @param cityHallPolice a list of officers currently inside City Hall
     */
    public void setCityHallPolice(ArrayList<Person> cityHallPolice) {
        this.cityHallPolice = cityHallPolice;
    }
}
