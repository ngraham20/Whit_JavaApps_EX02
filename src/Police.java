public class Police extends Person implements Employee {
     enum Role
     {
         Patrol,
         Sargent,
         Captain,
         Chief;
     }

     private Role role;

    Police()
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
