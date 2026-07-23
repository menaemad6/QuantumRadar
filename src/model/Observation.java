package model;

public class Observation {
    // Our data members
    private int plateNumber;
    private String date;
    private int speed;
    private CarType carType;
    private boolean seatBelt;

    // Constructor
    public Observation(int plateNumber, String date, int speed, CarType carType, boolean seatBelt) {
        this.plateNumber = plateNumber;
        this.date = date;
        this.speed = speed;
        this.carType = carType;
        this.seatBelt = seatBelt;
    }

    // Getters
    public int getPlateNumber() {
        return plateNumber;
    }

    public String getDate() {
        return date;
    }

    public int getSpeed() {
        return speed;
    }

    public CarType getCarType() {
        return carType;
    }

    public boolean isSeatBelt() {
        return seatBelt;
    }

}
