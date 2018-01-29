package com.codingdojo.HelloHuman.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/") // all paths will be mapped from this path


public class HumanController {

	
	// GET method is implied, but here's how it looks when invoked
		@RequestMapping("")
		public String index(Model model, @RequestParam(value="first", defaultValue="Human") String first,@RequestParam(value="last" ,defaultValue="")String last ) {
			model.addAttribute("first",first);
			model.addAttribute("last",last);
			
			
			return "index";
		}
		
}
