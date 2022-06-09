package com.sparta.week05.controller;

import com.sparta.week05.dto.RestaurantRequestDto;
import com.sparta.week05.model.Restaurant;
import com.sparta.week05.repository.RestaurantRepository;
import com.sparta.week05.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final RestaurantRepository repository;


    private final RestaurantService service;


    // 음식점 등록
    @PostMapping("/restaurant/register")
    public Restaurant createRestaurant(@RequestBody RestaurantRequestDto requestDto) {

        // 최소 주문 가격
        if (requestDto.getMinOrderPrice() < 1000 || requestDto.getMinOrderPrice() > 100000) {
            throw new IllegalArgumentException("최소 주문 가격 : 1,000원 ~ 100,000원 입력");
        }

        // 최소 주문 가격 단위
        if (requestDto.getMinOrderPrice() % 100 != 0) {
            throw new IllegalArgumentException("100 원 단위로만 입력 가능");
        }

        // 기본 배달비
        if (requestDto.getDeliveryFee() < 0 || requestDto.getDeliveryFee() > 10000) {
            throw new IllegalArgumentException("기본 배달비 : 0원 ~ 10,000원");
        }

        // 기본 배달비 단위
        if (requestDto.getDeliveryFee() % 500 != 0) {
            throw new IllegalArgumentException("500 원 단위로만 입력 가능");
        }

        Restaurant restaurant = new Restaurant(requestDto);

        return repository.save(restaurant);
    }

    // 음식점 조회
    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurant() {
        List<Restaurant> restaurantList = repository.findAll();
        return restaurantList;
    }
}
