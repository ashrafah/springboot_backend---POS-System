package com.example.Pos.entity;

import com.example.Pos.entity.enums.MeasuringUnitType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table (name = "item")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Item {

    @Id
    @Column(name = "item_id", length = 10)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column (name = "item_name" , length = 50 ,nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column (name = "measure_type" , length = 50 ,nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column (name = "balance_qty" , length = 50 ,nullable = false)
    private double balanceQty;

    @Column (name = "supplier_price" , length = 50 ,nullable = false)
    private double supplierPrice;

    @Column (name = "selling_price" , length = 50 ,nullable = false)
    private double sellingPrice;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean activeState;

    @OneToMany(mappedBy = "items")
    private Set<OrderDetails> orderDetails;

}
