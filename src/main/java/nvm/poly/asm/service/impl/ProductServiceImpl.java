package nvm.poly.asm.service.impl;

import nvm.poly.asm.entity.Product;
import nvm.poly.asm.model.request.ProductRequest;
import nvm.poly.asm.model.response.ProductResponse;
import nvm.poly.asm.repository.BrandRepository;
import nvm.poly.asm.repository.CategoryRepository;
import nvm.poly.asm.repository.ProductRepository;
import nvm.poly.asm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<ProductResponse> getProductPagination(int page) {
        Pageable pageable = PageRequest.of(page - 1, 5);
        return productRepository.getProductByPage(pageable);
    }

    @Override
    public String addProduct(ProductRequest request) {
        productRepository.save(Product.builder()
                .status(request.getStatus())
                .productName(request.getProductName())
                .id(null)
                .brand(brandRepository.findById(request.getBrandID()).get())
                .category(categoryRepository.findById(request.getCateID()).get())
                .build());
        return "add product successfully";
    }

    @Override
    public String updateProduct(ProductRequest request, Long id) {
        productRepository.save(Product.builder()
                .status(request.getStatus())
                .productName(request.getProductName())
                .id(id)
                .brand(brandRepository.findById(request.getBrandID()).get())
                .category(categoryRepository.findById(request.getCateID()).get())
                .build());
        return "Update product successfully";
    }

    @Override
    public Page<ProductResponse> searchProduct(int page, String productName) {
        Pageable pageable = PageRequest.of(page - 1, 5);
        return productRepository.searchProductByPage(pageable, productName);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.getAllProducts();
    }
}
