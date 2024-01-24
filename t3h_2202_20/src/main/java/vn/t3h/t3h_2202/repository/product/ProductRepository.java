package vn.t3h.t3h_2202.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.t3h.t3h_2202.entity.ProductEntity;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>, ProductRepositoryCustom {
//    @Query("select p from ProductEntity p  order by p.id ")
    @Query(value = "select * from product  " +
            " order by id limit 10", nativeQuery = true)
    List<ProductEntity> findTop10();
    @Query(value = "select * from product  " +
            " order by id limit 4", nativeQuery = true)
    List<ProductEntity> findTop4();
//    @Query("select p from ProductEntity p where p.categoryId = ?1")
    List<ProductEntity> findAllByCategoryId(Long categoryId);

//    @Query("select p from ProductEntity p where p.name = ?1")
    List<ProductEntity> findAllByName(String name);

//    @Query("select p from ProductEntity p where p.categoryId = ?1 or p.name = ?2")
    List<ProductEntity> findAllByCategoryIdOrName(Long category, String name);

//    List<ProductEntity> findAllByCreateDateAfter(Timestamp timestamp);


    List<ProductEntity> findAllByCategoryIdGreaterThan(Long id);
    List<ProductEntity> findAllByCategoryIdLessThan(Long id);

//@Query(value = "select  * from product p where p.brandId = ?1 ",nativeQuery = true)
//    List<ProductEntity> findBrand(Long brandId);
    List<ProductEntity> findAllByBrandId(Long brandId);

}
