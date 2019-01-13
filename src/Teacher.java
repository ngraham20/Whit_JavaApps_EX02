/**
 * Teacher class object
 * extension of Person object
 * implementation of Employee interface
 */
public class Teacher extends Person implements Employee {

    private int grade;
    private String certif;

    /**
     * Constructor for the teacher -- automatically designates this person as "Teaher"
     * @param name the name of the teacher
     * @param age the age of the teacher
     * @param phone the phone number of the teacher
     */
    Teacher(String name, int age, long phone)
    {
        super(name, age, "Teacher", phone);
    }

    /**
     * pay Employee
     * @see Employee
     */
    @Override
    public void payEmployee() {

    }

    /**
     * get id number of employee
     * @return int id number
     * @see Employee
     */
    @Override
    public int getId() {
        return 0;
    }

    /** return the grade level that the teacher teaches
     * @return grade
     */
    public int getGrade() {
        return grade;
    }

    /** return the teacher's certification
     * @return cerfif
     */
    public String getCertif() {
        return certif;
    }
}
