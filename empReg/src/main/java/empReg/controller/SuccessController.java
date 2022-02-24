package empReg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SuccessController {

	
	//	*********************   Handling the SUCCESS PAGE  *************
	@RequestMapping("/handle_success_button")
	public String handle_success_button() {
		return "first_page";
	}
}
