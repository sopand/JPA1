package com.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.entity.Board;
import com.jpa.entity.BoardRepository;

@SpringBootTest
public class BoardTests {
	@Autowired
	BoardRepository boardRepository;

	@Test
	void save() {
		Board params = Board.builder().title("1번 게시글 제목").content("1번 게시글 내용").writer("도뎡이").hits(0).deleteYn('N')
				.build();

		boardRepository.save(params);
		Board entity = boardRepository.findById((long) 3).get();
		assertThat(entity.getTitle()).isEqualTo("1번 게시글 제목");
		assertThat(entity.getContent()).isEqualTo("1번 게시글 내용");
		assertThat(entity.getWriter()).isEqualTo("도뎡이");
	}

	@Test
	void findAll() {

		// 1. 전체 게시글 수 조회
		long boardsCount = boardRepository.count();

		// 2. 전체 게시글 리스트 조회
		List<Board> boards = boardRepository.findAll();
	}

	@Test
	void delete() {

		// 1. 게시글 조회
		Board entity = boardRepository.findById((long) 1).get();

		// 2. 게시글 삭제
		boardRepository.delete(entity);
	}
}
