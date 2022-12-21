package pala.wiva.controller;

import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WivaController {

    @GetMapping("welcome")
    public String welcome(Model model){
        model.addAttribute("data","Welcome to the World of WarCraft");
        return "welcome";
    }

    @GetMapping("welcome-mvc")
    public String welcomeMVC(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name",name);
        return "welcome-template";
    }

    @GetMapping("welcome-string")
    @ResponseBody
    public String welcomeString(@RequestParam(value = "name") String name){
        return "Welcome, " + name;
    }

    @GetMapping("welcome-api")
    @ResponseBody
    public Welcome welcomeApi(@RequestParam("name") String name){
        Welcome welcome = new Welcome();
        welcome.setName(name);
        return welcome;
    }

    static class Welcome {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
