package vn.t3h.t3h_2202.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.t3h.t3h_2202.entity.CategoryEntity;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
//    @Query(value = "select * from category  " +
//            " where category.id = ?1 ", nativeQuery = true)
//    List<CategoryEntity> findById(int id);
}
