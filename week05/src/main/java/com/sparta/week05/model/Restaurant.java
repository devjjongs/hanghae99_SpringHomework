package com.sparta.week05.model;

//import com.sparta.week05.dto.RestaurantRequestDto;

import com.sparta.week05.dto.RestaurantRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Restaurant {

    // 음식점 ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // 음식점 이름
    @Column
    private String name;

    // 최소주문 가격
    @Column
    private int minOrderPrice;

    // 기본 배달비
    @Column
    private int deliveryFee;

    public Restaurant(RestaurantRequestDto requestDto) {
        this.name = requestDto.getName();
        this.minOrderPrice = requestDto.getMinOrderPrice();
        this.deliveryFee = requestDto.getDeliveryFee();
    }
}
