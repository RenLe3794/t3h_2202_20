package vn.t3h.t3h_2202.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.t3h.t3h_2202.entity.CheckoutEntity;

public interface CheckoutRepository extends JpaRepository<CheckoutEntity,Long> {
}
