package hello.itemservice.controller;


import hello.itemservice.entity.Item;
import hello.itemservice.entity.ItemDTO;
import hello.itemservice.entity.SaveItem;
import hello.itemservice.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String addForm(Model model) {
        model.addAttribute("item", new Item());
        return "basic/addForm";
    }
    
    @PostMapping("/add")
    public String add(@Validated @ModelAttribute("item") SaveItem saveItem, BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()) {
            return "basic/addForm";
        }
        service.itemSave(saveItem);
        
        return "redirect:/basic/items";
    }
    
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id , Model model) {
        Item item = service.findItem(id);
        model.addAttribute("item", item);
        return "basic/editForm";
    }
    
    @PostMapping("/{id}/edit")
    public String edit(@PathVariable Long id , @ModelAttribute("itemDto")ItemDTO itemDto ) {
        Long itemId = service.itemUpdate(id, itemDto);
        //테스트 빌드 테스트
        return "redirect:" + String.format("/basic/items/%s", itemId);
    }
    
}



