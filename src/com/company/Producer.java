package com.company;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Producer implements Runnable{

    String name;
    LinkedList<Car> cars;
    private ReentrantLock bufferLock;

    public Producer(String n, LinkedList<Car> arr,ReentrantLock buffer){
        name=n;
        cars= arr;
        bufferLock=buffer;
        System.out.println("Created Producer class of name: " + name);
    }

    public void createCar(){
        CarType.BMW[] val= CarType.BMW.values();
        int length = val.length;
        int randIndex = new Random().nextInt(length);
        CarType.BMW sam=val[randIndex];
        Car car= new Car(sam);

        cars.add(car);
        System.out.println("Procuder named: " + name + " created car: " + car.getCarType());

    }

    public void run(){
        Random random=new Random();
        try{
            while(!Thread.interrupted()){
                bufferLock.lock();
                createCar();
                bufferLock.unlock();
                Thread.sleep(random.nextInt(1000));
            }

        } catch (InterruptedException e){
            System.out.println(this + " interupted");
        }

        System.out.println("end of producing for " + this);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "name='" + name + '\'' +
                '}';
    }
}
