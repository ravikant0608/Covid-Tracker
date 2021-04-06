package rk.spring.handson.coronavirustrackerjavabrains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import rk.spring.handson.coronavirustrackerjavabrains.services.CoronaVirusDataService;

@Controller
public class HomeController {
	
    @Autowired
	CoronaVirusDataService coronavirusdataservice;
	
	@GetMapping("/")
	public String home(Model model ) {
    			
		model.addAttribute("locationstats",coronavirusdataservice.getAllstats());
		return "home";
		
	}
	
	

}
