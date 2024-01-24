package vn.t3h.t3h_2202.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.t3h.t3h_2202.entity.BrandEntity;

import java.util.List;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<BrandEntity, Long> {

    List<BrandEntity> findAll();

    Optional<BrandEntity> findById(Long id);
}
