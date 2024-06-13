package hello.itemservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    
    private Long id;
    private String itemName;
    private Integer itemPrice;
    private Integer quantity;
}
