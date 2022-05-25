package com.sparta.week03.service;

import com.sparta.week03.domain.Post;
import com.sparta.week03.domain.PostRepository;
import com.sparta.week03.domain.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id의 글이 존재하지 않습니다."));
        if (post.getPassword() != requestDto.getPassword()) {
            new NullPointerException("비밀번호 불일치");
        }
        post.update(requestDto);
        return post.getId();
    }
}