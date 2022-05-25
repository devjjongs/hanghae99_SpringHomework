package com.sparta.week03.service;

import com.sparta.week03.domain.Post;
import com.sparta.week03.domain.PostRepository;
import com.sparta.week03.domain.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    // 비밀번호 일치시 수정
    @Transactional
    public boolean update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id의 글이 존재하지 않습니다."));
//        System.out.println(post.getPassword());   //  저장된 비밀번호
//        System.out.println(requestDto.getPassword()); //  입력한 비밀번호
        if (!post.getPassword().equals(requestDto.getPassword())) {
            return false;
        }
        post.update(requestDto);
        return true;
    }

    // 비밀번호 일치시 삭제
    @Transactional
    public boolean delete(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id의 글이 존재하지 않습니다."));
        if (post.getPassword().equals(requestDto.getPassword())) {
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
