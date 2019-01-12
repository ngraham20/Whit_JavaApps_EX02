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

    CityController()
    {

    }

    CityController(WindowView context)
    {
        this.windowView = context;
        city = new City();
    }

    void createCity()
    {
        city = new City();
    }

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

    void birthPerson()
    {
        Vector<Person> citizens = city.getCitizens();

        // code could go here to factory create a random type of person
        citizens.add(new GenericPerson());
    }

    void killPerson(Person person)
    {
        Vector<Person> citizens = city.getCitizens();
        int index = citizens.indexOf(person);
        if (index != -1)
        {
            citizens.remove(person);
        }
    }

    public void setCitizens(Vector<Person> citizens)
    {
        this.city.setCitizens(citizens);
    }

    public void setBuildings(Vector<Building> buildings)
    {
        this.city.setBuildings(buildings);
    }

    public City getCity() {
        return city;
    }
}
