package nvm.poly.asm.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

    Long id;

    String address;

    String fullName;

    String phoneNumber;

}
