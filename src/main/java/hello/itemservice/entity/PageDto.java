package hello.itemservice.entity;


import lombok.Getter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Getter
public class PageDto {
    
    private static final int BTN_GROUP = 5;
    
    private int currentPage;
    private int totalPages;
    
    
    public PageDto(int currentPage, int totalPages) {
        this.currentPage = currentPage;
        this.totalPages = totalPages;
    }
    
    
    public int getStartPage() {
        int currentGroup = currentPage / BTN_GROUP;
        return currentGroup * BTN_GROUP;
    }
    
    public int getEndPage() {
        int startPage = getStartPage();
        return Math.min(startPage + BTN_GROUP, totalPages);
    }
}
