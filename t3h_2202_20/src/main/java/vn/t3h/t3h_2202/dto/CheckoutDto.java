package vn.t3h.t3h_2202.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import vn.t3h.t3h_2202.entity.CheckoutEntity;
@Data
@NoArgsConstructor
public class CheckoutDto {
    public int id;
    public int userId;
    public String name;
    public String address;
    public String phone;
    public String notice;
    public int money;

    public CheckoutEntity convertEntity(){
        CheckoutEntity checkoutEntity =new CheckoutEntity();
        checkoutEntity.setUserId(userId);
        checkoutEntity.setName(name);
        checkoutEntity.setAddress(address);
        checkoutEntity.setPhone(phone);
        checkoutEntity.setNotice(notice);
        checkoutEntity.setMoney(money);
        return checkoutEntity;
    }
}
