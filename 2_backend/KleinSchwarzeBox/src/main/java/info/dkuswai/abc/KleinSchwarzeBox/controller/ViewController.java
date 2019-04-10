package info.dkuswai.abc.KleinSchwarzeBox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {
    @RequestMapping(value={"", "/", "/error", "/*"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}