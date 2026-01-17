package modelandview.tehtava4.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import modelandview.tehtava4.domain.Friend;
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

        //lisätään friends -lista modeliin sekä uusi tyhjä friend olio täytettäväksi
        model.addAttribute("friends", friends);
        model.addAttribute("friend", new Friend());

        //ohjataan kutsu palauttamaan friends.html ja passataan model
        return "friends";
    }

    @PostMapping("/friends")
    public String addFriend(@ModelAttribute("friend") Friend friend, Model model) {
        friends.add(friend);            // lisätään uuden kaverin tiedot
        model.addAttribute("friends", friends);   // päivitetään model
        model.addAttribute("friend", new Friend());
        return "friends";               // render same page
    }
    
    

}

