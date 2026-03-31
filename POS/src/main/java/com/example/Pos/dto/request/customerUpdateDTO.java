package com.example.Pos.dto.request;

import java.util.ArrayList;

public class customerUpdateDTO {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private double customersalary;

    public customerUpdateDTO() {
    }

    public customerUpdateDTO(int customerId, String customerName, String customerAddress, double customersalary) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customersalary = customersalary;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getCustomersalary() {
        return customersalary;
    }

    public void setCustomersalary(double customersalary) {
        this.customersalary = customersalary;
    }

    @Override
    public String toString() {
        return "customerUpdateDTO{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customersalary=" + customersalary +
                '}';
    }
}
