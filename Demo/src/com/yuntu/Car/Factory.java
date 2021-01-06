package com.yuntu.Car;

public class Factory {
    public static Car createCar(String classCar){
        Car car =null;
        try {
            car = (Car) Class.forName(classCar).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return car;
    }
}
