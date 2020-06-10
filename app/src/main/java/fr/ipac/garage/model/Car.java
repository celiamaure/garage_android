package fr.ipac.garage.model;

public class Car {
    String picture;
    String brand;
    String model;
    String cylinder;
    Integer mileage;
    String color;
    Integer doorNumber;
    String fuel;
    String gearBox;
    String state;
    String type;

    public Car(
            String picture,
            String brand,
            String model,
            String cylinder,
            Integer mileage,
            String color,
            Integer doorNumber,
            String fuel,
            String gearBox,
            String state,
            String type
    ) {
        setPicture(picture);
        setBrand(brand);
        setModel(model);
        setCylinder(cylinder);
        setMileage(mileage);
        setColor(color);
        setDoorNumber(doorNumber);
        setFuel(fuel);
        setGearBox(gearBox);
        setState(state);
        setType(type);
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCylinder() {
        return cylinder;
    }

    public void setCylinder(String cylinder) {
        this.cylinder = cylinder;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(Integer doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getGearBox() {
        return gearBox;
    }

    public void setGearBox(String gearBox) {
        this.gearBox = gearBox;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
