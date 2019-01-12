import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.io.Serializable;

/**
 * Person abstract class Object
 */
public abstract class Person extends JComponent {
    private String name;
    private int age;
    private int phone;

    /** Person default constructor */
    Person()
    {

    }

    public Person(String name, int age, int phone)
    {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    /** returns the age of the person
     * @return age the age of the person
     */
    public int getAge() {
        return age;
    }

    /** returns the name of the person
     * @return name the name of the peson
     */
    public String getName() {
        return name;
    }

    /** returns the phone number of the person
     * @return phone
     */
    public int getPhone() {
        return phone;
    }

    /**
     * sets the name of the person
     * @param name name of the person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets the age of the person
     * @param age age of the person
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * sets the phone number of the person
     * @param phone phone number of the person
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString()
    {
        return this.name;
    }
}
