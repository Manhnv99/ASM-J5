package nvm.poly.asm.service.impl;

import nvm.poly.asm.entity.Color;
import nvm.poly.asm.model.request.ColorRequest;
import nvm.poly.asm.repository.ColorRepository;
import nvm.poly.asm.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public List<Color> getAll() {
        return colorRepository.findAll();
    }

    @Override
    public Page<Color> getAllByPage(int page) {
        Pageable pageable = PageRequest.of(page - 1, 7);
        return colorRepository.getAllByPage(pageable);
    }

    @Override
    public String add(ColorRequest request) {
        colorRepository.save(Color.builder()
                .colorName(request.getColorName())
                .description(request.getDescription())
                .build());
        return "THêm thành công";
    }

    @Override
    public String update(ColorRequest request, Long id) {
        colorRepository.save(Color.builder()
                .colorName(request.getColorName())
                .description(request.getDescription())
                .id(id)
                .build());
        return "Sửa thành công";
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
