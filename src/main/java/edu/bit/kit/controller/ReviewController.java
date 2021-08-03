package edu.bit.kit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import edu.bit.kit.service.ReviewServiceImpl;


@Controller
@RequestMapping("/review/**")
public class ReviewController {
	
	@Autowired
	private ReviewServiceImpl reviewService;
	
	@GetMapping("/list")
	public String list( Model model) {
	    System.out.println("list()..");
	    System.out.println(reviewService.getList());
		
		model.addAttribute("list",reviewService.getList());
		
		return "list";
	}
	
}
