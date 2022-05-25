package com.sparta.week03.controller;

import com.sparta.week03.domain.Post;
import com.sparta.week03.domain.PostRepository;
import com.sparta.week03.domain.PostRequestDto;
import com.sparta.week03.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;

    private final PostService postService;

    // 게시글 작성 API
    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    // 게시글 조회 API
    @GetMapping("/api/posts")
    public List<Post> getPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    // 게시글 수정 API
    @PutMapping("/api/posts/{id}")
    public boolean updatePosts(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.update(id, requestDto);
    }

    // 게시글 삭제 API
    @DeleteMapping("/api/posts/{id}")
    public boolean deletePosts(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.delete(id, requestDto);
    }
}
