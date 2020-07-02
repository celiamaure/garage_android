package fr.ipac.garage.manager;

import fr.ipac.garage.model.Car;

public class CarManager {
    private static final CarManager instance = new CarManager();
    private Car car;
    public static CarManager getInstance() {return  instance;}
    public Car getCar() {return car;}
    public void setCar(Car car) { this.car = car;}
}
