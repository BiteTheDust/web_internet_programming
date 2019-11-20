package midterm;

public class Tutor {

    Integer id;
    String firstName;
    String lastName;
    String email;
    String courses;

    public Tutor( Integer id, String firstName, String lastName, String email, String courses )
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.courses = courses;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public String getfirstName()
    {
        return firstName;
    }

    public void setfirstName( String name )
    {
        this.firstName = firstName;
    }
    public String getlastName()
    {
        return lastName;
    }

    public void setlastName( String name )
    {
        this.lastName = lastName;
    }
    
    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }
    
    public String getCourses()
    {
        return courses;
    }

    public void setCourses( String courses )
    {
        this.courses = courses;
    }

}
