package empReg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignoutController {

	// *************************** SIGN OUT HANDLER  *******************************
		@RequestMapping("/first_page")
		public String handleSignOut() {
			return "first_page";
		}
}
