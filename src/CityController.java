/**
 * Project: EX02
 * Package: PACKAGE_NAME
 */

import java.awt.*;
import java.util.Vector;

/**
 * CityController Object
 * @author Nathaniel Graham
 * @version 1.0
 */
public class CityController {

    private City city;
    private WindowView windowView;

    /** Default Constructor */
    CityController()
    {

    }

    /** Constructor with WindowView context */
    CityController(WindowView context)
    {
        this.windowView = context;
        city = new City();
    }

    /** Create a new city */
    void createCity()
    {
        city = new City();
    }

    /**
     * Add a person to the specified building
     * @param building the building to add the person to
     * @param person the person to add to the building
     */
    public void addPersonToBuilding(Building building, Person person)
    {
        Vector<Building> buildings = city.getBuildings();
        int index = buildings.indexOf(building);
        if (index != 1)
        {
            building.getOccupants().add(person);
        }
        else return;
    }

    /**
     * Remove a person from the specified building
     * @param building the building to remove from
     * @param person the person to remove
     */
    void removePersonFromBuilding(Building building, Person person)
    {
        Vector<Building> buildings = city.getBuildings();
        Vector<Person> persons;
        int index = buildings.indexOf(building);
        if (index != -1)
        {
            persons = building.getOccupants();
        }
        else return;

        index = persons.indexOf(person);
        if (index != -1)
        {
            persons.remove(person);
        }
    }

    /**
     * Add a new person into the city
     * @deprecated this function is no longer used
     */
    void birthPerson()
    {
        Vector<Person> citizens = city.getCitizens();

        // code could go here to factory create a random type of person
        citizens.add(new GenericPerson());
    }

    /**
     * Remove a person from the city
     * @param person the person to remove
     * @deprecated this function is no longer used
     */
    void killPerson(Person person)
    {
        Vector<Person> citizens = city.getCitizens();
        int index = citizens.indexOf(person);
        if (index != -1)
        {
            citizens.remove(person);
        }
    }

    /**
     * set the citizen
     * @param citizens a vector of Person objects
     */
    public void setCitizens(Vector<Person> citizens)
    {
        this.city.setCitizens(citizens);
    }

    /**
     * set the city's buildings
     * @param buildings a vector of Building objects
     */
    public void setBuildings(Vector<Building> buildings)
    {
        this.city.setBuildings(buildings);
    }

    /**
     * Returns the city object
     * @return the city to return
     */
    public City getCity() {
        return city;
    }
}
