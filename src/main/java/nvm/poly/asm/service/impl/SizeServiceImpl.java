package nvm.poly.asm.service.impl;

import nvm.poly.asm.entity.Size;
import nvm.poly.asm.model.request.SizeRequest;
import nvm.poly.asm.repository.SizeRepository;
import nvm.poly.asm.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public List<Size> getAll() {
        return sizeRepository.findAll();
    }

    @Override
    public Page<Size> getAllByPage(int page) {
        Pageable pageable = PageRequest.of(page - 1, 7);
        return sizeRepository.getAllByPage(pageable);
    }

    @Override
    public String add(SizeRequest request) {
        sizeRepository.save(Size.builder()
                .description(request.getDescription())
                .id(null)
                .sizeName(request.getSizeName())
                .build());
        return "THêm thành công";
    }

    @Override
    public String update(SizeRequest request, Long id) {
        sizeRepository.save(Size.builder()
                .description(request.getDescription())
                .id(id)
                .sizeName(request.getSizeName())
                .build());
        return "Sửa thành công";
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
