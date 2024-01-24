package vn.t3h.t3h_2202.dto;

import lombok.Data;
import vn.t3h.t3h_2202.entity.CartEntity;
import vn.t3h.t3h_2202.entity.ProductEntity;

@Data
public class CartDto {
    public Long userId;
    public Long productId;
    public Long quantity;
    public Long total;
    public ProductEntity productEntity;

    public CartEntity convertEntity(){
        CartEntity cartEntity = new CartEntity();
        cartEntity.setUserId(userId);
        cartEntity.setProductId(productId);
        cartEntity.setQuantity(quantity);
        return  cartEntity;
    }

}
