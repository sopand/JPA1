package com.board.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.board.dto.BoardRequest;
import com.board.entity.Board;
import com.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {
	// private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final BoardService boardService;

	@GetMapping("/")
	public String loadIndex() {
		return "index";
	}

	@GetMapping("/boards/{page}/{size}")
	public String findBoards(@PathVariable int page, @PathVariable int size, Model model) {
		PageRequest pageRequest=PageRequest.of(page, size, Sort.by("id").descending());
		Page<Board> pageableList = boardService.findAll(pageRequest);
		model.addAttribute("pageableList", pageableList);
		model.addAttribute("page", pageRequest.getPageNumber());
		return "boardlist";
	}

	@GetMapping("/boards/form")
	public String loadBoardForm() {
		return "boardadd";
	}

	@PostMapping("/boards")
	public String createBoard(BoardRequest boardRequest) {
		boardService.save(boardRequest);
		return "redirect:/boards";
	}
}
