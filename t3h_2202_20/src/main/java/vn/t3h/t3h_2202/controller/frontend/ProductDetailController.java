package vn.t3h.t3h_2202.controller.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.t3h.t3h_2202.dto.BrandDto;
import vn.t3h.t3h_2202.dto.CartDto;
import vn.t3h.t3h_2202.dto.ProductDto;
import vn.t3h.t3h_2202.dto.ReviewDto;
import vn.t3h.t3h_2202.entity.UserEntity;
import vn.t3h.t3h_2202.paging.PagingAndSortObject;
import vn.t3h.t3h_2202.paging.PagingAndSortParam;
import vn.t3h.t3h_2202.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

@Controller
public class ProductDetailController {
    @Autowired
    ProductService productService;
    // Lấy danh sản phẩm theo category id
    @Autowired
    ReviewService reviewService;

    @Autowired
    UserService userService;

    @Autowired
    CartService cartService;
    @GetMapping("product-detail/{id}")
    public String loadPageEdit(Model model, @PathVariable Long id ,Principal principal) {
        model.addAttribute("product", productService.detail(id));
        model.addAttribute("review", reviewService.findAllByProductId(id));
        Long id2 =null;
        try {
            id2 =  ((UserEntity)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        }catch (Exception e){
            System.out.println("Chua dang nhap");
        }
        if (id2 != null)
        model.addAttribute("user", userService.detail(id2));


 //       model.addAttribute("user",userService.detail(id2));

        return "product-detail";
    }

    @PostMapping(value = "review-form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createForm(ReviewDto reviewDto, RedirectAttributes redirectAttributes, Principal principal,
                             HttpServletResponse response, HttpServletRequest request) throws SQLException {
        //   redirectAttributes.addFlashAttribute("message", "Cập nhật tài khoản "  + " thành công!");
//        ((UserEntity) principal).getId();
//        ((UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();

        reviewService.saveReview(reviewDto);
        return "redirect:/home";
    }

    @PostMapping(value = "addCart-form",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addCart(CartDto cartDto, RedirectAttributes redirectAttributes,
                          HttpServletRequest response, HttpServletRequest  requestm,Model model) throws  SQLException {
       Long id2 = null;
        try{
            id2 =  ((UserEntity)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();

        }
        catch (Exception e){
            System.out.println("Chua dang nhap");
        }
        if (id2 != null )
        cartService.saveCart(cartDto);
        else System.out.println("Dang nhap de them gio hang");
 //       Long id2 = ((UserEntity)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        System.out.println(id2);
        return  "redirect:cart/" +id2;
    }

}
