package com.sparta.springweb.controller;

import com.sparta.springweb.dto.LoginRequestDto;
import com.sparta.springweb.dto.SignupRequestDto;
import com.sparta.springweb.jwt.JwtTokenProvider;
import com.sparta.springweb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    // 회원 로그인
    @PostMapping("/user/login")
    public String login(@RequestBody LoginRequestDto loginRequestDto) {
        if (userService.login(loginRequestDto)) {
            String token = jwtTokenProvider.createToken(loginRequestDto.getUsername());
            System.out.println(token);
            return token;
        } else {
            return "닉네임 또는 패스워드를 확인해주세요";
        }
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(@Valid @RequestBody SignupRequestDto requestDto) {
        String res = userService.registerUser(requestDto);
        if (res.equals("")) {
            return "회원가입 성공";
        } else {
//            model.addAttribute("errortext", userService.registerUser(requestDto));
            return res;
        }
    }
}