package com.sparta.week03.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
//@RequiredArgsConstructor
// 왜 생성자가 ?
public class PostResponseDto {
    private Long id;
    private String title;
    private String comment;
    private String writer;
    private LocalDateTime createdAt;
}