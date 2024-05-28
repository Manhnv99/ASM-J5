package nvm.poly.asm.service;

import nvm.poly.asm.entity.Customer;
import nvm.poly.asm.model.request.CustomerRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {

    List<Customer> getAll();

    Page<Customer> getAllByPage(int page);

    Customer getCustomerById(Long id);

    String update(CustomerRequest request, Long id);
}
