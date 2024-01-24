package vn.t3h.t3h_2202.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.t3h.t3h_2202.entity.UserContactEntity;

public interface UserContactRepository extends JpaRepository<UserContactEntity, Long> {
}
