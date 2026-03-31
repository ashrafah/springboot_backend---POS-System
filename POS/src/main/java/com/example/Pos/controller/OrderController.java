package com.example.Pos.controller;

import com.example.Pos.dto.request.ItemSaveRequestDTO;
import com.example.Pos.dto.request.OrderSaveRequestDTO;
import com.example.Pos.service.OrderService;
import com.example.Pos.util.StandarardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;
    @PostMapping("/save")
    public ResponseEntity<StandarardResponse> saveItem(@RequestBody OrderSaveRequestDTO orderSaveRequestDTO) {
        String message = orderService.addOrder(orderSaveRequestDTO);

        return new  ResponseEntity<StandarardResponse>(
                new StandarardResponse(201,"Sucess", 2),
                HttpStatus.CREATED
        );
    }

}
