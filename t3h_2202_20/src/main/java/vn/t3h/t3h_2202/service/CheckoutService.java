package vn.t3h.t3h_2202.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.t3h.t3h_2202.dto.CheckoutDto;
import vn.t3h.t3h_2202.entity.CheckoutEntity;
import vn.t3h.t3h_2202.repository.product.CheckoutRepository;

@Service
public class CheckoutService {
    @Autowired
    CheckoutRepository checkoutRepository;
    public CheckoutDto saveCheckout(CheckoutDto checkoutDto){
        CheckoutEntity checkoutEntity = checkoutDto.convertEntity();
        checkoutRepository.save(checkoutEntity);
        return checkoutDto;
    }
}
