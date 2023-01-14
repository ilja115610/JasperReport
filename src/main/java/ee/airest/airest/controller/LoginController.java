package ee.airest.airest.controller;

import ee.airest.airest.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {


    @GetMapping(value = "/login")
    public String getLogin(@ModelAttribute("user") User user) {

        return "login";
    }



}
