package taiju;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
@ComponentScan
public class Main {

    @RequestMapping("/")
    public String home(){
        return "redirect:/taiju/";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }
}