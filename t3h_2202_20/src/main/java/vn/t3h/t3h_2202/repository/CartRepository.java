package vn.t3h.t3h_2202.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.ModelAttribute;
import vn.t3h.t3h_2202.entity.CartEntity;

import java.util.List;

public interface CartRepository extends JpaRepository<CartEntity, Long> {

    @Query(value = "select * from cart  " +
            " where cart.IDuser = ?1 ", nativeQuery = true)
    List<CartEntity> findAllByUserId(int id);

    @Modifying
    @Query(value = "delete from cart c  where c.IDUSER = ?1 and c.IDPRODUCT =?2 ", nativeQuery = true)
    void deleteItem(int userId, int productId);

}
