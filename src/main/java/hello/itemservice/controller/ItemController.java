package hello.itemservice.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {
    
    
    @GetMapping("/basic/items")
    public String index() {
        return "item";
    }
}



