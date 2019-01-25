//package com.rental.carRental.domain;
//
//public class Van extends SmallCar {
//
//    double kmPrice;
//    double numberOfKm;
//
//
//    public Van(double baseDayRental, int numberOfDays, double kmPrice, double numberOfKm) {
//        super(baseDayRental, numberOfDays);
//        this.numberOfKm = numberOfKm;
//        this.kmPrice = kmPrice;
//    }
//
//
//    private double vanPrice(double baseDayRental, int numberOfDays, double kmPrice,double numberOfKm) {
//        double vanPrice = (baseDayRental * numberOfDays * 1.2 + (kmPrice*numberOfKm));
//        return vanPrice;
//    }
//
//
//    public double getNumberOfKm() {
//        return numberOfKm;
//    }
//
//    public void setNumberOfKm(double numberOfKm) {
//        this.numberOfKm = numberOfKm;
//    }
//
//    @Override
//    public String toString() {
//        return "Van{" +
//                "kmPrice=" + kmPrice +
//                ", numberOfKm=" + numberOfKm +
//                '}';
//    }
//}
