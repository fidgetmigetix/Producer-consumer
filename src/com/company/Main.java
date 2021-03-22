package com.company;

import javax.crypto.spec.PSource;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedList<Car> carLinkedList= new LinkedList<>();
        ReentrantLock lock= new ReentrantLock();
//        Car c1= new Car("c1",123,220);
//        Car c2= new Car("c2",123,220);
//        Car c3= new Car("c3",123,220);
//        Car c4= new Car("c4",123,220);
//        Car c5= new Car("c5",123,220);
//
//        carLinkedList.add(c1);
//        carLinkedList.add(c2);
//        carLinkedList.add(c3);
//        carLinkedList.add(c4);
//        carLinkedList.add(c5);
//
//        carLinkedList.stream().forEach(System.out::println);
//
//        for(

//        Consumer consumer1 = new Consumer("John",carLinkedList);
//        Consumer consumer2 = new Consumer("Jerehmy",carLinkedList);
//        Consumer consumer3 = new Consumer("Adam",carLinkedList);
//        Consumer consumer4 = new Consumer("Pablo",carLinkedList);
//        Consumer consumer5 = new Consumer("George",carLinkedList);
//
//        new Thread(consumer1).start();
//        new Thread(consumer2).start();
//        new Thread(consumer3).start();
//        new Thread(consumer4).start();
//        new Thread(consumer5).start();

        Consumer c1= new Consumer("John", carLinkedList, lock);
        Consumer c2= new Consumer("Adam", carLinkedList, lock);
        Consumer c3= new Consumer("George", carLinkedList, lock);
        Consumer c4= new Consumer("Max", carLinkedList, lock);

        Producer p1 = new Producer("PRoducer1", carLinkedList, lock);
        Producer p2 = new Producer("PRoducer2", carLinkedList, lock);
        Producer p3 = new Producer("PRoducer3", carLinkedList, lock);
        Producer p4 = new Producer("PRoducer4", carLinkedList, lock);

        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(c3).start();
        new Thread(c4).start();

        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(p3).start();
        new Thread(p4).start();



    }
}
