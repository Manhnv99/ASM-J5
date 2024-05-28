package nvm.poly.asm.repository;

import nvm.poly.asm.entity.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {

    @Query("SELECT s FROM Size s")
    Page<Size> getAllByPage(Pageable pageable);

}
