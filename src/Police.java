/**
 * Police class
 * extension of Person
 * implementation of Employee
 */
public class Police extends Person implements Employee {

    /**
     * Consructor of Police officer, with automatic "Police Officer" designation
     * @param name name of the officer
     * @param age age of the officer
     * @param role role of the officer
     * @param phone phone number of the officer
     */
    public Police(String name, int age, Role role, long phone)
    {
        super(name, age, "Police Officer", phone);
        this.role = role;
    }

    enum Role
     {
         Patrol,
         Sargent,
         Captain,
         Chief;
     }

     private Role role;


    /**
     * Pay employee
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

    /** return the role of the police officer
     * @return role
     */
    public Role getRole() {
        return role;
    }

    /** set the role of the police officer
     * @param role the role of the officer
     */
    public void setRole(Role role) {
        this.role = role;
    }
}
