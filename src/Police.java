/**
 * Police class
 * extension of Person
 * implementation of Employee
 */
public class Police extends Person implements Employee {
     enum Role
     {
         Patrol,
         Sargent,
         Captain,
         Chief;
     }

     private Role role;

     /** Police default constructor */
    Police()
    {
        super();
    }

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
