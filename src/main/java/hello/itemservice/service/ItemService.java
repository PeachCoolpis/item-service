package hello.itemservice.service;

import hello.itemservice.entity.Item;
import hello.itemservice.entity.ItemDTO;

import java.util.List;

public interface ItemService {
    
    List<Item> findAll();
    
    Item findItem(Long id);
    
    Long itemSave(Item item);
    
    Long itemUpdate(Long id, ItemDTO ItemDTO);
}
