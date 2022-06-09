package com.sparta.week05.service;

import com.sparta.week05.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository repository;
}
