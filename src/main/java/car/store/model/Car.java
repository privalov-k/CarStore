package car.store.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Car implements Serializable {

    private final static long serialVersionUID = 1L;

    long id;

    String brand;

    int year;
}
