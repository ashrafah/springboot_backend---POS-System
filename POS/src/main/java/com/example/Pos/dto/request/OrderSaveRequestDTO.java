package com.example.Pos.dto.request;


import com.example.Pos.entity.Customer;
import com.example.Pos.entity.OrderDetails;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderSaveRequestDTO {

    private int customer;
    private Date date;
    private double total;
    private List<OrderDetailsSaveRequestDTO> orderDetails;
}