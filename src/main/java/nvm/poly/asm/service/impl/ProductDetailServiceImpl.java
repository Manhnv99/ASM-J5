package nvm.poly.asm.service.impl;

import nvm.poly.asm.entity.Color;
import nvm.poly.asm.entity.Product;
import nvm.poly.asm.entity.ProductDetail;
import nvm.poly.asm.entity.Size;
import nvm.poly.asm.model.request.ProductDetailRequest;
import nvm.poly.asm.model.response.ProductCardResponse;
import nvm.poly.asm.model.response.ProductDetailResponse;
import nvm.poly.asm.repository.ColorRepository;
import nvm.poly.asm.repository.ProductDetailRepository;
import nvm.poly.asm.repository.ProductRepository;
import nvm.poly.asm.repository.SizeRepository;
import nvm.poly.asm.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private SizeRepository sizeRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<ProductDetailResponse> getAll(Long productID, int page, Long colorID, Long sizeID) {
        Pageable pageable = PageRequest.of(page - 1, 5);
        return productDetailRepository.getAll(pageable, productID, colorID, sizeID);
    }

    @Override
    public String add(ProductDetailRequest request) {

        Color color = colorRepository.findById(request.getColorID()).get();
        Product product = productRepository.findById(request.getProductID()).get();
        Size size = sizeRepository.findById(request.getSizeID()).get();

        productDetailRepository.save(ProductDetail.builder()
                .color(color)
                .id(null)
                .product(product)
                .price(request.getPrice())
                .quanity(request.getQuantity())
                .size(size)
                .status(request.getStatus())
                .build());

        return "Thêm thành công";
    }

    @Override
    public String update(ProductDetailRequest request, Long id) {
        Color color = colorRepository.findById(request.getColorID()).get();
        Product product = productRepository.findById(request.getProductID()).get();
        Size size = sizeRepository.findById(request.getSizeID()).get();

        productDetailRepository.save(ProductDetail.builder()
                .color(color)
                .id(id)
                .product(product)
                .price(request.getPrice())
                .quanity(request.getQuantity())
                .size(size)
                .status(request.getStatus())
                .build());

        return "Sửa thành công";
    }

    @Override
    public String delete(Long id) {
        productDetailRepository.deleteById(id);
        return null;
    }

    @Override
    public ProductDetail getProductDetailById(Long id) {
        return productDetailRepository.findById(id).get();
    }

    @Override
    public List<ProductCardResponse> getAllProductCard() {
        return productDetailRepository.getAllProductCard();
    }

    @Override
    public void updateQuantityProductDetail(Long id, Integer quantity, String method) {
        ProductDetail productDetail = productDetailRepository.findById(id).get();
        if (method.equalsIgnoreCase("minus")) {
            productDetail.setQuanity(productDetail.getQuanity() - quantity);
        } else {
            productDetail.setQuanity(productDetail.getQuanity() + quantity);
        }
        productDetailRepository.save(productDetail);
    }

    @Override
    public boolean existById(Long id) {
        return productDetailRepository.existsById(id);
    }


}
