package hello.itemservice.service;

import hello.itemservice.entity.PageDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class PaginationService {
    
    public PageDto createPageDto(Page<?> page) {
        return new PageDto(page.getNumber(), page.getTotalPages());
    }
}