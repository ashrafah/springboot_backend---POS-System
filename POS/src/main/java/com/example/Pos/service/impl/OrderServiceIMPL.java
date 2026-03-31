package com.example.Pos.service.impl;

import com.example.Pos.dto.request.OrderSaveRequestDTO;
import com.example.Pos.entity.Order;
import com.example.Pos.entity.OrderDetails;
import com.example.Pos.repo.CustomerRepo;
import com.example.Pos.repo.ItemRepo;
import com.example.Pos.repo.OrderDetailsRepo;
import com.example.Pos.repo.OrderRepo;
import com.example.Pos.service.OrderService;
import com.example.Pos.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private ItemRepo itemRepo;


    @Override
    @Transactional
    public String addOrder(OrderSaveRequestDTO orderSaveRequestDTO) {
        Order order = new Order(
                customerRepo.getById(orderSaveRequestDTO.getCustomer()),
                orderSaveRequestDTO.getDate(),
                orderSaveRequestDTO.getTotal()
        );
        orderRepo.save(order);



        if (orderRepo.existsById(order.getOrderId())) {

            List<OrderDetails>orderDetails = modelMapper.
                    map(orderSaveRequestDTO.getOrderDetails(),new TypeToken<List<OrderDetails>>(){
                    }.getType());
            for (int i=0;i<orderDetails.size();i++){
                orderDetails.get(i).setOrders(order);

                orderDetails.get(i).setItems(itemRepo.getById(orderSaveRequestDTO.getOrderDetails().get(i).getItemId()));


            }

            if(orderDetails.size()>0){
                orderDetailsRepo.saveAll(orderDetails);
            }
            return "";
        }
        throw null;
    }
}
