package modelandview.tehtava3.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import modelandview.tehtava3.domain.Friend;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class FriendController {

        //luodaan tyhjä ArrayList Student-olioille
        private List<Friend> friends = new ArrayList<>();

        //luodaan Friend -oliot ja lisätään ne friends -listaan kun Controller ajetaan
        public FriendController() {
        friends.add(new Friend("Minna", "Minnanen"));
        friends.add(new Friend("Tanja", "Tanjanen"));
        friends.add(new Friend("Jukka", "Jukkanen"));
        }

        //Suoritetaan seuraava kun haetaan http://localhost:8080/hello
    @GetMapping("/friends")
    public String friends(Model model) {

        //lisätään friends -lista modeliin jotta friends.html näkee listan tietoineen
        model.addAttribute("friends", friends);

        //ohjataan kutsu palauttamaan friends.html ja passataan model
        return "friends";
    }

    @GetMapping("/add")
    public String add(Model model) {
        //valmistaudutaan kyselemään uuden ystävän tiedot luomalla tyhjä ystävä olio ja heittämällä
        //käyttäjä kyselynäkymään
        model.addAttribute("friend", new Friend());
        return "add";
    }

    @PostMapping("/add")
    public String postMethodName(@ModelAttribute("friend") Friend friend) {
        friends.add(friend);
        return "redirect:/friends";
    }
    
    

}
