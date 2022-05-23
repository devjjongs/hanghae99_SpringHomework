package com.sparta.week03.service;

import com.sparta.week03.domain.Post;
import com.sparta.week03.domain.PostRepository;
import com.sparta.week03.domain.PostRequestDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PostService {
    private final PostRepository postRepository;

    // Service 클래스를 만들 때 꼭 Repository를 포함
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // SQL 쿼리 실행 부분
    @Transactional
    public Long update(Long id, PostRequestDto requestDto) {
        Post post1 = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("")
        );
        post1.update(requestDto);
        return post1.getId();
    }
}
