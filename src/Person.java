import javax.swing.*;

/**
 * Person abstract class Object
 */
public abstract class Person extends JComponent {
    private String name;
    private String designation;
    private int age;
    private long phone = -1;

    /** Person default constructor */
    Person()
    {}


    public Person(String name, int age, String designation, long phone)
    {
        this.name = name;
        this.age = age;
        this.designation = designation;

        if(Long.toString(phone).length() == 7 || Long.toString(phone).length() == 10)
            this.phone = phone;
    }

    /** returns the age of the person
     * @return age the age of the person
     */
    int getAge() {
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
    long getPhone() {
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

    String getDesignation()
    {
        return this.designation;
    }

    public void setDesignation(String designation)
    {
        this.designation = designation;
    }

    @Override
    public String toString()
    {
        return this.name;
    }
}
