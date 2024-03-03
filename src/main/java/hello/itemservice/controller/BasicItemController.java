package hello.itemservice.controller;


import hello.itemservice.entity.Item;
import hello.itemservice.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/basic/items")
public class BasicItemController {
    
    private final ItemService service;
    
    
    @GetMapping
    public String index(Model model) {
        List<Item> items = service.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }
    
    @GetMapping("/{id}")
    public String findItem(@PathVariable Long id, Model model) {
        Item item = service.findItem(id);
        model.addAttribute("item", item);
        return "basic/item";
    }
    
    @GetMapping("/add")
    public String add() {
        return "/basic/addForm";
    }
    
}



