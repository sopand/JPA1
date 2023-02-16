package com.jpa.dto;

import java.time.LocalDateTime;

import com.jpa.entity.Board;

import lombok.Getter;

@Getter
public class BoardResponse {
	private Long id; // PK
	private String title; // 제목
	private String content; // 내용
	private String writer; // 작성자
	private int hits; // 조회 수
	private char deleteYn; // 삭제 여부
	private LocalDateTime createdDate; // 생성일
	private LocalDateTime modifiedDate; // 수정일

	public BoardResponse(Board entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.writer = entity.getWriter();
        this.hits = entity.getHits();
        this.deleteYn = entity.getDeleteYn();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
    }

}
