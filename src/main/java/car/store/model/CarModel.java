package car.store.model;

import java.io.Serializable;

public class CarModel implements Serializable {
    private final static long serialVersionUID = 1L;
    long carId;
    String brand;
    int year;



    public CarModel(){}

    public CarModel(long carId, String brand, int year) {
        this.carId = carId;
        this.brand = brand;
        this.year = year;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
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
        return "CarModel{" +
                "carId=" + carId +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                '}';
    }
}
