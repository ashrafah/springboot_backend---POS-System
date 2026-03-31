package com.example.Pos.service;

import com.example.Pos.dto.request.OrderSaveRequestDTO;

public interface OrderService {
    String addOrder(OrderSaveRequestDTO orderSaveRequestDTO);
}
