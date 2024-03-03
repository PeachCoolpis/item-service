package hello.itemservice.service;

import hello.itemservice.entity.Item;

import java.util.List;

public interface ItemService {
    
    List<Item> findAll();
    
    Item findItem(Long id);
    
    Long itemSave(Item item);
}
