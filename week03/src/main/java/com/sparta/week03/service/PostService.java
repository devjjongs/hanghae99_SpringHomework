package com.sparta.week03.service;

import com.sparta.week03.domain.GetPostResponseDto;
import com.sparta.week03.domain.Post;
import com.sparta.week03.domain.PostRepository;
import com.sparta.week03.domain.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    // 데이터 조회
    @Transactional
    public List<GetPostResponseDto> getPosts() {
        // 전체 목록을 postList로 불러오기
        List<Post> postList = postRepository.findAll();
        // Post를 Dto로 바꾸기
        List<GetPostResponseDto> getPostResponseDto = new ArrayList<>();
        for (int i = 0; i < postList.size(); i++) {
            // list 반복
            Post post = postList.get(i);
            // Dto에 추가
            GetPostResponseDto getPostDto = new GetPostResponseDto(post.getId(), post.getTitle(), post.getComment(), post.getWriter(), post.getCreatedAt());
            // 생성한 데이터 추가
            getPostResponseDto.add(getPostDto);
        }
        return getPostResponseDto;
    }


    // 비밀번호 일치시 수정
    @Transactional
    public boolean update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id의 글이 존재하지 않습니다."));
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
