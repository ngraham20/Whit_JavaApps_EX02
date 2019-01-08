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

    }

    /** returns the age of the person */
    public int getAge() {
        return age;
    }

    /** returns the name of the person */
    public String getName() {
        return name;
    }

    /** returns the phone number of the person */
    public int getPhone() {
        return phone;
    }

    /** sets the name of the person */
    public void setName(String name) {
        this.name = name;
    }

    /** sets the age of the person*/
    public void setAge(int age) {
        this.age = age;
    }

    /** sets the phone number of the person */
    public void setPhone(int phone) {
        this.phone = phone;
    }
}
