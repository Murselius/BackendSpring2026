package modelandview.tehtava2.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import modelandview.tehtava2.domain.Student;

@Controller
public class StudentController {


    //Suoritetaan seuraava kun haetaan http://localhost:8080/hello
    @GetMapping("/hello")
    public String hello(Model model) {
        
        //luodaan tyhjä ArrayList Student-olioille
        List<Student> students = new ArrayList<>();


        //luodaan Student -oliot ja lisätään ne students -listaan
        students.add(new Student("Kate", "Cole"));
        students.add(new Student("Dan", "Brown"));
        students.add(new Student("Mike", "Mars"));

        //lisätään students -lista modeliin jotta hello.html näkee listan tietoineen
        model.addAttribute("students",students);

        //ohjataan kutsu palauttamaan hello.html ja passataan model
        return "hello";
    }

}

