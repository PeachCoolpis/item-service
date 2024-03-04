package hello.itemservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "ITEM",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"ITEM_NAME"} ,name = "uniqueItemName")
})
@Getter
@Setter
@NoArgsConstructor
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    @Comment("상품 ID")
    private Long id;
    
    @Column(name = "ITEM_NAME")
    @Comment("상품 이름")
    private String itemName;
    
    @Column(name = "ITEM_PRICE")
    @Comment("상품 가격")
    private Integer itemPrice;
    
    @Column(name = "QUANTITY")
    @Comment("상품 수량")
    private Integer quantity;
    
    public Item(String itemName, int itemPrice, int quantity) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }
    
    public void updateItem(ItemDTO itemDTO) {
        this.itemName = itemDTO.getItemName();
        this.itemPrice = itemDTO.getItemPrice();
        this.quantity = itemDTO.getQuantity();
    }
}
