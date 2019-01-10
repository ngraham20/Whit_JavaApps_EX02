/**
 * Project: EX02
 * Package: PACKAGE_NAME
 */

import java.util.ArrayList;

/**
 * WindowController Object
 * @author Nathaniel Graham
 * @version 1.0
 */
public class WindowController {

    private City city = new City();

    WindowController()
    {

    }

    void addPersonToBuilding(Building building, Person person)
    {
        ArrayList<Building> buildings = city.getBuildings();
        int index = buildings.indexOf(building);
        if (index != 1)
        {
            building.getOccupants().add(person);
        }
        else return;
    }

    void removePersonFromBuilding(Building building, Person person)
    {
        ArrayList<Building> buildings = city.getBuildings();
        ArrayList<Person> persons;
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
        ArrayList<Person> citizens = city.getCitizens();

        // code could go here to factory create a random type of person
        citizens.add(new GenericPerson());
    }

    void killPerson(Person person)
    {
        ArrayList<Person> citizens = city.getCitizens();
        int index = citizens.indexOf(person);
        if (index != -1)
        {
            citizens.remove(person);
        }
    }


}
