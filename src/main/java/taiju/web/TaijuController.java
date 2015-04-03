package taiju.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import taiju.domain.Taiju;
import taiju.service.TaijuService;

import java.util.List;

@Controller
public class TaijuController {
    @Autowired
    private TaijuService taijuService;

    @RequestMapping("/")
    String home(Model model) {
        List<Taiju> list = taijuService.findAll();
        model.addAttribute("taijuList", list);
        return "taiju/index";
    }

}