package com.example.Pos.service.impl;

import com.example.Pos.dto.CustomerDTO;
import com.example.Pos.dto.request.customerUpdateDTO;
import com.example.Pos.entity.Customer;
import com.example.Pos.exception.NotFoundException;
import com.example.Pos.repo.CustomerRepo;
import com.example.Pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String savecustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getContactnumber(),
                customerDTO.getCustomersalary(),
                customerDTO.getNic(),
                customerDTO.isActive()
        );
        customerRepo.save(customer);
        return customerDTO.getCustomerName();
    }

    @Override
    public String updateCustomer(customerUpdateDTO customerupdateDTO) {

        if (customerRepo.existsById(customerupdateDTO.getCustomerId())) {

            Customer customer = customerRepo.getReferenceById(customerupdateDTO.getCustomerId());
            customer.setCustomerName(customerupdateDTO.getCustomerName());
            customer.setCustomerAddress(customerupdateDTO.getCustomerAddress());
            customer.setCustomersalary(customerupdateDTO.getCustomersalary());

            customerRepo.save(customer);
            return customerupdateDTO.getCustomerName() + "Updated Successfully";
        } else {
            throw new RuntimeException("Customer id Not Found");
        }


    }

    @Override
    public CustomerDTO getCustomerById(int custemerId) {
        if (customerRepo.existsById(custemerId)) {
            Customer customer = customerRepo.getReferenceById(custemerId);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactnumber(),
                    customer.getCustomersalary(),
                    customer.getNic(),
                    customer.isActive()
            );
            return customerDTO;
        } else {
            throw new RuntimeException("Customer id Not Found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {

        List<Customer> getAllCustomers = customerRepo.findAll();
        if (getAllCustomers.size()>0) {
            List<CustomerDTO> customerDTOList = new ArrayList<>();

            for (Customer customer : getAllCustomers) {
                CustomerDTO customerDTO = new CustomerDTO(
                        customer.getCustomerId(),
                        customer.getCustomerName(),
                        customer.getCustomerAddress(),
                        customer.getContactnumber(),
                        customer.getCustomersalary(),
                        customer.getNic(),
                        customer.isActive()
                );
                customerDTOList.add(customerDTO);
            }

            return customerDTOList;
        }else  {
            throw new NotFoundException("Customer Not Found");
        }
    }

    @Override
    public String deleteCustomer(int custemerId) {
        if (customerRepo.existsById(custemerId)) {
            customerRepo.deleteById(custemerId);
            return "Deleted Sucessfully " + custemerId;
        } else {
            throw new RuntimeException("No Customer found with that id");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState(Boolean activeState) {
        List<Customer> getAllCustomers = customerRepo.findAllByActiveEquals(activeState);
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer : getAllCustomers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactnumber(),
                    customer.getCustomersalary(),
                    customer.getNic(),
                    customer.isActive()
            );
            customerDTOList.add(customerDTO);
        }

        return customerDTOList;
    }
}
