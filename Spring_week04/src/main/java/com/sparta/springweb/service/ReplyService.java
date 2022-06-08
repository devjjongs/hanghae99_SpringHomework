package com.sparta.springweb.service;

import com.sparta.springweb.dto.ReplyRequestDto;
import com.sparta.springweb.model.Reply;
import com.sparta.springweb.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class ReplyService {

    private final ReplyRepository ReplyRepository;

    // 댓글 조회
    public List<Reply> getReply(Long postId) {
        return ReplyRepository.findAllByPostidOrderByCreatedAtDesc(postId);
    }

    // 댓글 작성
    @Transactional
    public Reply createReply(ReplyRequestDto requestDto,String username, Long userId) {
        String replyCheck = requestDto.getReply();
        if (replyCheck.contains("script") || replyCheck.contains("<") || replyCheck.contains(">")) {
            Reply reply = new Reply(requestDto, username, userId, "xss 안돼요,, 하지마세요ㅠㅠ");
            ReplyRepository.save(reply);
            return reply;
        }
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Reply reply = new Reply(requestDto, username, userId);
        ReplyRepository.save(reply);
        return reply;
    }

    // 댓글 수정
    @Transactional
    public String update(Long id, ReplyRequestDto requestDto, String username, Long userId) {
        Reply reply = ReplyRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않습니다."));
        Long writerId = reply.getUserId();
        if (Objects.equals(writerId, userId)) {
            reply.update(requestDto);
            return "댓글 수정 완료";
        } return "작성한 유저가 아닙니다.";
    }

    // 댓글 삭제
    public String deleteReply(Long replyId, Long userId) {
        Long writerId = ReplyRepository.findById(replyId).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다.")).getUserId();
        if (Objects.equals(writerId, userId)) {
            ReplyRepository.deleteById(replyId);
            return "댓글 삭제 완료";
        }
        return "작성한 유저가 아닙니다.";
    }
}