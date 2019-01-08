/**
 * Teacher class object
 * extension of Person object
 * implementation of Employee interface
 */
public class Teacher extends Person implements Employee {

    private int grade;
    private String certif;

    /** Teacher default constructor */
    Teacher()
    {
        super();
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

    /** return the grade level that the teacher teaches */
    public int getGrade() {
        return grade;
    }

    /** return the teacher's certification */
    public String getCertif() {
        return certif;
    }
}
