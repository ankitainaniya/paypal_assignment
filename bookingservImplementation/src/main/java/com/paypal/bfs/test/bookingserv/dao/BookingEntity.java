package com.paypal.bfs.test.bookingserv.dao;

import com.paypal.bfs.test.bookingserv.api.model.Booking;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="booking")
public class BookingEntity implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;


    @Column(name = "hash")
    private Integer hash;

    public Integer getHash() {
        return hash;
    }

    public void setHash(Integer hash) {
        this.hash = hash;
    }

    @Column(name = "first_name")
    private String first_name;


    @Column(name = "last_name")
    private String last_name;

    @Column(name = "dob")
    private Date dob;


    @Column(name = "check_in_time")
    private Date checkinDatetime;

    @Column(name = "check_out_time")
    private Date checkoutDatetime;


    @Column(name = "total_price")
    private Double totalprice;

    @Column(name = "deposit")
    private Double deposit;

    @Column(name = "addr_line_1")
    private String addrLine1;

    @Column(name = "addr_line_2")
    private String addrLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getCheckinDatetime() {
        return checkinDatetime;
    }

    public void setCheckinDatetime(Date checkinDatetime) {
        this.checkinDatetime = checkinDatetime;
    }

    public Date getCheckoutDatetime() {
        return checkoutDatetime;
    }

    public void setCheckoutDatetime(Date checkoutDatetime) {
        this.checkoutDatetime = checkoutDatetime;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public String getAddrLine1() {
        return addrLine1;
    }

    public void setAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
    }

    public String getAddrLine2() {
        return addrLine2;
    }

    public void setAddrLine2(String addrLine2) {
        this.addrLine2 = addrLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
