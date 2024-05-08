package hello.itemservice.service;

import hello.itemservice.entity.Item;
import hello.itemservice.dto.ItemDto;
import hello.itemservice.entity.SaveItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemService {
    
    Page<Item> findAll(Pageable page);
    
    Item findItem(Long id);
    
    Long itemSave(SaveItem saveItem);
    
    Long itemUpdate(Long id, ItemDto ItemDTO);
}
