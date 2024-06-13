package hello.itemservice.controller;


import hello.itemservice.dto.ItemDto;
import hello.itemservice.dto.MemberDto;
import hello.itemservice.dto.PageDto;
import hello.itemservice.entity.*;
import hello.itemservice.service.ItemService;
import hello.itemservice.service.PaginationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequiredArgsConstructor
@RequestMapping("/basic/items")
public class ItemController {
    
    private final ItemService service;
    private final PaginationService paginationService;
    
    

    @GetMapping
    public String index(Model model,
                        @PageableDefault(page = 0, size = 10) Pageable page) {
        Page<ItemDto> items = service.findAll(page);
        PageDto pagedto = paginationService.createPageDto(items);
        model.addAttribute("items", items.getContent());
        model.addAttribute("pageIndices", IntStream.range(pagedto.getStartPage(), pagedto.getEndPage())
                .boxed()
                .collect(Collectors.toList()));
        model.addAttribute("currentPage", pagedto.getCurrentPage());
        model.addAttribute("totalPages", pagedto.getTotalPages());
        return "basic/items";
    }
    
    @GetMapping("/{id}")
    public String findItem(@PathVariable Long id, Model model , @AuthenticationPrincipal MemberDto memberDto) {
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
    public String editForm(@PathVariable Long id, Model model) {
        Item item = service.findItem(id);
        model.addAttribute("item", item);
        return "basic/editForm";
    }
    
    @PostMapping("/{id}/edit")
    public String edit(@PathVariable Long id, @ModelAttribute("itemDto") ItemDto itemDto) {
        Long itemId = service.itemUpdate(id, itemDto);
        //테스트 빌드 테스트
        return "redirect:" + String.format("/basic/items/%s", itemId);
    }
    
}



