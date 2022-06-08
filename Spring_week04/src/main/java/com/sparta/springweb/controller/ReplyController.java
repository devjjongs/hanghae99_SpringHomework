package com.sparta.springweb.controller;

import com.sparta.springweb.dto.ReplyRequestDto;
import com.sparta.springweb.model.Reply;
import com.sparta.springweb.repository.ReplyRepository;
import com.sparta.springweb.security.UserDetailsImpl;
import com.sparta.springweb.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ReplyController {

    private final ReplyRepository ReplyRepository;
    private final ReplyService ReplyService;

    // 게시글 id 로 댓글 조회
    @GetMapping("/api/reply/{postId}")
    public List<Reply> getReply(@PathVariable Long postId) {
        return ReplyService.getReply(postId);
    }

    // 댓글 작성
    @PostMapping("/api/reply")
    public String createReply(@RequestBody ReplyRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 로그인 되어 있는 ID
        if (userDetails != null) {
            Long userId = userDetails.getUser().getId();
            String username = userDetails.getUser().getUsername();
            ReplyService.createReply(requestDto, username, userId);
            return "댓글 작성 완료";
        }
        return "로그인이 필요한 기능입니다.";
    }

    // 댓글 수정
    @PutMapping("/api/reply/{id}")
    public String updateReply(@PathVariable Long id, @RequestBody ReplyRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 로그인 되어 있는 ID
        if (userDetails != null) {
            Long userId = userDetails.getUser().getId();
            String username = userDetails.getUser().getUsername();
            String result = ReplyService.update(id, requestDto, username, userId);
            return result;
        }
        return "로그인이 필요한 기능입니다.";
    }

    // 댓글 삭제
    @DeleteMapping("/api/reply/{replyId}")
    public String deleteReply(@PathVariable Long replyId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        // 로그인 되어 있는 ID
        if (userDetails != null) {
            Long userId = userDetails.getUser().getId();
            String result = ReplyService.deleteReply(replyId, userId);
            return result;
        }
        return "로그인이 필요한 기능입니다.";
    }
}