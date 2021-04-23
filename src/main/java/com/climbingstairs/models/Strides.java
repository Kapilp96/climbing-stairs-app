package com.climbingstairs.models;

public class Strides {

    private String result_status;

    private int result_data;


    public Strides(String result_status, int result_data){
        this.result_status= result_status;
        this.result_data=result_data;
    }

    public String getResult_status() {
        return result_status;
    }

    public void setResult_status(String result_status) {
        this.result_status = result_status;
    }

    public int getResult_data() {
        return result_data;
    }

    public void setResult_data(int result_data) {
        this.result_data = result_data;
    }
}
