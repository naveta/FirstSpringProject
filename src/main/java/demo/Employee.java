package demo;

/**
 * Created by robotic4 on 6/10/15.
 */


import java.util.Date;
import java.io.Serializable;

public class Employee implements Serializable {

    private Date date;

    private String name;

    private int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
