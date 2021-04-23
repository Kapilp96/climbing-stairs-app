package com.climbingstairs.models;


import javax.persistence.*;

@Entity
@Table(name = "StridesRecord")
public class StridesRecord {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name = "result_status")
    private String result_status;

    @Column(name = "flights")
    private String total_flights;


    @Column(name = "stepsPerStride")
    private int stepsPerStride;

    @Column(name = "stridesRequired")
    private int stridesRequired;


    public StridesRecord() {

    }
    public StridesRecord(String result_status, String total_flights, int stepsPerStride, int stridesRequired) {
        this.result_status = result_status;
        this.total_flights = total_flights;
        this.stepsPerStride = stepsPerStride;
        this.stridesRequired = stridesRequired;
    }


    public String getTotal_flights() {
        return total_flights;
    }

    public void setTotal_flights(String total_flights) {
        this.total_flights = total_flights;
    }

    public String  getResult_status() {
        return result_status;
    }

    public void setResult_status(String result_status) {
        this.result_status = result_status;
    }

    public int getStepsPerStride() {
        return stepsPerStride;
    }

    public void setStepsPerStride(int stepsPerStride) {
        this.stepsPerStride = stepsPerStride;
    }

    public int getStridesRequired() {
        return stridesRequired;
    }

    public void setStridesRequired(int stridesRequired) {
        this.stridesRequired = stridesRequired;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StridesRecord{" +
                "id=" + id +
                ", result_status='" + result_status + '\'' +
                ", total_flights='" + total_flights + '\'' +
                ", stepsPerStride=" + stepsPerStride +
                ", stridesRequired=" + stridesRequired +
                '}';
    }
}


