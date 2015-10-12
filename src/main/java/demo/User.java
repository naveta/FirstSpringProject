package demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by robotic4 on 6/10/15.
 */

@Entity
@Table(name = "users")
public class User implements Serializable {

    //private fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @NotNull
    private String email;

    @NotNull
    private String name;

    private long salary;


    // public methods

    public User() {
    }


   public User(long id)
   {
       this.id = id;
   }

    public User(String name, String email, long salary)
    {
        this.name = name;

        this.email = email;

        this.salary = salary;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setSalary(long salary)
    {
        this.salary = salary;
    }

    public long getSalary()
    {
        return salary;
    }


}
