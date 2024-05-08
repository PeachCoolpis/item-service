package hello.itemservice.dto;


import lombok.Data;

@Data
public class ItemDto {
    
    private Long id;
    private String itemName;
    private Integer itemPrice;
    private Integer quantity;
}
