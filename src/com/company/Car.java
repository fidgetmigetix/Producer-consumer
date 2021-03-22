package com.company;

public class Car {

    CarType carType;


    public Car( CarType c){

        carType=c;



    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carType=" + carType +
                '}';
    }
}
