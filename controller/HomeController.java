package com.recipe.common.controller;

import java.util.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.recipe.common.dao.*;

@Controller
public class HomeController {
	@Autowired
	UserDAO userDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);		
		return "redirect:/main";
	}
	@RequestMapping("main")
	private String miniMain() {
		return "main";
	}
	@RequestMapping("adminMenu")
	private String adminMenu() {
		return "adminMenu";
	}
	
}
