package taiju.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import taiju.domain.Taiju;
import taiju.form.TaijuForm;
import taiju.service.TaijuService;

import java.util.List;

@Controller
@RequestMapping("/taiju")
public class TaijuController {
    @Autowired
    private TaijuService taijuService;

    @RequestMapping("/")
    String home(Model model) {
        List<Taiju> list = taijuService.findAll();
        model.addAttribute("taijuList", list);
        return "taiju/index";
    }

    @RequestMapping("/new")
    String newTaiju(TaijuForm taijuForm) {
        return "taiju/new";
    }

    @RequestMapping(value="/create",method = RequestMethod.POST)
    String createTaiju(@Validated TaijuForm taijuForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "taiju/new";
        }
        taijuService.save(taijuForm);
        return "redirect:/taiju/";
    }

}
