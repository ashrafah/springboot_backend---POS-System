package com.example.Pos.dto.request;

import com.example.Pos.entity.Item;
import com.example.Pos.entity.Order;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetailsSaveRequestDTO {

    private String itemName;
    private double qty;
    private double amount;
    private int itemId;
    private int orders;

}
