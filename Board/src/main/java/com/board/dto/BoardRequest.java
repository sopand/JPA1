package com.board.dto;

import com.board.entity.Board;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardRequest {

    private String title; // 제목
    private String content; // 내용
    private String writer; // 작성자

    public Board toEntity() {
        return Board.builder().title(title).content(content).writer(writer).hits(0).build();
    }
}