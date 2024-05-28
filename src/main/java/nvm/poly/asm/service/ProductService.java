package nvm.poly.asm.service;

import nvm.poly.asm.entity.Product;
import nvm.poly.asm.model.request.ProductRequest;
import nvm.poly.asm.model.response.ProductResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    Page<ProductResponse> getProductPagination(int page);

    String addProduct(ProductRequest productRequest);

    String updateProduct(ProductRequest request, Long id);

    Page<ProductResponse> searchProduct(int page, String productName);

    Product getProductById(Long id);

    List<ProductResponse> getAllProducts();
}
