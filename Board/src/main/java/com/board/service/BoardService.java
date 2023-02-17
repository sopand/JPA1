package com.board.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.dto.BoardRequest;
import com.board.dto.BoardResponse;
import com.board.entity.Board;
import com.board.entity.BoardRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
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
	public Page<Board> findAll(PageRequest pagerequest) {
		return boardRepository.findAll(pagerequest);
	}

	/**
	 * 게시글 수정
	 */

}
