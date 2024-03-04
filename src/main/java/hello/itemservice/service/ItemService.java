package hello.itemservice.service;

import hello.itemservice.entity.Item;
import hello.itemservice.entity.ItemDTO;
import hello.itemservice.entity.SaveItem;

import java.util.List;

public interface ItemService {
    
    List<Item> findAll();
    
    Item findItem(Long id);
    
    Long itemSave(SaveItem saveItem);
    
    Long itemUpdate(Long id, ItemDTO ItemDTO);
}
