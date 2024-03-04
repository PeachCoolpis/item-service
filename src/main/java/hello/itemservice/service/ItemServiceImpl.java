package hello.itemservice.service;


import hello.itemservice.entity.Item;
import hello.itemservice.entity.ItemDTO;
import hello.itemservice.entity.SaveItem;
import hello.itemservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class ItemServiceImpl implements ItemService{

    private final ItemRepository repository;
    
    
    @Override
    public List<Item> findAll() {
        return repository.findAll();
    }
    
    @Override
    public Item findItem(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("찾는 품목 없음"));
    }
    
    @Override
    public Long itemSave(SaveItem saveItem) {
        Item item = new Item(saveItem.getItemName(), saveItem.getItemPrice(), saveItem.getQuantity());
        Item save = repository.save(item);
        return save.getId();
    }
    
    @Override
    public Long itemUpdate(Long id,ItemDTO ItemDTO) {
        Item findItem = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("찾는 품목 없음"));
        findItem.updateItem(ItemDTO);
        return findItem.getId();
    }
}
