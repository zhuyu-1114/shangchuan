package com.yuntu.Car;

public class Test {
    public static void main(String[] args) {
        Car car = Factory.createCar("com.yuntu.Car.BYDhan");
        car.show();
        Car car1 = Factory.createCar("com.yuntu.Car.BYDtang");
        car1.show();
        Car car2 = Factory.createCar("com.yuntu.Car.BYDsong");
        car2.show();
        Car car3 = Factory.createCar("com.yuntu.Car.BYDqin");
        car3.show();
        Car car4 = Factory.createCar("com.yuntu.Car.BYDyuan");
        car4.show();

    }
}
