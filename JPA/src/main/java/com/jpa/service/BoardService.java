package com.jpa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.dto.BoardRequest;
import com.jpa.dto.BoardResponse;
import com.jpa.entity.Board;
import com.jpa.entity.BoardRepository;
import com.jpa.exception.CustomException;
import com.jpa.exception.ErrorCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;

	@Transactional
	public Long save(final BoardRequest params) {

		Board entity = boardRepository.save(params.toEntity());
		return entity.getId();
	}

	/**
	 * 게시글 리스트 조회
	 */
	public List<BoardResponse> findAll() {
		Sort sort = Sort.by(Direction.DESC, "id", "createdDate");
		List<Board> list = boardRepository.findAll(sort);
		return list.stream().map(BoardResponse::new).collect(Collectors.toList());
	}

	/**
	 * 게시글 수정
	 */
	@Transactional
	public Long update(final Long id, final BoardRequest params) {

		Board entity = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
		entity.update(params.getTitle(), params.getContent(), params.getWriter());
		return id;
	}

}
