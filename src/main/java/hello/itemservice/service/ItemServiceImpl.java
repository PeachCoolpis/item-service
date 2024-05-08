package hello.itemservice.service;


import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hello.itemservice.entity.Item;
import hello.itemservice.dto.ItemDto;

import hello.itemservice.entity.QItem;
import hello.itemservice.entity.SaveItem;
import hello.itemservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    
    private final ItemRepository repository;
    private final JPAQueryFactory queryDsl;
    
    @Override
    @Transactional(readOnly = true)
    public Page<Item> findAll(Pageable page) {
        QItem item = QItem.item;
        
        
        List<Item> itemList = queryDsl
                .select(item)
                .from(item)
                .offset(page.getOffset())
                .limit(page.getPageSize())
                .fetch();
        
        JPAQuery<Long> count = queryDsl
                .select(item.count())
                .from(item);
        
        return PageableExecutionUtils.getPage(itemList, page, count::fetchOne);
    }
    
    @Override
    @Transactional(readOnly = true)
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
    public Long itemUpdate(Long id, ItemDto ItemDTO) {
        Item findItem = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("찾는 품목 없음"));
        findItem.updateItem(ItemDTO);
        return findItem.getId();
    }
}
