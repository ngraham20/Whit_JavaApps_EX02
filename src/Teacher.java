public class Teacher extends Person implements Employee {

    private int grade;
    private String certif;

    Teacher()
    {
        super();
    }

    @Override
    public void payEmployee() {

    }

    @Override
    public int getId() {
        return 0;
    }

    public int getGrade() {
        return grade;
    }

    public String getCertif() {
        return certif;
    }
}
