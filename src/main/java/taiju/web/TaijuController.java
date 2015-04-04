package taiju.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import taiju.domain.Taiju;
import taiju.form.TaijuForm;
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

    @RequestMapping("/taiju/new")
    String newTaiju(TaijuForm taijuForm) {
        return "taiju/new";
    }

    @RequestMapping(value="/taiju/create",method = RequestMethod.POST)
    String createTaiju(TaijuForm taijuForm){
        taijuService.save(taijuForm);
        return "redirect:/";
    }

}
