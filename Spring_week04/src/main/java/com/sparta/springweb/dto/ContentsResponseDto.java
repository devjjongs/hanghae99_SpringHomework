package com.sparta.springweb.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sparta.springweb.model.Contents;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ContentsResponseDto {
    private Long id;
    private String title;
    private String name;
    private String contents;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime modifiedAt;
    private int countReply;

    @Builder
    public ContentsResponseDto(Contents content, int countReply) {
        this.id = content.getId();
        this.title = content.getTitle();
        this.name = content.getName();
        this.contents = content.getContents();
        this.modifiedAt = content.getModifiedAt();
        this.countReply = countReply;
    }
}
