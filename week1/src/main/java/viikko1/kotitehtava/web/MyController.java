package viikko1.kotitehtava.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
public class MyController {

    @RequestMapping("/index")
    public String returnMainMessage() {
        return "This is the main page";
    }
    
    @RequestMapping("/contact")
    public String returnContactMessage() {
        return "This is the contact page";
    }

    @RequestMapping("hello")
    public String returnMoonGreeting(@RequestParam (name="location", required = false, defaultValue = "landing zone") String location, @RequestParam (name="name", required=false, defaultValue = "John Doe") String name) {
        return "Welcome to the " + location + " " + name + "!";
    }

}