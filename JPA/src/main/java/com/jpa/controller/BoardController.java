package com.jpa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.dto.BoardRequest;
import com.jpa.dto.BoardResponse;
import com.jpa.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	 @PostMapping("/boards")
	    public Long save(@RequestBody final BoardRequest params) {
	        return boardService.save(params);
	    }

	    /**
	     * 게시글 리스트 조회
	     */
	    @GetMapping("/boards")
	    public List<BoardResponse> findAll() {
	        return boardService.findAll();
	    }

	    /**
	     * 게시글 수정
	     */
	    @PatchMapping("/boards/{id}")
	    public Long save(@PathVariable final Long id, @RequestBody final BoardRequest params) {
	        return boardService.update(id, params);
	    }
}
