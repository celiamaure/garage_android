package fr.ipac.garage.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Car implements Parcelable {
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
    Boolean available;

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
            String type,
            Boolean available
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
        setAvailable(available);
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.brand);
        dest.writeString(this.color);
        dest.writeString(this.model);
        dest.writeString(this.cylinder);
        dest.writeString(this.fuel);
        dest.writeString(this.gearBox);
        dest.writeString(this.picture);
        dest.writeString(this.type);
        dest.writeString(this.state);
        dest.writeByte(this.available ? (byte) 1 : (byte) 0);
        dest.writeInt(this.doorNumber);
        dest.writeInt(this.mileage);
    }

    protected Car(Parcel in) {
        this.brand = in.readString();
        this.color = in.readString();
        this.model = in.readString();
        this.cylinder = in.readString();
        this.fuel = in.readString();
        this.gearBox = in.readString();
        this.picture = in.readString();
        this.type = in.readString();
        this.state = in.readString();
        this.available = in.readByte() != 0;
        this.doorNumber = in.readInt();
        this.mileage = in.readInt();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel source) {
            return new Car(source);
        }
        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };
}
