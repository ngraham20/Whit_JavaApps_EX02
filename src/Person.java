/**
 * Person abstract class Object
 */
public abstract class Person {
    private String name;
    private int age;
    private int phone;

    /** Person default constructor */
    Person()
    {
        //PT -- default for age, phone? -2
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
        //PT -- make sure you get a valid age, phone. -2
        this.age = age;
    }

    /**
     * sets the phone number of the person
     * @param phone phone number of the person
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }
}
