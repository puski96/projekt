package ro.allamvizsga.projekt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ro.allamvizsga.projekt.model.User;
import ro.allamvizsga.projekt.service.EmailService;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@Controller
public class EmailController {
	
	    
	    private EmailService emailService;

		@Autowired
		public void setEmailService(EmailService emailService) {
			this.emailService = emailService;
		}
		
		@PostMapping("/send")
	    public String greetingSubmit(@ModelAttribute User user) {
			emailService.sendMessage(user.getUserName());
	        return "auth/login";
	    }
}
