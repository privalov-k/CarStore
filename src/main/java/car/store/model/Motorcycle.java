package car.store.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "motorcycles")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Motorcycle implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column
    private String brand;

    @Column
    private int year;

    @ManyToOne
    private Person person;
}
