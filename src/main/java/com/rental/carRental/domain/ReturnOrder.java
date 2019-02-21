package com.rental.carRental.domain;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class ReturnOrder {


    @Id
    private String id;




    private String compareId;
    private String dateReturn;
    private int kmCountAfter;



    public ReturnOrder(String compareId, String dateReturn, int kmCountAfter) {
        this.compareId = compareId;
        this.dateReturn = dateReturn;
        this.kmCountAfter = kmCountAfter;
    }

    public String getCompareId() {
        return compareId;
    }

    public void setCompareId(String compareId) {
        this.compareId = compareId;
    }

    public String getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(String dateReturn) {
        this.dateReturn = dateReturn;
    }

    public int getKmCountAfter() {
        return kmCountAfter;
    }

    public void setKmCountAfter(int kmCountAfter) {
        this.kmCountAfter = kmCountAfter;
    }

    @Override
    public String toString() {
        return "ReturnOrder{" +
                "compareId='" + compareId + '\'' +
                ", dateReturn='" + dateReturn + '\'' +
                ", kmCountAfter=" + kmCountAfter +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
