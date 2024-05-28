package nvm.poly.asm.service;

import nvm.poly.asm.entity.ProductDetail;
import nvm.poly.asm.model.request.ProductDetailRequest;
import nvm.poly.asm.model.response.ProductCardResponse;
import nvm.poly.asm.model.response.ProductDetailResponse;
import org.springframework.data.domain.Page;

import java.util.List;


public interface ProductDetailService {

    Page<ProductDetailResponse> getAll(Long productID, int page, Long colorID, Long sizeID);

    String add(ProductDetailRequest request);

    String update(ProductDetailRequest request, Long id);

    String delete(Long id);

    ProductDetail getProductDetailById(Long id);

    List<ProductCardResponse> getAllProductCard();

    void updateQuantityProductDetail(Long id, Integer quantity, String method);

    boolean existById(Long id);


}
