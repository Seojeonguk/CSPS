package com.js.freeproject.domain.board.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.js.freeproject.domain.board.domain.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardUserResponse {
    private Long id;
    private String title;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    public BoardUserResponse(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.description = board.getDescription();
        this.createDate = board.getCreateDate();
    }
}