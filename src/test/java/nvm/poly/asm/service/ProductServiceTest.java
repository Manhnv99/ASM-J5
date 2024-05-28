package nvm.poly.asm.service;

import nvm.poly.asm.repository.ProductRepository;
import nvm.poly.asm.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;

    @Test
    public void getAll() {
        Pageable pageable = PageRequest.of(1, 5);
        System.out.println(productRepository.getProductByPage(pageable));
    }

}