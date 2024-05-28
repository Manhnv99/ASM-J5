package nvm.poly.asm.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    Integer quantity;

    Boolean status;

    Double totalMoney;

    Long customerID;

    String payment;

    String userID;

}
