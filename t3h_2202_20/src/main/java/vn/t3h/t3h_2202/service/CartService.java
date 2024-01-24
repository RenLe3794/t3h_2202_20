package vn.t3h.t3h_2202.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.t3h.t3h_2202.dto.CartDto;
import vn.t3h.t3h_2202.entity.CartEntity;
import vn.t3h.t3h_2202.repository.CartRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CartService {
    @Autowired
    CartRepository cartRepository;

    public List<CartDto> findCartByUserId(int id){
        List<CartEntity> cartEntities = cartRepository.findAllByUserId(id);
        List<CartDto> result = new ArrayList<>();
        for (CartEntity c: cartEntities
             ) {
            CartDto copy = new CartDto();
            BeanUtils.copyProperties(c, copy);
            copy.total = c.quantity * c.getProductEntity().getPrice();
            result.add(copy);
        }
        return result;
    };
    public Long sumMoney(int id){
        Long result=0L, total;
        List<CartEntity> cartEntities = cartRepository.findAllByUserId(id);
        for (CartEntity c: cartEntities
        ) {

            total = c.quantity * c.getProductEntity().getPrice();
            result += total;
        }
        return result;
    };

    public void saveCart(CartDto cartDto) {
        CartEntity cartEntity = cartDto.convertEntity();
        cartRepository.save(cartEntity);
    }

    public  void  deleteCart(int userId, int productId){
        cartRepository.deleteItem(userId, productId);
    }
}
