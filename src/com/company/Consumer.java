package com.company;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;

public class Consumer implements Runnable {

    String name;
    LinkedList<Car> cars;
    private ReentrantLock bufferLock;

    public Consumer(String n, LinkedList<Car> c,ReentrantLock buffer){
        name=n;
        cars=c;
        bufferLock=buffer;
        System.out.println("Created Consumer named: " + name);
    }

    public void buyCar(){
        try{
            Car carToDel = cars.getFirst();
            cars.remove();
            System.out.println("Car named: " + carToDel.getCarType() + " bought by " + name+ " and driven away");
        } catch (NoSuchElementException e){
            System.out.println("There is no cars to get");
        }

    }

    public synchronized void run() {
        Random random = new Random();
        while (true) {
            try {
                bufferLock.lock();
                buyCar();
                bufferLock.unlock();
                Thread.sleep(random.nextInt(1000));

            } catch (InterruptedException e) {
                System.out.println("Consumer" + name + " waiting for car Interupted");
            }

            System.out.println("consumer " + name + " waiting");

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
