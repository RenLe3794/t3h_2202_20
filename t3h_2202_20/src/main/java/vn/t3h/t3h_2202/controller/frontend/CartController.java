package vn.t3h.t3h_2202.controller.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.t3h.t3h_2202.service.CartService;

import java.sql.SQLException;

@Controller
@RequestMapping("cart/")
public class CartController {
    @Autowired
    CartService cartService;

    @RequestMapping("/{id}")
    public String cartPage( Model model, @PathVariable int id){
     model.addAttribute("cart",cartService.findCartByUserId(id));
     model.addAttribute("totalMoney",cartService.sumMoney(id));
     model.addAttribute("userId",id);

     return "cart" ;
    }
    @RequestMapping("delete/{UserId}/{ProductId}")
    public String deleteUser(@PathVariable int UserId, @PathVariable int ProductId) throws SQLException {
        System.out.println("User Id:" +UserId);
        cartService.deleteCart(UserId,ProductId);
         return "redirect:/cart/"+ UserId;
    }


}
