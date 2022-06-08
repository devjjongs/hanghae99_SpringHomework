package com.sparta.springweb.service;


import com.sparta.springweb.dto.LoginRequestDto;
import com.sparta.springweb.dto.SignupRequestDto;
import com.sparta.springweb.jwt.JwtTokenProvider;
import com.sparta.springweb.model.User;
import com.sparta.springweb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";

    // 로그인
    public Boolean login(LoginRequestDto loginRequestDto){
        User user = userRepository.findByUsername(loginRequestDto.getUsername())
                .orElse(null);
        if (user != null) {
            if (!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    // 회원가입
    public String registerUser(SignupRequestDto requestDto) {
        String error = "";
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();
        String password2 = requestDto.getPassword2();
        String pattern = "^[a-zA-Z0-9]*$";

        // 회원 ID 중복 확인
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            return "중복된 id 입니다.";
        }

        // 회원가입 조건
        if (username.length() < 3) {
            return "닉네임을 3자 이상 입력하세요";
        } else if (!Pattern.matches(pattern, username)) {
            return "알파벳 대소문자와 숫자로만 입력하세요";
        } else if (!password.equals(password2)) {
            return "비밀번호가 일치하지 않습니다";
        } else if (password.length() < 4) {
            return "비밀번호를 4자 이상 입력하세요";
        } else if (password.contains(username)) {
            return "비밀번호에 닉네임을 포함할 수 없습니다.";
        }

        // 패스워드 인코딩
        password = passwordEncoder.encode(password);
        requestDto.setPassword(password);

        // 유저 정보 저장
        User user = new User(username, password);
        userRepository.save(user);
        return error;
    }

}