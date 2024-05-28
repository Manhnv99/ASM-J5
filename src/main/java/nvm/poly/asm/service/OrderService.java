package nvm.poly.asm.service;

import nvm.poly.asm.entity.Order;
import nvm.poly.asm.model.request.CustomerRequest;
import nvm.poly.asm.model.request.OrderRequest;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface OrderService {

    UUID add(OrderRequest orderRequest);

    Order findById(String id);

    String delete(String id);

    String update(OrderRequest request, UUID id);

    String updateCustomer(CustomerRequest request, UUID id);

    Page<Order> getAll(int page);
}
