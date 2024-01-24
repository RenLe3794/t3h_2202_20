package vn.t3h.t3h_2202.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.t3h.t3h_2202.dto.UserDto;
import vn.t3h.t3h_2202.entity.UserEntity;
import vn.t3h.t3h_2202.paging.PagingAndSortObject;
import vn.t3h.t3h_2202.repository.product.ProductRepository;
import vn.t3h.t3h_2202.repository.UserContactRepository;
import vn.t3h.t3h_2202.repository.UserRepository;

import java.sql.SQLException;

@Service// tạo ra 1 object được lưu trong spring bean
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserContactRepository userContactRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    public UserDto saveUser(UserDto userDto) {
        UserEntity userEntity = userDto.conVertEntity();
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(userEntity);

//        for (String addr : userDto.getAddress()
//             ) {
//            if (addr == null || addr == "")throw new RuntimeException("địa chỉ " + addr + " Không đúng định dạng");// rollback
//            UserContactEntity userContactEntity = new UserContactEntity();
//            userContactEntity.setAddress(addr);
//            userContactEntity.setUserId(userEntity.getId());
//            userContactRepository.save(userContactEntity);
//        }

        // Lưu vào bảng thông tin liên hệ
//        userDto.getContact()
        return userDto;
    }

    public UserDto editUser(UserDto userDto) {
        UserEntity entity = userRepository.findById(userDto.getId()).get();
        if (entity == null) {
            System.out.println("Không tồn tại user");
            throw new RuntimeException("user không tồn tại");
        }
        UserEntity userEntity = userDto.conVertEntity();
        userRepository.save(userEntity);
        return userDto;
    }

    public UserDto detail(long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(userEntity, dto);
        return dto;
    }
    @Autowired
    ProductRepository productRepository;

    public void danhsach(PagingAndSortObject pagingAndSortObject) throws SQLException {
       pagingAndSortObject.findAll(userRepository);
    }
}
