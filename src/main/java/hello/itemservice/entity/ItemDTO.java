package hello.itemservice.entity;


import lombok.Data;

@Data
public class ItemDTO {
    
    private Long id;
    private String itemName;
    private Integer itemPrice;
    private Integer quantity;
}
