package junit.test.student.models;


import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class School {
    public School(int id, String name, String principle, String address) {
        this.id = id;
        this.name = name;
        this.principle = principle;
        this.address = address;
    }

    @Id
    private int id;

    private String name;

    private String principle;

    private String address;

    public School() {
        super();
        // TODO Auto-generated constructor stub
    }

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

    public String getPrinciple() {
        return principle;
    }

    public void setPrinciple(String principle) {
        this.principle = principle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
