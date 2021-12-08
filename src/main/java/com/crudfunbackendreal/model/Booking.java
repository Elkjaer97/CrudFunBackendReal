package com.crudfunbackendreal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int bookId;

    private int basin;
    private int bane;

    public Booking() {
    }

    public Booking(int basin, int bane) {
        this.basin = basin;
        this.bane = bane;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBasin() {
        return basin;
    }

    public void setBasin(int basin) {
        this.basin = basin;
    }

    public int getBane() {
        return bane;
    }

    public void setBane(int bane) {
        this.bane = bane;
    }
}
