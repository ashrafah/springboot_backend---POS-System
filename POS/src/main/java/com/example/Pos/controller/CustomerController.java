package com.example.Pos.controller;

import com.example.Pos.dto.CustomerDTO;
import com.example.Pos.dto.request.customerUpdateDTO;
import com.example.Pos.service.CustomerService;
import com.example.Pos.util.StandarardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public String savecustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.savecustomer(customerDTO);
        return "saved";
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody customerUpdateDTO customerupdateDTO) {
        customerService.updateCustomer(customerupdateDTO);
        return "updated";
    }

    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomer(@RequestParam("id") int custemerId) {
        CustomerDTO customerDTO = customerService.getCustomerById(custemerId);
        return customerDTO;
    }

//    @GetMapping(
//            path = "get-all-customers"
//    )
//    public List<CustomerDTO> getAllCustomers() {
//        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
//        return allCustomers;
//    }

    @GetMapping(
            path = "get-all-customers"
    )
    public ResponseEntity<StandarardResponse> getAllCustomers() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return new  ResponseEntity<StandarardResponse>(
                new StandarardResponse(200,"Sucess", allCustomers),
                HttpStatus.OK
        );
    }

    @DeleteMapping(
            path = "delete-customer/{id}"
    )
    public String deleteCustomer(@PathVariable("id") int custemerId) {
        String deleted = customerService.deleteCustomer(custemerId);
        return deleted;
    }

    @GetMapping(
            path = "get-all-customers-by-active-state/{status}"
    )
    public List<CustomerDTO> getAllCustomersByActiveState(@PathVariable(value = "status") Boolean activeState) {
        List<CustomerDTO> allCustomers = customerService.getAllCustomersByActiveState(activeState);
        return allCustomers;
    }

}
