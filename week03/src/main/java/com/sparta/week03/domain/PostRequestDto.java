package com.sparta.week03.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PostRequestDto {
    private String title;
    private String comment;
    private String writer;
    private String password;
}
