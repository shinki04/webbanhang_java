package com.vanlang.webbanhang.model;

import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Không được trống")

    private String customerName;
    @NotBlank(message = "Không được trống")

    private String address;
    private String notes;

    @NotBlank(message = "Không được trống")
    private String phone;
    private String email;
    private String paymentMethod;


    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;
}
