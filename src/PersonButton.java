/**
 * Project: EX02
 * Package: PACKAGE_NAME
 */

import javax.swing.*;

/**
 * PersonButton Object
 * @author Nathaniel Graham
 * @version 1.0
 */
public class PersonButton extends JButton {

    private Person person;

    public Person getPerson()
    {
        return this.person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }

    // the action listener on this button should return the person for the controller to work with
}
