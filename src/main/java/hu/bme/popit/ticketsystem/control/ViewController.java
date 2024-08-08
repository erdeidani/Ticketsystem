package hu.bme.popit.ticketsystem.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class ViewController {


    public String showHome(){
        return "home.html";
    }

    @GetMapping("/home")
    public String showHome2(){
        return "home.html";
    }
    @GetMapping("/admin")
    public String showAdmin(){
        return "admin.html";
    }

}
