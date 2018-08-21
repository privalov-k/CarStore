package car.store.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private int id;
    @Column(name = "person_fullName")
    private String fullName;

    @OneToMany
    private List<HibernateMotorcycleModel> motorcycles = new ArrayList<>();


    public Person() {
    }

    public Person(String fullName, int id) {
        this.fullName = fullName;
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<HibernateMotorcycleModel> getMotorcycles() {
        return motorcycles;
    }

    public void setMotorcycles(List<HibernateMotorcycleModel> motorcycles) {
        this.motorcycles = motorcycles;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", id=" + id +
                '}';
    }
}
