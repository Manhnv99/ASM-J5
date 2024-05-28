package nvm.poly.asm.service;

import nvm.poly.asm.entity.Size;
import nvm.poly.asm.model.request.SizeRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SizeService {

    List<Size> getAll();

    Page<Size> getAllByPage(int page);

    String add(SizeRequest request);

    String update(SizeRequest request, Long id);

    String delete(Long id);

}
