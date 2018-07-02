package org.bbako.controller;

import java.util.Locale;

import javax.inject.Inject;

import org.bbako.persistence.BoardDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/board/")
public class BoardController {

	@Inject
	BoardDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);


	@GetMapping(value = "/listAll")
	public void listAll() throws Exception {
		dao.readAll();
		
		
	}
	
}
