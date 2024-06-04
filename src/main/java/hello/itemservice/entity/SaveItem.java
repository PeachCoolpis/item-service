package hello.itemservice.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SaveItem {
    
    @NotBlank(message = "품목 이름을 입력해주세요")
    private String itemName;
    @NotNull(message = "품목 가격을 입력해주세요")
    private Integer itemPrice;
    @NotNull(message = "품목 수량을 입력해주세요")
    private Integer quantity;
}
