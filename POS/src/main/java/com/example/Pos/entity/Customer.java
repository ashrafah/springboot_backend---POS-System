package com.example.Pos.entity;


import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Array;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.Set;

@Entity
@Table (name = "customer")
public class Customer {

    @Id
    @Column(name = "customer_id", length = 10)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name = "customer_name", length = 100, nullable = false)
    private String customerName;

    @Column(name = "customer_address", length = 200)
    private String customerAddress;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "contact_numbers", length = 10)
    private ArrayList contactnumber;

    @Column(name = "cusromer_salary")
    private double customersalary;

    @Column(name = "nic")
    private String nic;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean active;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;


    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerAddress, ArrayList contactnumber, double customersalary, String nic, boolean active) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.contactnumber = contactnumber;
        this.customersalary = customersalary;
        this.nic = nic;
        this.active = active;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public ArrayList getContactnumber() {
        return contactnumber;
    }

    public double getCustomersalary() {
        return customersalary;
    }

    public String getNic() {
        return nic;
    }

    public boolean isActive() {
        return active;
    }


    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setContactnumber(ArrayList contactnumber) {
        this.contactnumber = contactnumber;
    }

    public void setCustomersalary(double customersalary) {
        this.customersalary = customersalary;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", CustomerAddress='" + customerAddress + '\'' +
                ", contactnumber=" + contactnumber +
                ", customersalary=" + customersalary +
                ", nic='" + nic + '\'' +
                ", active=" + active +
                '}';
    }
}
