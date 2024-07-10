package com.vanlang.webbanhang.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class CartItem {
    private Product product;
    private int quantity;

}
