package nvm.poly.asm.service;

import nvm.poly.asm.model.request.OrderDetailRequest;
import nvm.poly.asm.model.response.OrderDetailResponse;

import java.util.List;
import java.util.UUID;

public interface OrderDetailService {

    String add(OrderDetailRequest orderDetailRequest);

    List<OrderDetailResponse> getAllProductCardByOrderID(UUID orderID);

    String delete(String id);

    String update(OrderDetailRequest orderDetailRequest, String id);
}
