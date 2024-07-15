package Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "car")
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "car_brand")
    private String carBrand;


    @Column(name = "car_model")
    private String carModel;

    @Column(name = "first_registration_date")
    private LocalDate firstRegisteryDate;

    @Column(name = "car_type")
    private CarType carType;

    @Column(name = "car_price")
    private double carPrice;


    public Car() {
    }

    public Car(String carBrand, String carModel, LocalDate firstRegisteryDate, CarType carType, double carPrice) {
        super();
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.firstRegisteryDate = firstRegisteryDate;
        this.carType = carType;
        this.carPrice = carPrice;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carBrand='" + carBrand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", firstRegisteryDate=" + firstRegisteryDate +
                ", carType=" + carType +
                ", carPrice=" + carPrice +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public LocalDate getFirstRegisteryDate() {
        return firstRegisteryDate;
    }

    public void setFirstRegisteryDate(LocalDate firstRegisteryDate) {
        this.firstRegisteryDate = firstRegisteryDate;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }


}
