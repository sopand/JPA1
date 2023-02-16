package com.jpa.dto;

import com.jpa.entity.Board;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardRequest {

	private String title; // 제목
	private String content; // 내용
	private String writer; // 작성자
	private char deleteYn; // 삭제 여부

	public Board toEntity() {
		return Board.builder().title(title).content(content).writer(writer).hits(0).deleteYn(deleteYn).build();
	}
}