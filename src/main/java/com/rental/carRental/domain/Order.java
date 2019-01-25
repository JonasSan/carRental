package com.rental.carRental.domain;
//
//import jdk.vm.ci.meta.Local;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

//
//@RequiredArgsConstructor
//
//@Getter
//@Setter
//@Document(collection="orders")
public class Order {

    @Id
    private String id;   //primary key

    @NonNull
    @Size(min = 5, max = 10)
    private int customerNumber;
    //foreign key
    private String carType;

    @NonNull
    @Size(min = 6, max = 6)
    private String regNumber;

    //    @DateTimeFormat(pattern = "yyyy-MM-ddThh:mm")
    private String dateBooking;
    private String dateReturn;

    private LocalDate before;
    private LocalDate after;


    private long days;


    private int kmCountBefore;
    private int kmCountAfter;
    private int km;
    private int price;

    public Order(int customerNumber, String carType, String regNumber, String dateBooking, int kmCountBefore) {

        this.customerNumber = customerNumber;
        this.carType = carType;
        this.regNumber = regNumber;
        this.dateBooking = dateBooking;
        this.kmCountBefore = kmCountBefore;
    }

    public long getDays(String dateBooking, String dateReturn) {
        LocalDate before = LocalDate.parse(dateBooking);
        LocalDate after = LocalDate.parse(dateReturn);

        days = ChronoUnit.DAYS.between(before, after);
        return days;
    }

    public void setDays(long days) {
        this.days = days;
    }

//    public Order(String orderID, int dateReturn, int kmCountAfter) {
//        this.orderID = orderID;
//        this.dateReturn = dateReturn;
//        this.kmCountAfter = kmCountAfter;
//    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(String dateBooking) {
        this.dateBooking = dateBooking;
    }

    public String getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(String dateReturn) {
        this.dateReturn = dateReturn;
    }

    public LocalDate getBefore() {

        return before;
    }

    public void setBefore(LocalDate before) {
        this.before = before;
    }

    public LocalDate getAfter() {
        return after;
    }

    public void setAfter(LocalDate after) {
        this.after = after;
    }

    public int getKmCountBefore() {
        return kmCountBefore;
    }

    public void setKmCountBefore(int kmCountBefore) {
        this.kmCountBefore = kmCountBefore;
    }

    public int getKmCountAfter() {
        return kmCountAfter;
    }

    public void setKmCountAfter(int kmCountAfter) {
        this.kmCountAfter = kmCountAfter;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + id +
                ", customerNumber=" + customerNumber +
                ", carType='" + carType + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", dateBooking=" + dateBooking +
                ", kmCountBefore=" + kmCountBefore +
                '}';
    }
}
