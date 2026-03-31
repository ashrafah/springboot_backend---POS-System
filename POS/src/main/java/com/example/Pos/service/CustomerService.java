package com.example.Pos.service;

import com.example.Pos.dto.CustomerDTO;
import com.example.Pos.dto.request.customerUpdateDTO;

import java.util.List;

public interface CustomerService {
    public String savecustomer(CustomerDTO customerDTO);

    String updateCustomer(customerUpdateDTO customerupdateDTO);

    CustomerDTO getCustomerById(int custemerId);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int custemerId);

    List<CustomerDTO> getAllCustomersByActiveState(Boolean activeState);
}
