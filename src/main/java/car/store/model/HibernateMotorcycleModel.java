package car.store.model;

import org.springframework.data.annotation.Id;
import javax.persistence.*;

@Entity
@Table(name= "motorcycles")
@NamedQuery(name = "HibernateMotorcycleModel.getAll", query = "SELECT c from HibernateMotorcycleModel c")
public class HibernateMotorcycleModel {
    @Id
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "moto_id")
    private int id;
    @Column(name = "moto_brand")
    private String brand;
    @Column(name = "moto_year")
    private int year;

    public HibernateMotorcycleModel() {
    }

    public HibernateMotorcycleModel(int id, String brand, int year) {
        this.id = id;
        this.brand = brand;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "HibernateMotorcycleModel{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                '}';
    }
}
