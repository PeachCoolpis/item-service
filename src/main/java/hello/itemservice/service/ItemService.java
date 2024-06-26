package hello.itemservice.service;

import hello.itemservice.entity.Item;
import hello.itemservice.dto.ItemDto;
import hello.itemservice.entity.SaveItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService {
    
    Page<ItemDto> findAll(Pageable page);
    
    List<ItemDto> findAll();
    
    Item findItem(Long id);
    
    Long itemSave(SaveItem saveItem);
    
    Long itemUpdate(Long id, ItemDto ItemDTO);
}
