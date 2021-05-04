package guru.springframework.controllers;

import guru.springframework.domain.UserEmail;
import guru.springframework.services.SendingMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class FormController {
    @Autowired
    SendingMailService sendingMailService;

//    @GetMapping("/")
//    public String index() {
//        return "redirect:/contact";
//    }

    @GetMapping("/contact")
    public String formGet(Model model) {
        model.addAttribute("user", new UserEmail());
        return "contact";
    }

    @PostMapping("/contact")
    public String formPost(@Valid UserEmail user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "contact";
        }

        model.addAttribute("noErrors", true);
        model.addAttribute("user", user);
        String subject = user.getName() + " " + user.getEmail() + " sent you a message";
        sendingMailService.sendMail(subject, user.getMessage());
        return "contact";
    }
}