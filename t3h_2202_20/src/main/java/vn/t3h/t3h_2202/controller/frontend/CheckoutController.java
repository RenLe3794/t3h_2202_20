package vn.t3h.t3h_2202.controller.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.t3h.t3h_2202.dto.CheckoutDto;
import vn.t3h.t3h_2202.dto.ProductDto;
import vn.t3h.t3h_2202.service.CheckoutService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.sql.SQLException;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {
    @Autowired
    CheckoutService checkoutService;

    @RequestMapping("/{userId}/{Money}")
    public String create(Model model,@PathVariable Long userId,@PathVariable Long Money) {
        model.addAttribute("userId",userId);
        model.addAttribute("Money",Money);
        return "checkout";
    }
    @PostMapping(value = "checkout-form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Transactional
    public String createUserForm(CheckoutDto checkoutDto, RedirectAttributes redirectAttributes,
                                 HttpServletResponse response, HttpServletRequest request
                                 ) throws SQLException {

        checkoutService.saveCheckout(checkoutDto);
     return "redirect:/ThankingPage";
    }


}
