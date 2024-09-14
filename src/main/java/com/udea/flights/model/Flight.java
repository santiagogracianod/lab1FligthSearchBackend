package com.udea.flights.model;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Flight implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String origin;
    private String destination;
    private LocalDate date;
    @Column(name = "econ_price")  // Mapeo al campo de la base de datos
    private double econPrice;
    @Column(name = "busi_price")  // Mapeo al campo de la base de datos
    private double busiPrice;
    private boolean scale;
    private String airline;
    @Column(name = "econ_avaib_seats")
    private int econAvaibSeats;
    @Column(name = "busi_avaib_seats")
    private int busiAvaibSeats;
    public Flight() {
    }

    public Flight(Long id, String origin, String destination, LocalDate date, double econ_price, double busi_price, boolean scale, String airline, int econ_avaib_seats, int busi_avaib_seats) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.econPrice = econ_price;
        this.busiPrice = busi_price;
        this.scale = scale;
        this.airline = airline;
        this.econAvaibSeats = econ_avaib_seats;
        this.busiAvaibSeats = busi_avaib_seats;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getEcon_price() {
        return econPrice;
    }

    public void setEcon_price(double econ_price) {
        this.econPrice = econ_price;
    }

    public double getBusi_price() {
        return busiPrice;
    }

    public void setBusi_price(double busi_price) {
        this.busiPrice = busi_price;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public boolean isScale() {
        return scale;
    }

    public void setScale(boolean scale) {
        this.scale = scale;
    }

    public int getEcon_avaib_seats() {
        return econAvaibSeats;
    }

    public void setEcon_avaib_seats(int econ_avaib_seats) {
        this.econAvaibSeats = econ_avaib_seats;
    }

    public int getBusi_avaib_seats() {
        return busiAvaibSeats;
    }

    public void setBusi_avaib_seats(int busi_avai_seats) {
        this.busiAvaibSeats = busi_avai_seats;
    }

    //IDIOMS

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight flight)) return false;
        return Objects.equals(getId(), flight.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
